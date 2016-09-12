package ru.timus.acm;

import java.io.PrintWriter;
import java.util.Scanner;

/*
Представьте, как должна выглядеть яблоня в двоичном компьютерном мире.
Вы правы, она выглядит как двоичное дерево, то есть любая ветка двоичной яблони может ветвиться в точности на две новые ветки.
Занумеруем целыми числами корень двоичной яблони, точки ветвления и верхушки верхних ветвей.
Пусть корень дерева всегда имеет номер 1, а все числа, используемые при нумерации, лежат в пределах от 1 до N, где N — общее число пронумерованных точек.
На рисунке ниже приведён пример нумерации дерева с четырьмя ветвями. N здесь равно 5.
2   5
 \ /
  3   4
   \ /
    1
Как вы понимаете, не очень удобно собирать яблоки с яблони, у которой много ветвей.
Вот почему некоторые ветви следует удалить из дерева. Но вы также заинтересованы в удалении ветвей, которое приведёт к минимальной потере яблок.
Известно количество яблок на каждой из ветвей, а также количество ветвей, которые нужно сохранить.
Ваша задача — определить, сколько яблок можно оставить на яблоне, удалив лишние ветви.
Исходные данные
В первой строке даны числа N и Q (2 ≤ N ≤ 100; 1 ≤ Q ≤ N − 1). N обозначает количество пронумерованных точек в дереве, а Q — количество ветвей, которые нужно сохранить.
Следующие N − 1 строк содержат описание ветвей. Описание каждой ветви состоит из трёх чисел, разделённых пробелом.
Первые два из них определяют конечные точки ветви, третье — число яблок на данной ветви. Вы можете считать, что любая ветвь содержит не более 30000 яблок.
Результат
Выведите единственное число — максимальное количество яблок, которое можно сохранить. Не забудьте сохранить корень яблони ;-)
 */

public class Task_1018 {
    private static Branch[][] branches;
    private static int[][] cache;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        solve(in, out);
        out.flush();
    }

    private static void addItem(Branch[] array, Branch item) {
        int i = 0;
        while (array[i] != null) {
            i++;
        }

        array[i] = item;
    }

    private static void removeItem(Branch[] array, int node) {
        for (int i = 0; i < array.length && array[i] != null; i++) {
            if (array[i].other == node) {
                while (i + 1 < array.length) {
                    array[i] = array[i + 1];
                    i++;
                }
                array[array.length - 1] = null;
                break;
            }
        }
    }

    private static void prepare(Branch root) {
        root.totalValue = root.value;
        for (Branch b : branches[root.other]) {
            if (b == null) break;

            removeItem(branches[b.other], root.other);
            prepare(b);
            root.totalValue += b.totalValue;
            root.count += b.count;
        }
    }



    private static int apples(Branch root, int cut) {
        assert cut >= 0 && cut <= root.count;
        if (cut == 0) {
            return root.totalValue;
        } else if (cut == root.count) {
            return 0;
        }

        int result = cache[root.other][cut];
        if (result != -1) {
            return result;
        }

        Branch left = branches[root.other][0];
        Branch right = branches[root.other][1];
        assert branches[root.other][2] == null;

        if (left == null && right == null) {
            return 0;
        } else if (left == null) {
            assert root.count == right.count + 1;
            return root.value + apples(right, cut - 1);
        } else if (right == null) {
            assert root.count == left.count + 1;
            return root.value + apples(left, cut - 1);
        }

        assert left != null && right != null;

        // we have enough branches to cut
        result = 0;

        int childrenCut = cut;
        assert childrenCut <= left.count + right.count;
        for (int cutLeft = Math.max(0, childrenCut - right.count); cutLeft <= left.count; cutLeft++) {
            int cutRight = childrenCut - cutLeft;
            assert cutRight <= right.count;
            if (cutRight < 0) break;

            assert cutLeft >= 0 && cutLeft <= left.count;
            assert cutRight >= 0 && cutRight <= right.count;
            int value = apples(left, cutLeft) + apples(right, cutRight);
            result = Math.max(result, value);
        }

        result += root.value;

        cache[root.other][cut] = result;
        return result;
    }

    private static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int toRemain = in.nextInt();
        int branchCount = n - 1;
        int cut = branchCount - toRemain;

        branches = new Branch[n][3];

        for (int i = 0; i < branchCount; i++) {
            int node1 = in.nextInt() - 1;
            int node2 = in.nextInt() - 1;
            int value = in.nextInt();
            addItem(branches[node1], new Branch(node2, value));
            addItem(branches[node2], new Branch(node1, value));
        }

        Branch root = new Branch(0, 0);
        prepare(root);

        cache = new int[n + 1][cut + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= cut; j++) {
                cache[i][j] = -1;
            }
        }

        out.println(apples(root, cut));
    }

    private static class Branch {
        int other;
        int value;
        int totalValue;
        int count = 1;

        public Branch(int other, int value) {
            this.other = other;
            this.value = value;
        }
    }
}

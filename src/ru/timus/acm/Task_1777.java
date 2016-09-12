package ru.timus.acm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

/*
Исходные данные
В единственной строке через пробел записаны попарно различные целые числа x1, x2 и x3 (1 ≤ x1, x2, x3 ≤ 1018) —
количество камней в кучах, лежавших на поляне в тот момент, когда профессор Баттеруорт позвал первого аборигена.
Результат
Выведите, скольким аборигенам сможет задать свой глупый вопрос профессор Баттеруорт.
 */
public class Task_1777 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        List<Long> list = new ArrayList<>();

        list.add(in.nextLong());
        list.add(in.nextLong());
        list.add(in.nextLong());

        in.close();

        int x = 0;
        while (true) {
            ++x;
            long minDiff = Long.MAX_VALUE;

            for (int i = 1; i < list.size(); i++)
                for (int j = 0; j < i; j++)
                    minDiff = Math.min(minDiff, Math.abs(list.get(i) - list.get(j)));

            if (minDiff == 0) {
                out.println(x);
                break;
            }

            list.add(minDiff);
        }
    }
}

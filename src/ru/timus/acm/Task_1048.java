package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/*
Создатели нового языка программирования D++ поняли, что какое бы большое ограничение на тип SuperLongInt они ни наложили,
некоторым программистам потребуется работать с ещё большими числами.
Ограничение в 1000 цифр так мало… Вам нужно найти сумму двух целых чисел размером до 1 000 000 цифр.
Исходные данные
Первая строка содержит целое число N — длину чисел (1 ≤ N ≤ 1 000 000).
В следующих N строках следуют записанные в столбик числа, каждая строка содержит по две цифры, разделённые пробелом.
Каждое из двух чисел не меньше 1, а длина суммы этих чисел не превосходит N. Числа могут содержать ведущие нули.
Результат
Выведите в одной строке ровно N цифр, представляющих сумму этих двух чисел.
 */

public class Task_1048 {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[] result = new int[n];

        IntStream.range(0, n).forEach(i -> {
            try {
                String[] input = in.readLine().split(" ");

                result[i] = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
                int j = i;
                while (result[j] > 9) {
                    result[j--] -= 10;
                    result[j]++;
                }
            } catch (IOException e) {
            }
        });

        IntStream.range(0, n).forEach(i -> System.out.print(result[i]));
        System.out.println();
    }
}

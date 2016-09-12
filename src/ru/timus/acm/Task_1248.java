package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
/*
Дана последовательность вещественных чисел. Надо их все сложить. Ну, и ещё не забыть вывести результат.
Исходные данные
Первая строка содержит количество чисел N (не более 1000). В последующих N строках, по одному в строке, перечислены числа в экспоненциальной нотации с 19 значащими разрядами в мантиссе.
Все числа лежат в диапазоне от 10−100 до 10100.
Результат
Выведите единственное действительное число — сумму всех содержащихся на входе чисел. Это число следует представить в экспоненциальной форме, указав 19 верных знаков в мантиссе.
 */
public class Task_1248 {

    private static BigDecimal getSum() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            final BigDecimal[] sum = {new BigDecimal(0)};
            in.lines().limit(n).forEach(s -> sum[0] = sum[0].add(new BigDecimal(s)));
            return sum[0].round(new MathContext(19, RoundingMode.HALF_UP));
        } catch (IOException e) {
            return null;
        }
    }

    private static void print(BigDecimal bigDecimal) {
        String line = bigDecimal.unscaledValue().toString();
        System.out.print(line.charAt(0) + ".");

        if (line.length() > 1)
            System.out.print(line.substring(1));

        if (line.length() < 19)
            for (int i = line.length() + 1; i <= 19; ++i)
                System.out.print("0");

        System.out.print("e");
        System.out.println(line.length() - bigDecimal.scale() - 1);
    }

    public static void main(String[] args) {
        print(getSum());
    }
}

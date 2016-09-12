package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
Ваш богатый дядя недавно умер, и нужно поделить наследство между родственниками и церковью (дядя настаивал в своём завещании, что церковь тоже должна получить что-нибудь).
Всего в завещании были упомянуты N родственников (N ≤ 18). Они отсортированы в порядке уменьшения их важности (первый в списке — самый важный).
Поскольку вы — единственный программист в семье, родственники попросили вас помочь им. Им нужна помощь, поскольку в завещании есть несколько пустых мест, которые нужно заполнить.
Вот как выглядит завещание:
Родственник №1 получит 1/... всего наследства,
Родственник №2 получит 1/... всего наследства,
...
Родственник №N получит 1/... всего наследства.
Логичным желанием родственников является заполнить пустые места таким образом, чтобы воля дяди была исполнена (то есть дроби идут в порядке невозрастания, и церковь получает что-нибудь),
но размер наследства, которое останется церкви, был бы минимальным.
Исходные данные
Единственная строка ввода содержит одно целое число N (1 ≤ N ≤ 18).
Результат
Выведите числа, которыми нужно заполнить пустые места в завещании (каждое на отдельной строке), так чтобы размер наследства, которое останется церкви, был минимальным.
 */
public class Task_1108 {

    private static void getInheritance(int n) {
        BigInteger num, denom;
        num = denom = BigInteger.valueOf(1);
        BigInteger prev = BigInteger.valueOf(0);
        for (int i = 1; i <= n; i++) {
            BigInteger part = denom.divide(num);

            if (denom.mod(num).compareTo(BigInteger.valueOf(0)) == 0)
                part = part.add(BigInteger.valueOf(1));

            if (part.compareTo(prev) <= 0)
                part = prev.add(BigInteger.valueOf(1));

            BigInteger tNum = num, tDenom = denom;
            num = part.multiply(tNum).subtract(tDenom);
            denom = tDenom.multiply(part);
            prev = part;

            System.out.println(part);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        getInheritance(Integer.parseInt(in.readLine()));
    }

}

package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
После успеха предыдущей программы Васечкина, позволившей подвести итоги выборов всего за два дня, Васечкин был назначен начальником отдела.
Не правда ли, успех? В данный момент Артемий Сидорович готовит техническое задание для своего подчиненного — программиста Петечкина.
Задание заключается в написании крайне полезной функции, которая намного облегчит жизнь всем программистам отдела.
Для каждого числа от 0 до M функция будет подсчитывать число раз, которое число встречается в N-элементном массиве.
Артемий Сидорович полагает, что функция должна работать следующим образом (пример кода для N = 3, M = 1):
C
if (arr[0]==0) ++count[0];
if (arr[0]==1) ++count[1];
if (arr[1]==0) ++count[0];
if (arr[1]==1) ++count[1];
if (arr[2]==0) ++count[0];
if (arr[2]==1) ++count[1];
Pascal
if arr[0]=0 then count[0] := count[0] + 1;
if arr[0]=1 then count[1] := count[1] + 1;
if arr[1]=0 then count[0] := count[0] + 1;
if arr[1]=1 then count[1] := count[1] + 1;
if arr[2]=0 then count[0] := count[0] + 1;
if arr[2]=1 then count[1] := count[1] + 1;
Артемий Сидорович хочет оценить время, за которое Петечкин справится с заданием.
Известно, что Петечкин пишет одну строчку кода за одну секунду (не правда ли, очень быстро?).
Артемий Сидорович точно не знает, какими M и N можно ограничиться.
Ваша цель — написать программу, которая подсчитает число секунд, которые потребуется Петечкину на написание кода.
Исходные данные
Единственная строка содержит целые числа N (0 ≤ N ≤ 40000) и M (0 ≤ M ≤ 40000).
Результат
Выведите число секунд, требуемых Петечкину на написание функции.
 */
public class Task_1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = consoleReader.readLine().split(" ");
        consoleReader.close();

        System.out.println(Integer.parseInt(input[0]) * (1 + Integer.parseInt(input[1])));
    }
}

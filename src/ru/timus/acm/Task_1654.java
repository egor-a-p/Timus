package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Мюллер много раз пытался поймать Штирлица с поличным, но тот всё время выкручивался.
Как-то раз Штирлиц просматривал электронную почту. В это время незаметно вошел Мюллер и увидел, как у него на экране появился бессмысленный набор символов.
«Шифровка», — подумал Мюллер. «UTF-8», — подумал Штирлиц.
Известно, что Штирлиц шифрует текст следующим образом:
Убирает все пробелы и знаки препинания.
Заменяет все подряд идущие одинаковые буквы на одну такую букву.
Многократно вставляет в произвольное место текста две одинаковых буквы.
Попробуйте восстановить текст, каким он был после второго шага. Для этого удалите из текста все пары одинаковых символов, добавленные на третьем шаге.
Исходные данные
В единственной строке записана шифровка Штирлица, состоящая из строчных латинских букв. Длина шифровки не превосходит 200000.
Результат
Выведите восстановленный текст.
 */
public class Task_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line = consoleReader.readLine();
        StringBuilder output = new StringBuilder();

        for (char c : line.toCharArray()) {
            int l = output.length();
            if (l != 0 && output.charAt(l - 1) == c)
                output.deleteCharAt(l - 1);
            else
                output.append(c);
        }

        System.out.println(output);
    }
}

package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Компания Lavin Interactive, разработчик пошаговой стратегии Losers-V, постоянно расширяет рынки сбыта и создаёт локализации своей игры даже на самые малоизвестные языки.
В том числе, их заинтересовал язык племени австралийских аборигенов аниндилъяква.
Но в языке аниндилъяква нет числительных. Как же, например, перевести на него фразу «у вас семь чёрных драконов, а у вашего врага — сорок»?
Локализаторы решили перевести её так: «у вас немного чёрных драконов, а у вашего врага — толпа».
Они составили таблицу, в которой указали правила замены чисел, обозначающих количество монстров, на существительные и местоимения:
Количество	Обозначение на русском языке	Обозначение на языке аниндилъяква
от 1 до 4	несколько	few
от 5 до 9	немного	several
от 10 до 19	отряд	pack
от 20 до 49	толпа	lots
от 50 до 99	орда	horde
от 100 до 249	множество	throng
от 250 до 499	сонмище	swarm
от 500 до 999	полчище	zounds
от 1000	легион	legion
Помогите локализаторам автоматизировать процесс — напишите программу, которая по количеству монстров выдаст соответствующее этому количеству слово.
Исходные данные
В единственной строке записано целое число n (1 ≤ n ≤ 2000) — количество монстров.
Результат
Выведите слово, соответствующее данному количеству монстров на языке аниндилъяква.
 */
public class Task_1785 {

    private static String getWordByNumber(int number) {
        if (number >= 1 && number <= 4)
            return "few";
        else if (number >= 5 && number <= 9)
            return "several";
        else if (number >= 10 && number <= 19)
            return "pack";
        else if (number >= 20 && number <= 49)
            return "lots";
        else if (number >= 50 && number <= 99)
            return "horde";
        else if (number >= 100 && number <= 249)
            return "throng";
        else if (number >= 250 && number <= 499)
            return "swarm";
        else if (number >= 500 && number <= 999)
            return "zounds";
        else if (number >= 1000)
            return "legion";
        else
            return "";
    }

    public static void main(String str[]) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String result = getWordByNumber(Integer.parseInt(consoleReader.readLine()));
        consoleReader.close();
        if (!result.equals(""))
            System.out.println(result);
    }
}

package ru.timus.acm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Радости Джека не было предела: он успел купить в интернете билеты на полуфинал чемпионата мира по программированию,
который совсем скоро пройдёт в загадочном заокеанском городе Санкт-Петербурге.
Теперь Джеку предстоит трансатлантический перелёт на самом большом пассажирском авиалайнере в мире — Airbus A380.
Джек решил заранее изучить план самолёта по Википедии, чтобы при регистрации на рейс сразу попросить себе удобное место рядом с иллюминатором.
Ну, или возле прохода — Джек ещё не решил.
На Airbus A380 две палубы для пассажиров.
Верхняя палуба предназначена для пассажиров премиум-класса и бизнес-класса.
Места премиум-класса расположены в первом и втором ряду — в каждом ряду по четыре кресла, обозначенных буквами от A до D.
В салоне премиум-класса проходы расположены между первым и вторым и между третьим и четвёртым креслами в ряду.
Ряды с третьего по двадцатый отведены пассажирам бизнес-класса — в каждом ряду по шесть кресел, обозначенных буквами от A до F.
Проходы расположены между вторым и третьим и между четвёртым и пятым креслами в ряду.
На нижней палубе сидят только пассажиры эконом-класса. Ряды занумерованы числами от 21 до 65, в каждом ряду по десять кресел, обозначенных буквами от A до K (буква I не используется).
Проходы расположены между третьим и четвёртым и между седьмым и восьмым креслами в ряду.
Научите Джека определять по обозначению кресла, расположено ли оно возле иллюминатора или возле прохода.
Исходные данные
В единственной строке записано обозначение места — сначала номер ряда, а потом буква, задающая положение кресла в ряду.
Результат
Если место расположено возле иллюминатора, выведите «window». В противном случае, если место расположено у прохода, выведите «aisle».
Если ни одно из условий не выполняется, выведите «neither».
 */
public class Task_1893 {
    static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    final static String WINDOW = "window";
    final static String AISLE = "aisle";
    final static String NEITHER = "neither";

    static String checkFirst(String letter) {
        if (letter.equals("A") || letter.equals("D")) {
            return WINDOW;
        }
        return AISLE;
    }

    static String checkSecond(String letter) {
        if (letter.equals("A") || letter.equals("F")) {
            return WINDOW;
        }
        return AISLE;
    }

    static String checkThird(String letter) {
        if (letter.equals("A") || letter.equals("K")) {
            return WINDOW;
        }
        if (letter.equals("B") || letter.equals("E") ||
                letter.equals("F") || letter.equals("J")) {
            return NEITHER;
        } else {
            return AISLE;
        }
    }

    public static void main(String str[]) throws Exception {
        String place = consoleReader.readLine();

        String letter = place.substring(place.length() - 1).toUpperCase();
        int number = Integer.parseInt(place.substring(0, place.length() - 1));

        String result = "";
        if (number > 0 && number < 3) result = checkFirst(letter);
        else if (number >= 3 && number < 21) result = checkSecond(letter);
        else if (number >= 21 && number < 66) result = checkThird(letter);

        System.out.println(result);
    }
}

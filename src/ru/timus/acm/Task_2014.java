package ru.timus.acm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task_2014 {

    private static TreeMap<Date, Integer> balance = new TreeMap<>();
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM HH:mm");
    private static List<Integer> result;

    public static void main(String[] args) throws Exception {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(consoleReader.readLine());
        result = new ArrayList<>(n);

        for (int i = 0; i < n; i++)
            credit(consoleReader.readLine().split(" "));

        for (int i = 0; i < n; i++)
            System.out.println(result.get(i));
    }

    private static void credit(String[] input) throws ParseException {
        int value = Integer.parseInt(input[0]);
        Date date = format.parse(input[1] + " " + input[2]);
        balance.put(date, value);
        int purse = 0;
        int card = 0;

        for (Map.Entry<Date, Integer> e : balance.entrySet()) {
            int op = e.getValue();
            if (op >= 0)
                purse += op;
            else {
                if (Math.abs(op) <= purse)
                    purse += op;
                else {
                    card += purse + op;
                    purse = 0;
                }
            }
        }

        result.add(card);
    }

}

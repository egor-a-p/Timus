package ru.timus.acm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task_2014 {
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM HH:mm");
    private static Deque<Record> ledger = new LinkedList<>();


    public static void main(String[] args) throws Exception {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(consoleReader.readLine());
        List<Integer> credit = new ArrayList<>(n);

        for (int i = 0; i < n; i++)
            credit.add(addRecord(consoleReader.readLine()));

        credit.stream().forEach(integer -> System.out.println(integer));
    }

    private static int addRecord(String line) throws ParseException {
        Record currentRecord = new Record(line);
        currentRecord.setPurseAndCard(0, 0);

        if (ledger.isEmpty())
            ledger.offerLast(currentRecord);
        else {
            Record previousRecord = ledger.peekLast();
            if (previousRecord.date.compareTo(currentRecord.date) < 0) {
                currentRecord.setPurseAndCard(previousRecord.purse, previousRecord.card);
                ledger.offerLast(currentRecord);
            } else {
                Deque<Record> temp = new LinkedList<>();

                while (!ledger.isEmpty() && ledger.peekLast().date.compareTo(currentRecord.date) > 0)
                    temp.offerLast(ledger.pollLast());

                if (!ledger.isEmpty())
                    currentRecord.setPurseAndCard(ledger.peekLast().purse, ledger.peekLast().card);

                ledger.offerLast(currentRecord);

                while (!temp.isEmpty()) {
                    currentRecord = temp.pollLast();
                    previousRecord = ledger.peekLast();
                    currentRecord.setPurseAndCard(previousRecord.purse, previousRecord.card);
                    ledger.offerLast(currentRecord);
                }
            }
        }

        return ledger.peekLast().card;
    }

    private static class Record {
        int amount, purse, card;
        Date date;

        public Record(String line) throws ParseException {
            String[] input = line.split(" ");
            amount = Integer.parseInt(input[0]);
            this.date = format.parse(input[1] + " " + input[2]);
        }

        public void setPurseAndCard(int previousPurse, int previousCard) {
            if (amount >= 0 || Math.abs(amount) <= previousPurse) {
                purse = previousPurse + amount;
                card = previousCard;
            } else {
                purse = 0;
                card = previousCard + previousPurse + amount;
            }
        }
    }

}

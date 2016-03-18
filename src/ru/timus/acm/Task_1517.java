package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_1517 {

    static class StringSuffix implements Comparable<StringSuffix>{
        char start;
        int indexFrom;

        StringSuffix(String s, int indexFrom) {
            start = s.charAt(indexFrom);
            this.indexFrom = indexFrom;
        }

        public int compareTo(StringSuffix o) {
            int dc = Character.compare(this.start, o.start);
            int di = Integer.compare(this.indexFrom, o.indexFrom);
            if (dc != 0)
                return dc;
            else
                return di;
        }
    }

    private static StringSuffix[] getSuffixes(String input){
        StringSuffix[] suffixes = new StringSuffix[input.length()];
        for (int i = 0; i < input.length(); i++)
            suffixes[i] = new StringSuffix(input, i);

        Arrays.parallelSort(suffixes);
        /*for (StringSuffix s : suffixes)
            System.out.println(input.substring(s.indexFrom));*/
        return suffixes;
    }

    private static boolean contains(StringSuffix[] suffixes, String input, String search){
        StringSuffix s = new StringSuffix(search, 0);
        int ip = Arrays.binarySearch(suffixes, s);
        if (ip < 0)
            ip = -ip - 1;

        return ip < suffixes.length && input.substring(suffixes[ip].indexFrom).startsWith(search);
    }

    private static String getSameSubstring(int n, String line1, String line2){
        StringSuffix[] suffixes = getSuffixes(line2);
        for (int i = n; i > 0; i--)
            for (int j = 0; j + i <= n; j++) {
                String s1 = line1.substring(j, j + i);
                if (contains(suffixes, line2, s1))
                    return s1;
            }

        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(consoleReader.readLine());
        String line1 = consoleReader.readLine();
        String line2 = consoleReader.readLine();
        consoleReader.close();
        System.out.println(getSameSubstring(n, line1, line2));


        /*char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb1.append(c);
            c = chars[random.nextInt(chars.length)];
            sb2.append(c);
        }
        String output1 = sb1.toString().toUpperCase();
        String output2 = sb2.toString().toUpperCase();
        System.out.println(output1);
        System.out.println(output2);

        Date start = new Date();
        System.out.println(getSameSubstring(5000, output1, output2));
        System.out.println("Time: " + (new Date().getTime() - start.getTime()));*/
    }
}

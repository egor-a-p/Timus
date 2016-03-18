package ru.timus.acm;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.concurrent.*;

public class Task_1517 {

    private static String getSpeech(int n, String line1, String line2) throws ExecutionException, InterruptedException {
        Future<String>[] futures = new Future[n];
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = n; i > 0; i--)
            futures[n - i] = service.submit(new Task(n, i, line1, line2));

        for (Future<String> future : futures) {
            String result = future.get();
            if (result != null) {
                service.shutdownNow();
                return result;
            }
        }

        return "";
    }

    private static String randomString(int len) {
        final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        /*BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(consoleReader.readLine());
        String line1 = consoleReader.readLine();
        String line2 = consoleReader.readLine();*/
        int n = 1000;
        String line1 = randomString(n);
        String line2 = randomString(n);
        System.out.println(getSpeech(n, line1, line2));
    }

    private static class Task implements Callable<String> {
        String line1, line2;
        int n;
        int i;

        public Task(int n, int i, String line1, String line2) {
            this.line1 = line1;
            this.line2 = line2;
            this.n = n;
            this.i = i;
        }

        @Override
        public String call() throws Exception {
            HashSet<StringWrapper> set = new HashSet<>(26);
            for (int j = 0; j + i <= n; j++) {
                StringWrapper sw1 = new StringWrapper(line1.substring(j, j + i), 1);
                StringWrapper sw2 = new StringWrapper(line2.substring(j, j + i), 2);
                if (!set.add(sw1))
                    return sw1.string;
                else if (!set.add(sw2))
                    return sw2.string;
            }
            set.clear();
            return null;
        }
    }

    private static class StringWrapper {
        final String string;
        final int id;

        public StringWrapper(String string, int id) {
            this.string = string;
            this.id = id;
        }

        @Override
        public String toString() {
            return string;
        }

        @Override
        public int hashCode() {
            return string.charAt(0);
        }

        @Override
        public boolean equals(Object obj) {
            StringWrapper s = (StringWrapper) obj;

            if (this.id == s.id)
                return false;

            return string.equals(s.string);
        }
    }
}

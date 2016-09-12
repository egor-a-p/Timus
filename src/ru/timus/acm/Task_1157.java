/*
 * Copyright 2016 the original author.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.timus.acm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

/**
 * @author Petrov Egor. Created 10.08.16.
 */
public class Task_1157 {

    public void solve(String[] input){
        if (input.length != 3)
            out.println(0);

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int[] L = new int[10000];

        for (int i = 0; i < L.length; i++) {
            int count = 0;
            int sqrt = (int) Math.sqrt(i);
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            L[i] = count;
        }

        for (int i = K; i < L.length; i++) {
            if (L[i] == M && L[i - K] == N) {
                out.println(i);
                return;
            }
        }

        out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        new Task_1157().solve(input);
    }
}

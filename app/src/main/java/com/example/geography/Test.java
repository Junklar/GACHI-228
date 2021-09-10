package com.example.geography;

import java.util.Random;

public class Test {
    public String[][] testQ;
    public int[] testAns;
    public int[] userAns;

    public Test(String[][] question, int ... ints) {
        final int len = question.length;
        testQ = question;
        testAns = ints;
        userAns = new int[ints.length];
    }

    public static Test[] tests = new Test[]{
            new Test(Q.Q1,2, 3, 4, 4, 1, 2, 2, 4, 3, 1),
            new Test(Q.Q2 , 3)
    };

    public void randomize() {
        final Random r = new Random();
        for (int i = testQ.length - 1; i > 0; i--) {
            final int index = (i-1 != 0) ? r.nextInt(i-1)+1 : 1;
            String[] tmpS = testQ[index]; int tmpAns = userAns[index];
            testQ[index] = testQ[i]; testAns[index] = testAns[i];
            testQ[i] = tmpS; testAns[i] = tmpAns;
        }
    }
}

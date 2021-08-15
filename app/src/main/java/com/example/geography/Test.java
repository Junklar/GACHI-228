package com.example.geography;

import android.util.Log;
import android.widget.CheckBox;

public class Test {
    public final int[] testAns;
    public final boolean[][] ans;
    public final int testIndex;
    public final String[][] strings;
    public Test(int index, int[] tAns, String[][] question) {
        testIndex = index;
        testAns = tAns;
        strings = question;
        ans = new boolean[question.length][question[0].length];
    }

    public static Test[] tests = new Test[]{
            new Test(0, new int[]{
                    2, 3, 4, 4, 1, 2, 2, 4, 3, 1
            }, Q.Q1),
            new Test(1, new int[]{
                    3
            }, Q.Q2)
    };
}

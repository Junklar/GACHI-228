package com.example.geography;

import android.os.Bundle;

import androidx.fragment.app.*;

public class TestPagerAdapter extends FragmentPagerAdapter {
    private Test test;
    public TestPagerAdapter(FragmentManager fm, Test test) { super(fm); this.test = test; }

    public Fragment getItem(int position) {
        Fragment fragment = new TestQFragment();
        Bundle args = new Bundle();
        args.putString(TestQFragment.QTEXT, test.testQ[position][0]);
        args.putString(TestQFragment.RADIO1, test.testQ[position][1]);
        args.putString(TestQFragment.RADIO2, test.testQ[position][2]);
        args.putString(TestQFragment.RADIO3, test.testQ[position][3]);
        args.putString(TestQFragment.RADIO4, test.testQ[position][4]);
        fragment.setArguments(args);
        return fragment;
    }

    public CharSequence getPageTitle(int position) { return String.valueOf(position + 1); }
    public int getCount() { return test.testAns.length; }
}

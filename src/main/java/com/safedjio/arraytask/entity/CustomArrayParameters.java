package com.safedjio.arraytask.entity;

public class CustomArrayParameters {
    private int min;
    private int max;
    private int sum;
    private double average;

    public CustomArrayParameters(int sum, int min, int max, double average) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.average = average;
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }

    public double getAverage(){
        return average;
    }

    public int getSum(){
        return sum;
    }
}

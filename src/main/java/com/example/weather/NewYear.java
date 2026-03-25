package com.example.weather;

import java.util.Random;

public class NewYear {
    public int[] number;
    public int max;
    public int min;
    private int year;


    public NewYear() {
        this.number = new int[12];
        this.max = 0;
        this.min = 100;
        this.year = 0;

        Random rand = new Random();
        for (int i = 0; i < 12; i++) {
            this.number[i] = rand.nextInt(41);
            this.max = Math.max(this.max, this.number[i]);
            this.min = Math.min(this.min, this.number[i]);
        }
    }


    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return min;
    }


    public int[] getNumber() {
        return number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
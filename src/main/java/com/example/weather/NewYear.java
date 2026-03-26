package com.example.weather;

import java.util.Random;

public class NewYear {
    public int[] number;
    public int max;
    public int min;
    private int year;
    final int START_MAX_NUMBER = 0;
    final int START_MIN_NUMBER = 100;
    final int MONTHS = 12;
    final int MAX_FOR_RANDOM_NUMBERS = 41;

    /**Create 12 random number for 12 month.
     * Saved the max number and min number.
     *
     */
    public NewYear() {
        this.number = new int[MONTHS];
        this.max = START_MAX_NUMBER;
        this.min = START_MIN_NUMBER;
        this.year = 0;

        Random rand = new Random();
        for (int i = 0; i < MONTHS; i++) {
            this.number[i] = rand.nextInt(MAX_FOR_RANDOM_NUMBERS);
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
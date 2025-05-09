package com.juaracoding.oop;

public class kotak {
    int sisi;

    protected Kotak(int s) {
        sisi = s;
    }

    protected void draw() {
        for (int i = 0; i < sisi; i++) {
            for (int j = 0; j < sisi; j++) {
                System.out.println("*");
            }
            System.out.println();
        }
    }
}

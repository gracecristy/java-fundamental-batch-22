package utils;

import java.util.Scanner;

public class PracticeLooping {
    public static void main(String[] args) {
        int result = 10;
        for (int i = 0; i < result; i++) {
            for (int j = 0; j < result; j++) {
                if (i > j) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        int tinggi = 10;
        for (int i = 1; i <= tinggi; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        int sum = 0;
        int item = 0;
        while (item < 5) {
            ++item;
            if (item == 2) continue;
            sum += item;
        }
        System.out.println(sum);


        Scanner scanner = new Scanner(System.in);
        int pin = 123456;
        boolean isBlocked = false;
        int count = 0;
        int maxLooping = 3;
        do {
            System.out.println("input pin = ");
            int inputPin = scanner.nextInt();
            if (inputPin == pin) {
                System.out.println("lanjutkan transaksi");
                break;
            }
            count++;
            if (count == maxLooping) {
                isBlocked = true;
                break;
            }
            System.out.println("pin salah. coba lagi");
        } while (count < maxLooping); // 3x false
        if (isBlocked) {
            System.out.println("pin di blokir sementara");
        } else {
            System.out.println("transaksi dilanjutkan");
        }
    }
}
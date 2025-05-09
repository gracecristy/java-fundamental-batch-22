package utils;

public class Perulangan {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        System.out.println("Next statement");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {//0 % 2 = 0
                System.out.println(i);
            }
        }
        for (int i = 1; i < 10; i += 2) {
            System.out.println(i);
        }
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            i++;
        }
        System.out.println();
        int sisi = 15;
        for (int i = 0; i < sisi; i++) {
            for (int j = 0; j < sisi; j++) {
                System.out.print("*");
            }
            System.out.println();


        }
    }
}

//13579
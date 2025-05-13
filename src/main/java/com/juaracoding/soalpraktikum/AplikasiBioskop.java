package com.juaracoding.soalpraktikum;

import java.util.Scanner;

public class AplikasiBioskop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array untuk menyimpan daftar film
        String[] daftarFilm = new String[10];
        int jumlahFilm = 0;

        // Inisialisasi film awal
        daftarFilm[jumlahFilm++] = "Avengers Infinity War";
        daftarFilm[jumlahFilm++] = "Jumbo";

        // Fungsi Login, jika berhasil tampilkan menu utama
        boolean loginBerhasil = login(scanner);
        if (loginBerhasil) {
            tampilkanMenu(scanner, daftarFilm, jumlahFilm);
        }
        scanner.close();
    }

    // Method Login
    private static boolean login(Scanner scanner) {
        String username = "admin";
        String password = "12345";
        boolean isActive = false;
        boolean isBlocked = false;
        int count = 0;
        int maxLooping = 3;

        do {
            System.out.println("\n=== Login ===");
            System.out.print("Masukkan username : ");
            String inUsername = scanner.next();
            System.out.print("Masukkan Password : ");
            String inPassword = scanner.next();
            count++;
            if (username.equals(inUsername) && password.equals(inPassword)) {
                System.out.println("Login berhasil!");
                isActive = true;
                break;
            } else {
                System.out.println("Username dan password salah! Silahkan coba lagi");
            }
            if (count == maxLooping) {
                isBlocked = true;
                System.out.println("Akun Anda telah diblokir setelah 3 kali percobaan gagal.");
            }
        } while (!isActive && !isBlocked);
        scanner.nextLine();

        return isActive;
    }

    // Method untuk Menu Utama
    private static void tampilkanMenu(Scanner scanner, String[] daftarFilm, int jumlahFilm) {
        boolean jalan = true;
        while (jalan) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Tampilkan Daftar Film");
            System.out.println("2. Input Data Film");
            System.out.println("3. Cari Film");
            System.out.println("4. Keluar");
            System.out.print("Masukkan angka pilihan menu : ");

            String pilihanInput = scanner.nextLine();

            switch (pilihanInput) {
                case "1":
                    tampilkanFilm(daftarFilm, jumlahFilm);
                    pauseReturnToMenu(scanner);
                    break;
                case "2":
                    jumlahFilm = inputDataFilm(scanner, daftarFilm, jumlahFilm);
                    pauseReturnToMenu(scanner);
                    break;
                case "3":
                    cariFilm(scanner, daftarFilm, jumlahFilm);
                    pauseReturnToMenu(scanner);
                    break;
                case "4":
                    System.out.println("Terima kasih sudah menggunakan aplikasi film bioskop!");
                    jalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba kembali");
                    pauseReturnToMenu(scanner);
            }
            System.out.println();
        }
    }

    // Method menampilkan daftar film
    private static void tampilkanFilm(String[] daftarFilm, int jumlahFilm) {
        System.out.println("\n=== Daftar Film ===");
        if (jumlahFilm == 0) {
            System.out.println("Belum ada film yang tersedia.");
        } else {
            for (int i = 0; i < jumlahFilm; i++) {
                System.out.printf("%d. %s%n", i + 1, daftarFilm[i]);
            }
        }
    }

    // Method menambahkan film baru
    private static int inputDataFilm(Scanner scanner, String[] daftarFilm, int jumlahFilm) {
        System.out.println("=== Input Film ===");
        System.out.print("Masukkan jumlah film (maksimal 10 film) : ");

        int jumlahInput = scanner.nextInt();
        scanner.nextLine();

        if (jumlahInput < 1 || jumlahInput > 10) {
            System.out.println("Jumlah film harus di antara 1-10");
            return jumlahFilm;
        }
        if ((jumlahFilm + jumlahInput) > 10) {
            System.out.println("Maaf, tidak bisa menambahkan " + jumlahInput + " film.");
            System.out.println("Sisa kapasitas: " + (10 - jumlahFilm) + " film");
            return jumlahFilm;
        }
        System.out.println("Masukkan judul-judul film : ");
        for (int i = 0; i < jumlahInput; i++) {
            System.out.printf("Film ke-%d: ", (jumlahFilm + 1));
            String judulBaru = scanner.nextLine();
            daftarFilm[jumlahFilm] = judulBaru;
            jumlahFilm++;
            System.out.println("Film \"" + judulBaru + "\" berhasil ditambahkan");
        }
        System.out.println("Total film yang berhasil ditambahkan : " + jumlahInput);

        return jumlahFilm;
    }

    // Method mencari data film berdasarkan judul
    private static void cariFilm(Scanner scanner, String[] daftarFilm, int jumlahFilm) {
        System.out.println("\n=== Cari Film ===");
        System.out.print("Masukkan judul film yang dicari: ");
        String judulDicari = scanner.nextLine();
        boolean ditemukan = false;

        System.out.println("\nHasil pencarian:");
        for (int i = 0; i < jumlahFilm; i++) {
            if (daftarFilm[i].equalsIgnoreCase(judulDicari)) {
                System.out.println("- " + daftarFilm[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Film dengan judul \"" + judulDicari + "\" tidak ditemukan.");
        }
    }

    // Method pause layar sebelum kembali ke menu utama
    private static void pauseReturnToMenu(Scanner scanner) {
        System.out.println("\nTekan Enter untuk kembali ke menu utama.");
        scanner.nextLine();
    }
}


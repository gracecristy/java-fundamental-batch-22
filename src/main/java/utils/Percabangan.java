package utils;

import java.util.Scanner;
public class Percabangan {
    public static void main(String[] args) {
        String email = "grace@gmail.com";
        String password = "12323";
        String phoneNumber = "081283334687";

        boolean isRegistered = false;
        boolean isOTPReceived = false;
        boolean isOTPExpired = false;
        boolean isBlocked = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input email / nomor HP: ");
        String inEmailOrPhoneNumber = scanner.next();

        if (email.equals(inEmailOrPhoneNumber) || phoneNumber.equals(inEmailOrPhoneNumber)) {
           if (isBlocked){
               System.out.println("Akun anda telah terblokir");
           }
            isRegistered = true;
            if (isRegistered) {
                isOTPReceived = true;
                if (isOTPReceived) {
                    System.out.println("Silahkan input OTP");
                    isOTPExpired = false;
                    if (isOTPExpired) {
                        System.out.println("Redirect ke Dashboard");
                    } else {
                        System.out.println("OTP Expired");
                    }
                } else {
                    System.out.println("Kirim ulang OTP");
                }

            }

        } else {
            System.out.println("Email / Nomor HP belum terdaftar");
        }
    }
}

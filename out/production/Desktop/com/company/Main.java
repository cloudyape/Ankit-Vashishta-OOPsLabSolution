package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your First Name");
        String str1 = sc.nextLine();
        System.out.print("Enter your Second Name");
        String str2 = sc.nextLine();
        new Employee(str1, str2);
        System.out.println("Press Enter Department from Following (Press the relevant Number)");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        int str3 = sc.nextInt();
        String department = sc.nextLine();
        switch(str3) {
            case 1:
                department = "Technical";
                break;
            case 2:
                department = "Admin";
                break;
            case 3:
                department = "hr";
                break;
            case 4:
                department = "Legal";
                break;
            default:
                System.out.println("Please Input Relevant Number");
        }

        CredentialService cred = new CredentialService();
        System.out.println("Cred" + cred);
        System.out.println("Hi" + Employee.name);
        System.out.println("Pass" + cred);
        System.out.println("Email" + Employee.email + "@" + department + ".abc.com");
    }
}

class Employee {
    public static String name;
    public static String email;

    public Employee(String fname, String lname) {
        name = fname + " " + lname;
        email = fname + lname;
    }
}

class CredentialService {
    public static char[] credential;

    CredentialService() {
    }

    public static char[] CredentialService() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedPass = capitalLetters + smallLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[8];
        password[0] = smallLetters.charAt(random.nextInt(smallLetters.length()));
        password[1] = capitalLetters.charAt(random.nextInt(capitalLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i < 8; ++i) {
            password[i] = combinedPass.charAt(random.nextInt(combinedPass.length()));
        }

        return password;
    }
}

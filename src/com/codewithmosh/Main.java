package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int PERCENT = 100;
        final int YEARS = 12;
        int principal = 0;
        float annualInterestRate = 0.0F;
        float monthlyInterestRate = 0.0F;
        int period = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1K-$1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Please enter a number between 1K and 1M");
        }

        while (true) {
            System.out.print("Annual Interest Rate (%): ");
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / PERCENT / YEARS;
                break;
            }
            System.out.println("Please enter a number between 1 and 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextInt();
            if (period >= 0 && period <= 30) {
                period = period * YEARS;
                break;
            }
            System.out.println("Please enter a number between 1 and 30");
        }

        double mortgageRaw = principal *
                (((Math.pow((1 + monthlyInterestRate), period)) * monthlyInterestRate)
                        / ((Math.pow((1 + monthlyInterestRate), period)) - 1));

        String mortgage = NumberFormat.getCurrencyInstance().format(mortgageRaw);

        System.out.println("Mortgage: " + mortgage);

    }
}

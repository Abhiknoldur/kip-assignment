package com.knoldus;

import java.util.Scanner;

public class Conversion {
    public static void main(String args[]) {
        char us_dollar_sym = 36;
        char pound_sym = 163;
        char yen_sym = 165;
        char euro_sym = 8364;
        char inr_sym = 8377;

        String us_dollar = "Dollars";
        String pound = "Pounds";
        String yen = "Yen";
        String euro = "Euros";
        String inr = "Indian Rupees";
        double rate;


        System.out.println("Welcome to the Currency Converter\n");
        System.out.println("Enter your choices-> \n 1 - US dollars \n 2 - Euros \n 3 - British Pounds \n 4 - Japanese Yen \n 5 - INDIAN INR");


        System.out.println("Please choose the input currency->");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        String inType;
        switch (choice) {
            case 1:
                inType = "US Dollars ->" + us_dollar_sym;
                break;
            case 2:
                inType = "Euros -> " + euro_sym;
                break;
            case 3:
                inType = "British Pounds -> " + pound_sym;
                break;
            case 4:
                inType = "Japanese Yen -> " + yen_sym;
                break;
            case 5:
                inType = "Indian INR -> " + inr_sym;
                break;
            default:
                System.out.println("You opted a wrong choice !");
                return;
        }

        System.out.println("Please choose the output currency->");
        int output = in.nextInt();


        if (choice == output) {
            System.out.println("Same currency no need to convert !");
        } else {
            System.out.print("Now enter the input in ->" + inType);
            double input = in.nextDouble();
            if (choice == 1 && output == 2) {
                double dollar_euro_rate = 0.78391;
                rate = input * dollar_euro_rate;
                System.out.printf("%s" + input + " Dollars to %s = %.2f\n", us_dollar_sym, euro, rate);
            } else if (choice == 1 && output == 3) {
                double dollar_pound_rate = 0.621484;
                rate = input * dollar_pound_rate;
                System.out.printf("%s" + input + " Dollars to %s = %.2f\n", us_dollar_sym, pound, rate);
            } else if (choice == 1 && output == 4) {
                double dollar_yen_rate = 107.174;
                rate = input * dollar_yen_rate;
                System.out.printf("%s" + input + " Dollars to %s = %.2f\n", us_dollar_sym, yen, rate);
            } else if (choice == 1 && output == 5) {
                double dollar_inr_rate = 68.77;
                rate = input * dollar_inr_rate;
                System.out.printf("%s" + input + " Dollars to %s = %.2f\n", us_dollar_sym, inr, rate);
            }
            if (choice == 2 && output == 1) {
                double euro_dollar_rate = 1.27579;
                rate = input * euro_dollar_rate;
                System.out.printf("%s" + input + " Euros to %s = %.2f\n", euro_sym, us_dollar, rate);
            } else if (choice == 2 && output == 3) {
                double euro_pound_rate = 0.792648;
                rate = input * euro_pound_rate;
                System.out.printf("%s" + input + " Euros to %s = %.2f\n", euro_sym, pound, rate);
            } else if (choice == 2 && output == 4) {
                double euro_yen_rate = 136.708;
                rate = input * euro_yen_rate;
                System.out.printf("%s" + input + " Euros to %s = %.2f\n", euro_sym, yen, rate);
            } else if (choice == 2 && output == 5) {
                double euro_inr_rate = 80.83;
                rate = input * euro_inr_rate;
                System.out.printf("%s" + input + " Euros to %s = %.2f\n", euro_sym, inr, rate);
            }
            if (choice == 3 && output == 1) {
                double pound_dollar_rate = 1.60972;
                rate = input * pound_dollar_rate;
                System.out.printf("%s" + input + " Pounds to %s = %.2f\n", pound_sym, us_dollar, rate);
            } else if (choice == 3 && output == 2) {
                double pound_euro_rate = 1.26161;
                rate = input * pound_euro_rate;
                System.out.printf("%s" + input + " Pounds to %s = %.2f\n", pound_sym, euro, rate);
            } else if (choice == 3 && output == 4) {
                double pound_yen_rate = 172.511;
                rate = input * pound_yen_rate;
                System.out.printf("%s" + input + " Pounds to %s = %.2f\n", pound_sym, yen, rate);
            } else if (choice == 3 && output == 5) {
                double pound_inr_rate = 91.37;
                rate = input * pound_inr_rate;
                System.out.printf("%s" + input + " Pounds to %s = %.2f\n", pound_sym, inr, rate);
            }
            if (choice == 4 && output == 1) {
                double yen_dollar_rate = 0.00932574;
                rate = input * yen_dollar_rate;
                System.out.printf("%s" + input + " Yen to %s = %.2f\n", yen_sym, us_dollar, rate);
            } else if (choice == 4 && output == 2) {
                double yen_euro_rate = 0.00730615;
                rate = input * yen_euro_rate;
                System.out.printf("%s" + input + " Yen to %s = %.2f\n", yen_sym, euro, rate);
            } else if (choice == 4 && output == 3) {
                double yen_pound_rate = 0.00579135;
                rate = input * yen_pound_rate;
                System.out.printf("%s" + input + " Yen to %s = %.2f\n", yen_sym, pound, rate);
            } else if (choice == 4 && output == 5) {
                double yen_inr_rate = 0.62;
                rate = input * yen_inr_rate;
                System.out.printf("%s" + input + " Yen to %s = %.2f\n", yen_sym, inr, rate);
            }
            if (choice == 5 && output == 1) {
                double inr_dollar_rate = 0.015;
                rate = input * inr_dollar_rate;
                System.out.printf("%s" + input + " INR to %s = %.2f\n", inr_sym, us_dollar, rate);
            } else if (choice == 5 && output == 2) {
                double inr_euro_rate = 0.012;
                rate = input * inr_euro_rate;
                System.out.printf("%s" + input + " INR to %s = %.2f\n", inr_sym, euro, rate);
            } else if (choice == 5 && output == 3) {
                double inr_pound_rate = 0.011;
                rate = input * inr_pound_rate;
                System.out.printf("%s" + input + " INR to %s = %.2f\n", inr_sym, pound, rate);
            } else if (choice == 5 && output == 4) {
                double inr_yen_rate = 1.61;
                rate = input * inr_yen_rate;
                System.out.printf("%s" + input + " INR to %s = %.2f\n", inr_sym, inr, rate);
            }
            System.out.println("Your Conversion done Successfully !!");
        }
    }
}
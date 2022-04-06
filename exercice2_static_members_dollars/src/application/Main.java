package application;

import entites.CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the dollar price? ");
        double quotation = input.nextDouble();
        System.out.print("How many dollars will be bought? ");
        double dollarValue = input.nextDouble();
        System.out.printf("Amount to be paid in reais = R$%.2f%n", CurrencyConverter.dollarToReal(dollarValue, quotation));
    }
}

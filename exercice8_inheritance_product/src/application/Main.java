package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> productList = new ArrayList<>();
        System.out.print("Enter the number of products: ");
        int numberOfProducts = input.nextInt();
        for(int i = 0; i < numberOfProducts; i++){
            System.out.printf("Product #%d data:%n", i + 1);
            System.out.print("Common, used or import (c/u/i)? ");
            char productType = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();

            switch(productType) {

                case ('c'):
                    Product product = new Product(name, price);
                    productList.add(product);
                    break;

                case ('u'):
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    Date manufactureDate = sdf.parse(input.next());
                    Product usedProduct = new UsedProduct(name, price, manufactureDate);
                    productList.add(usedProduct);
                    break;

                case ('i'):
                    System.out.print("Customs fee: ");
                    double customsFee = input.nextDouble();
                    Product importedProduct = new ImportedProduct(name, price, customsFee);
                    productList.add(importedProduct);
                    break;
            }
        }
        System.out.println("PRICE TAGS:");
        for(Product product : productList){
            String tag = product.priceTag();
            System.out.println(tag);
        }

        input.close();
    }
}

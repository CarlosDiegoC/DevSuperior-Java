package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = input.nextLine();
        System.out.print("Email: ");
        String clientEmail = input.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirthDate = sdf1.parse(input.next());
        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(input.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int numberOfItems = input.nextInt();
        for(int i = 0; i < numberOfItems; i++){
            System.out.printf("Enter #%d item data:%n", i + 1 );
            System.out.print("Product name: ");
            input.nextLine();
            String productName = input.nextLine();
            System.out.print("Product price: ");
            double productPrice = input.nextDouble();
            Product product = new Product(productName, productPrice);
            System.out.print("Quantity: ");
            int quantity = input.nextInt();
            OrderItem orderItem = new OrderItem(quantity, product.getPrice(),product);
            order.addItem(orderItem);
        }
        System.out.println(order);

    }
}

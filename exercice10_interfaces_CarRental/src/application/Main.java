package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("Enter rental data");
        System.out.print("Carl model: ");
        String carModel = input.nextLine();
        System.out.print("Pickup (dd/mm/yyyy hh:mm): ");
        Date startDate = sdf.parse(input.nextLine());
        System.out.print("Return (dd/mm/yyyy hh:mm): ");
        Date finishDate = sdf.parse(input.nextLine());
        CarRental carRental = new CarRental(startDate, finishDate, new Vehicle(carModel));
        System.out.print("Enter price per hour: ");
        double pricePerHour = input.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = input.nextDouble();
        System.out.println("INVOICE:");
        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(carRental);
        System.out.println(carRental.getInvoice());
        input.close();
    }
}

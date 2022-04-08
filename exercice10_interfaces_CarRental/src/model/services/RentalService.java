package model.services;

import model.entities.CarRental;
import model.entities.Invoice;
import model.interfaces.ITaxService;

public class RentalService {
    private double pricePerHour;
    private double pricePerDay;
    private final ITaxService iTaxService;

    public RentalService(double pricePerHour, double pricePerDay, ITaxService iTaxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.iTaxService = iTaxService;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void processInvoice(CarRental carRental){
        long startDate = carRental.getStart().getTime();
        long finishDate = carRental.getFinish().getTime();
        double duration = (double)(finishDate - startDate) / 1000 / 60 / 60;
        double basicPayment;

        if(duration <= 12.00){
            basicPayment = pricePerHour * Math.ceil(duration);
        }
        else {
            duration = Math.ceil(duration / 24);
            basicPayment = pricePerDay * Math.ceil(duration);
        }
        double tax = iTaxService.taxService(basicPayment);
        Invoice invoice = new Invoice(basicPayment, tax);
        carRental.setInvoice(invoice);
    }
}

package model.entities;

public class Invoice {
    private double basicPayment;
    private double tax;
    private final double totalPayment;

    public Invoice(double basicPayment, double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
        this.totalPayment = basicPayment + tax;
    }

    public double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    @Override
    public String toString(){
        String retorno = "";
        retorno += "Basic payment: $" + String.format("%.2f%n", basicPayment);
        retorno += "Tax: $" + String.format("%.2f%n", tax);
        retorno += "Total payment: $" + String.format("%.2f%n", totalPayment);
        return retorno;
    }

}

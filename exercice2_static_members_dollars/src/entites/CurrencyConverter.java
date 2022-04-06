package entites;

public class CurrencyConverter {

    public static final double IOF = 0.06;

    public static double dollarToReal(double dollarValue, double quotation){
        return (dollarValue * quotation ) * (1 + IOF);
    }
}

package model.services;

import model.interfaces.ITaxService;

public class BrazilTaxService implements ITaxService {
    public double taxService(double value){
        if(value <= 100.00){
            return value * 0.2;
        }
        else {
            return value * 0.15;
        }
    }
}

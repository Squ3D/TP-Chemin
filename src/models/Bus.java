package models;

public class Bus extends Vehicule {

    public Bus(Ville origine, Ville destination, String means, int departureTime, int duration, int financialCost, int co2, int confort) {
        super(origine, destination, means, departureTime, duration, financialCost, co2, confort);
    }
}

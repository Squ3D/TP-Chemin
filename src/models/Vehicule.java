package models;

public class Vehicule {

    private Ville origine;
    private Ville destination;
    private String means;
    private int departureTime;
    private int duration;
    private int financialCost;
    private int co2;
    private int confort;
    private int nbRepetitions;
    private int frequence;


    public Vehicule(Ville origine, Ville destination, String means, int departureTime, int duration, int financialCost, int co2, int confort) {
        this.origine = origine;
        this.destination = destination;
        this.means = means;
        this.departureTime = departureTime;
        this.duration = duration;
        this.financialCost = financialCost;
        this.co2 = co2;
        this.confort = confort;
    }

    public Ville getOrigine() {
        return origine;
    }

    public void setOrigine(Ville origine) {
        this.origine = origine;
    }

    public Ville getDestination() {
        return destination;
    }

    public void setDestination(Ville destination) {
        this.destination = destination;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFinancialCost() {
        return financialCost;
    }

    public void setFinancialCost(int financialCost) {
        this.financialCost = financialCost;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getConfort() {
        return confort;
    }

    public void setConfort(int confort) {
        this.confort = confort;
    }

    public int getNbRepetitions() {
        return nbRepetitions;
    }

    public void setNbRepetitions(int nbRepetitions) {
        this.nbRepetitions = nbRepetitions;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
}

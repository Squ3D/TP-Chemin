package Chemin;

import java.time.LocalTime;

import models.Ville;

public class TrajetSimple implements  Cloneable {
    Ville depart;
    Ville arrivee;
    double distance;
    double cout;
    Moyen moyen;
    int duree;
    LocalTime dateDepart;
    LocalTime dateArrivee;
    
  
    public TrajetSimple() {
    	
    }

    public TrajetSimple(Ville _depart, Ville _arrivee,  int _dateDepart, String _moyen) {
        depart = _depart;
        arrivee = _arrivee;
        distance  = Ville.getDist(depart,  arrivee);
        moyen = Moyen.valueOf(_moyen.toUpperCase());
        int hh = _dateDepart / 100;
        int mm = _dateDepart - hh*100;
        dateDepart = LocalTime.of(hh, mm);
        calcule();
    }

    TrajetSimple(Ville _depart, Ville _arrivee,  LocalTime _dateDepart, Moyen _moyen) {
        depart = _depart;
        arrivee = _arrivee;
        distance  = Ville.getDist(depart,  arrivee);
        moyen = _moyen;
        dateDepart = _dateDepart;
        calcule();
    }

   
    private void calcule() {
        duree = (distance==-1?-1:(int) (60d*distance / moyen.v));
        dateArrivee = (distance==-1?null:dateDepart.plusMinutes((int)duree));
        cout = (distance==-1?-1:distance*moyen.cout);
    }

   

    @Override
	public String toString() {
		return "TrajetSimple [depart=" + depart + ", arrivee=" + arrivee + ", distance=" + distance + ", cout=" + cout
				+ ", moyen=" + moyen + ", duree=" + duree + ", dateDepart=" + dateDepart + ", dateArrivee="
				+ dateArrivee + "]";
	}

	public Ville getDepart() {
		return depart;
	}

	public void setDepart(Ville depart) {
		this.depart = depart;
	}

	public Ville getArrivee() {
		return arrivee;
	}

	public void setArrivee(Ville arrivee) {
		this.arrivee = arrivee;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getCout() {
		return cout;
	}

	public void setCout(double cout) {
		this.cout = cout;
	}

	public Moyen getMoyen() {
		return moyen;
	}

	public void setMoyen(Moyen moyen) {
		this.moyen = moyen;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public LocalTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalTime dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	@Override
    protected TrajetSimple clone() {
        TrajetSimple clone=null;
        try { clone = (TrajetSimple) super.clone(); }
        catch (CloneNotSupportedException e) { e.printStackTrace();}
        return (TrajetSimple)clone;
    }
}

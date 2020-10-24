package Chemin;


import java.time.LocalTime;
import java.util.*;

import models.Ville;

public class Catalogue {
  
    HashMap<Ville, List<TrajetSimple>> catalogue;

    Catalogue() {
        catalogue = new HashMap<>();
    }

    void addTrajetSimple(TrajetSimple trajet) {
        catalogue.compute(trajet.depart,
                (v, l) -> {
                	
                if(l==null) {
                	l = new ArrayList<>();
                	} l.add(trajet); 
                	
                	return l;
                	
                           });
    }

    public List<TrajetSimple> trouveCheminsDirects(Ville depart,Ville arrivee, LocalTime dateDepart, int delaiMax) {
        List<TrajetSimple> cheminsDirects = null;
        List<TrajetSimple> trajets = catalogue.get(depart);
        if (trajets != null) {
            cheminsDirects = new ArrayList<>(trajets);
            LocalTime dateDepartMax = dateDepart.plusMinutes(delaiMax);
            cheminsDirects.removeIf(t->(t.arrivee != arrivee  || t.dateDepart.isBefore(dateDepart) || t.dateDepart.isAfter(dateDepartMax) ) );
            if (cheminsDirects.isEmpty()) cheminsDirects = null;
        }
        return cheminsDirects ;
    }
    
    public void creerCatalogue(List<TrajetSimple> listeTrajets)
	{
		//génère la map en groupant les trajets par ville de départ
		//this.catalogue = listeTrajets.stream().collect(Collectors.groupingBy(Trajet::getOrigine));
	}



    

}

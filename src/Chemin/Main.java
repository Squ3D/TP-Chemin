package Chemin;

import com.opencsv.CSVReader;
import static Chemin.Moyen.BUS;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Ville;
import java.util.Scanner;
public class Main extends Application 

{

    private HashMap<String, Ville> villeList = new HashMap<>();
    public List<TrajetSimple> trajetSimpleList = new ArrayList<>();
    private Catalogue catalogue = new Catalogue();
    private Group root = new Group();
    private int espace = 15;
    private double scale = 15;
    Scanner sc = new Scanner(System.in);


    
    public void initVilles(Group root) throws IOException
    
    {
    	
        CSVReader reader = new CSVReader(new FileReader("/Users/naim/Desktop/Chemins2/src/Resource/villes.csv"));
        String[] ls = reader.readNext();
        while ((ls = reader.readNext()) != null) {
            Ville tempVille = new Ville(ls[0], Integer.parseInt(ls[1].replace(" ", "")), Integer.parseInt(ls[2].replace(" ", "")));
            villeList.put(tempVille.getVille(), tempVille);
            Circle circle = new Circle(tempVille.getX() * scale, tempVille.getY() * scale, espace/2);
            circle.setFill(Color.BLACK);
            root.getChildren().add(circle);
            Text villeName = new Text(ls[0]);
            villeName.setX(Integer.parseInt(ls[1]) * scale + 5);
            villeName.setY(Integer.parseInt(ls[2]) * scale - 2);
            villeName.setFill(Color.BLACK);
            villeName.setStyle("-fx-font: 29 arial;");
            root.getChildren().add(villeName);
        }
    }

    public void initTrajets(CSVReader reader, Group root) throws IOException {
        String[] nextLine = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            TrajetSimple currentTrajet = new TrajetSimple();
            currentTrajet.depart = villeList.get(nextLine[0]);
            currentTrajet.arrivee = villeList.get(nextLine[1]);
            currentTrajet.dateDepart = LocalTime.now().plusMinutes(Integer.parseInt(nextLine[3]));
            currentTrajet.duree = Integer.parseInt(nextLine[4]);
            currentTrajet.cout = Integer.parseInt(nextLine[5]);
            currentTrajet.dateArrivee = currentTrajet.dateDepart.plusMinutes(currentTrajet.duree);
            currentTrajet.distance = Ville.getDist(currentTrajet.depart, currentTrajet.arrivee);
            currentTrajet.moyen = Moyen.valueOf(nextLine[2].toUpperCase());
            
            catalogue.addTrajetSimple(currentTrajet);
            trajetSimpleList.add(currentTrajet);
            
            /*
             * vert = bus
             * red = car
             * train = black
             */
         
       
            Line line = new Line(currentTrajet.depart.getX() * scale, currentTrajet.depart.getY() * scale, currentTrajet.arrivee.getX() * scale, currentTrajet.arrivee.getY() * scale);
         
           if(currentTrajet.moyen == BUS) {
        	   
           	line.setStroke(Color.GREEN);
            }else if (currentTrajet.moyen == Moyen.CAR) {
            	line.setStroke(Color.RED);
            }else if (currentTrajet.moyen == Moyen.TRAIN) {
            	line.setStroke(Color.BLACK);
            }
            
            root.getChildren().add(line);
        }
    }

    public LocalTime timeInput() {
    	DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("H:mm:ss");
	    String timeString = sc.nextLine();
	    LocalTime time = LocalTime.parse(timeString, parseFormat);
	    System.out.println(time);
	    return time;
    	
    }
    
    public void start(Stage stage) throws IOException {
      try (Scanner sc = new Scanner(System.in)) {
		
			
    		String Depart;
			String Arrive;
			int delaiMax;
			System.out.println("Veuillez entre une ville de Départ");
			Depart = sc.next();
			System.out.println("Veuillez entrer une ville d'arrivé");
			Arrive = sc.next();
			System.out.println("A quelle heure(format h:m ?");
			timeInput();
			System.out.println("Pour combien de temps Maximum ?");
			delaiMax = sc.nextInt();
			System.out.println("Votre ville de Depart est "+Depart+"\n");
			System.out.println("Votre ville d'arrivé est "+Arrive+"\n");
			System.out.println(delaiMax);
			
		}
      
       // trajetSimpleList = trouveCheminsDirects();
    	Label buso = new Label("Bus : Vert");
        Label traino = new Label("Voiture : Rouge");
        Label voituro = new Label("Train : Noir");
        VBox codeCouleur = new VBox();
      	codeCouleur.setSpacing(10);
      	codeCouleur.setAlignment(Pos.BASELINE_RIGHT);
      	codeCouleur.getChildren().addAll(buso,traino,voituro);
      	root.getChildren().add(codeCouleur);
        Scene scene = new Scene(root);
        
      
        root.setId("r");
        
        scene.getStylesheets().addAll(this.getClass().getResource("./Resource/style.css").toExternalForm());
        stage.setTitle("JavaFX Chemins");
        stage.setScene(scene);
		stage.setHeight(1000);
		stage.setWidth(1000);
        initVilles(root);
        initTrajets(new CSVReader(new FileReader("/Users/naim/Desktop/Chemins2/src/Resource/car.csv")),root);
        initTrajets(new CSVReader(new FileReader("/Users/naim/Desktop/Chemins2/src/Resource/train.csv")),root);
        initTrajets(new CSVReader(new FileReader("/Users/naim/Desktop/Chemins2/src/Resource/bus.csv")),root);
        stage.show();
    }
    
    public static void main(String[] args) {
    	
        launch(args);
    }

  


}

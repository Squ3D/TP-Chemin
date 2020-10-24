package test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import models.Ville;

public class Test {

	public static void main (String [] args) {
		DateTimeFormatter parseFormat = DateTimeFormatter.ofPattern("H:mm:ss");
	    Scanner sc = new Scanner(System.in);
	    String timeString = sc.nextLine();
	    LocalTime time = LocalTime.parse(timeString, parseFormat);
	    System.out.println(time);
	    
		
	}
}

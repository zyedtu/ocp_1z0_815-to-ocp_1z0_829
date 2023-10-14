package ocp.testCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DvdMain {

	public static void main(String[] args) {
		DVD dvd1 = new DVD("Heat", "acteur1", 12);
		DVD dvd2 = new DVD("Cool", "acteur2", 15);
		DVD dvd3 = new DVD("Break", "acteur3", 11);
		List<DVD> listDvd = new ArrayList<DVD>();
		listDvd.add(dvd1);
		listDvd.add(dvd2);
		listDvd.add(dvd3);
		
		Collections.sort(listDvd, (d1 , d2) -> d1.getActeur().compareTo(d2.getActeur()));
		System.out.println("Tri par acteur" + listDvd);
		Collections.sort(listDvd, (d1 , d2) -> d1.getTite().compareTo(d2.getTite()));
		System.out.println("Tri par titre: " + listDvd);
//		Collections.sort(listDvd, (d1 , d2) -> (int)(d1.getPrix() - d2.getPrix()));
		Collections.sort(listDvd, (d1 , d2) -> Long.compare(d1.getPrix(), d2.getPrix()));
		System.out.println("Tri par prix: " + listDvd);
		
	}

}

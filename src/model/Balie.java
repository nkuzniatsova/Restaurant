package model;

import java.util.ArrayList;
import java.util.Random;

public class Balie {

	private ArrayList<Bestelling> bestellingen = null;
	private ArrayList<Maaltijd> maaltijden = null;

	public Balie() {
		this.bestellingen = new ArrayList<Bestelling>();
		this.maaltijden = new ArrayList<Maaltijd>();
	}

	// Nieuwe bestelling plaatsen die kok de bereidt
	public void plaatsBestelling(Bestelling b) {
		bestellingen.add(b);
	}

	// Er zijn nog bestellingen om te bereiden
	public boolean erZijnNogBestellingen() {
		return !bestellingen.isEmpty();
	}

	// Kok pakt bestelling om te bereiden
	public Bestelling pakBestelling() {
		Bestelling res = null;
		if (erZijnNogBestellingen()) {
			res = bestellingen.remove(0);
		}
		return res;
	}

	// Kok plaatst maaltijd voor bezorging
	public void plaatsMaaltijd(Maaltijd m) {
		maaltijden.add(m);
	}

	// Er zijn nog maaltijden die ober kan bezorgen
	public boolean erZijnNogMaaltijden() {
		return !maaltijden.isEmpty();
	}

	// Ober pakt een maaltijd om te bezorgen
	public Maaltijd pakMaaltijd() {
		Maaltijd res = null;
		if (erZijnNogMaaltijden()) {
			res = maaltijden.remove(0);
		}
		return res;
	}
	
	public void genereerBestellingen() {
		for (int i = 0; i < Restaurant.AANTALBESTELLINGEN; i++) {
			int tafelnummer = randInt(1, Restaurant.AANTALTAFELS);
			int bereidingstijd = randInt(Restaurant.MINIMALE_BEREIDINGSTIJD, Restaurant.MAXIMALE_BEREIDINGSTIJD);
			Bestelling b = new Bestelling(bereidingstijd, tafelnummer);
			this.plaatsBestelling(b);
		}
	}
	
	private static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}

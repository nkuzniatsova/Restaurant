package model;

public class Restaurant {

	private Kok aKok = null;
	private Ober aOber = null;
	public static final int AANTALTAFELS = 10;
	public static final int AANTALBESTELLINGEN = 20;
	public static final int MINIMALE_BEREIDINGSTIJD = 750;
	public static final int MAXIMALE_BEREIDINGSTIJD = 1500;
	public static final int AANTALKOKS = 5;
	public static final int AANTALOBERS = 3;
	
	public Restaurant() {
		Balie balie = new Balie();
		balie.genereerBestellingen();
		for (int i=0; i < AANTALKOKS; i++) {
			Kok aKok = new Kok(String.valueOf(i+1), balie);
			Thread th_kok = new Thread(aKok);
			th_kok.start();
		}
		for (int j=0; j < AANTALOBERS; j++) {
			Ober aOber = new Ober(String.valueOf(j+1), balie);
			Thread th_ober = new Thread(aOber);
			th_ober.start();
		}
		//aKok = new Kok("1", balie);
		//aOber = new Ober("1", balie);
		
	}

	public void start() {
		//aKok.bereidMaaltijden();
		//aOber.bezorgMaaltijden();
		
	}

	
	

}

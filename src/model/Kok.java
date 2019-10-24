  package model;

public class Kok extends Thread {

	private String id;
	private Balie balie = null;

	public Kok(String id, Balie balie) {
		this.id = id;
		this.balie = balie;
	}

	public synchronized void bereidMaaltijden() {
		while (balie.erZijnNogBestellingen()) {
			Bestelling bestelling = balie.pakBestelling();
			Maaltijd maaltijd = bereidMaaltijd(bestelling);
			balie.plaatsMaaltijd(maaltijd);
		}
	}

	private Maaltijd bereidMaaltijd(Bestelling b) {
		try {
			Thread.sleep(b.getBereidingstijd());
			System.out.println("Kok " + this.id + " bereidt bestelling voor tafel " + b.getTafelnummer());
		}
		catch (InterruptedException e) {
		}
		return new Maaltijd(b.getTafelnummer());
	}

	@Override
	public void run() {
		bereidMaaltijden();		
	}

}

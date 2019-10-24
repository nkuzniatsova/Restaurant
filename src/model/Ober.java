package model;

public class Ober extends Thread {

	private String id;
	private Balie balie = null;
	private static final int BEZORGTIJD = 10;

	public Ober(String id, Balie balie) {
		this.id = id;
		this.balie = balie;
	}

	public synchronized void bezorgMaaltijden() {
		while (balie.erZijnNogMaaltijden()) {
			Maaltijd maaltijd = balie.pakMaaltijd();
			bezorgMaaltijd(maaltijd);
		}
	}

	private void bezorgMaaltijd(Maaltijd m) {
		try {
			Thread.sleep(BEZORGTIJD);
			System.out.println("Ober " + this.id + " bezorgt maaltijd " + m.getTafelnummer());
		}
		catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		bezorgMaaltijden();		
	}

}

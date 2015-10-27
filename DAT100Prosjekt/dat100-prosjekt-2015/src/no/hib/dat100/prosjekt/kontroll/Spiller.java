package no.hib.dat100.prosjekt.kontroll;

import no.hib.dat100.prosjekt.modell.Hand;
import no.hib.dat100.prosjekt.modell.Kort;
import no.hib.dat100.prosjekt.modell.KortSamling;
//ferdig?
/**
 * Abstrakt klasse som implementerer alle metodene i kontrakten ISpiller,
 * bortsett fra nesteHandling(). Dette er grunnen til at klassen er abstrakt.
 * For Â lage "virkelige" spillere, mÂ vi arve fra denne klassen og implmentere
 * nesteHandling (fra ISpiller).
 * 
 * Klassen har objektvariablene hand (Hand), antalltrekk (heltall) og spiller
 * (Spillere). Den har to konstrukt¯rer. Se beskrivelse av disse.
 * 
 */
public abstract class Spiller implements ISpiller {

	// legg til objektvariable her
	Hand hand = new Hand();
	Spillere spiller;
	private int antallTrekk;
	
	/**
	 * Standard konstrukt¯r som oppretter en Spiller med en hÂnd uten kort,
	 * antalltrekk som 0 og setter spiller til Spillere.INGEN.
	 */
	public Spiller() {
		//throw new RuntimeException("Spiller kontruktør ikke implementert");
		this.hand = new Hand();
		this.spiller = Spillere.INGEN;
		this.antallTrekk = 0;
	}

	/**
	 * Konstrukt�r der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		//throw new RuntimeException("Spiller konstrukt�r ikke implementert");
		this.spiller = spiller;
		this.hand = new Hand();
		this.antallTrekk = 0;
	}

	@Override
	public int getAntallKort() {
		return hand.getAntalKort();
	}

	@Override
	public Hand getHand() {
		//throw new RuntimeException("getHand ikke implementert");
		return hand;
	}

	public int getAntallTrekk() {
		//throw new RuntimeException("getAntallTrekk ikke implementert");
		return antallTrekk;
	}

	public Spillere hvem() {
		//throw new RuntimeException("hvem ikke implementert");
		return this.spiller;
	}

	public void setAntallTrekk(int t) {
		//throw new RuntimeException("setAntallTrekk ikke implementert");
		this.antallTrekk = t;
	}

	@Override
	public boolean erFerdig() {
		//throw new RuntimeException("erFerdig ikke implementert");
		if (hand.getAntalKort() == 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void leggTilKort(Kort kort) {
		//throw new RuntimeException("leggTilkort ikke implementert");
		hand.leggTil(kort);
	}

	@Override
	public void fjernKort(Kort kort) {
		//throw new RuntimeException("fjernKort ikke implementert");
		hand.fjern(kort);
	}

	@Override
	public void fjernAlleKort() {
		//throw new RuntimeException("fjernAlleKort ikke implementert");
		hand.fjernAlle();
	}

	@Override
	public void trekker(Kort kort) {
		//throw new RuntimeException("trekker ikke implementert");
		hand.leggTil(kort);
		this.antallTrekk++;
	}
}

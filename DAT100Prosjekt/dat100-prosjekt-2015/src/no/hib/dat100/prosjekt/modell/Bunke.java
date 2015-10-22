package no.hib.dat100.prosjekt.modell;

/**
 * Klasse for Â representere en bunke kort. Kan om n¯dvendig inneholde hele
 * kortstokken. Man kan bare ta ut / trekke fra toppen av bunken.
 *
 */
public class Bunke extends KortSamling {

	/**
	 * Lager en tom bunke.
	 * 
	 */

	public Bunke() {
		super();
	}

	/**
	 * Fjerner kortet som ligger pÂ toppen av bunken.
	 * 
	 * @return Kortet pÂ toppen av bunken. Kortet blir fjernet fra bunken.
	 * 
	 */
	public Kort trekk() {
		//throw new RuntimeException("trekk ikke implementert");
		Kort tempSamling[] = this.getSamling();
		int n = tempSamling.length - 1;
		int[] samling2 = new int[n];
		System.arraycopy(tempSamling, 1, samling2, 0, n);
		return tempSamling[0];
	}

	/**
	 * "Ser" pÂ kortet som ligger pÂ toppen av bunken.
	 * 
	 * @return referanse til kortet pÂ toppen av bunken. Kortet blir ikke
	 *         fjernet.
	 * 
	 */
	public Kort topp() {
		//throw new RuntimeException("topp ikke implementert");
		Kort tempSamling[] = this.getSamling();
		Kort toppKort = tempSamling[0];
		return toppKort;
	}
}

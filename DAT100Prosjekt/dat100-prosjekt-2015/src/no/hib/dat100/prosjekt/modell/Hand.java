package no.hib.dat100.prosjekt.modell;

/**
 * Klasse for å representere en hand. Kortene er sortert i henhold compareTo()
 * for Kort.
 * 
 */

public class Hand extends KortSamling {

	// oppretter variablar
	private Kort kortpaahand[];
	private final int MAKS_KORT = 12;

	/**
	 * Lager en tom hand.
	 */
	public Hand() {
		super();
	}

	Hand ha = new Hand();

	/**
	 * Legger et kort til en hand.
	 * 
	 * @param kort
	 *            kortet som skal legges til.
	 */
	@Override
	public void leggTil(Kort kort) {
		// throw new RuntimeException("leggTil ikke implementert");
		ha.leggTil(kort);
		for (int i = 0; i < MAKS_KORT; i++) {
			ha.kortpaahand[i] = kort;
		}

	}

	/**
	 * Sorterer en hand. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 */
	private void sorter() {
		int antallKort = getAntalKort();
		Kort[] kortTab = getSamling();

		for (int i = 0; i < antallKort - 1; i++) {
			int minste = i;
			for (int j = i + 1; j < antallKort; j++) {
				if (kortTab[j].compareTo(kortTab[minste]) < 0) {
					minste = j;
				}
			}
			Kort k = kortTab[i];
			kortTab[i] = kortTab[minste];
			kortTab[minste] = k;
		}
	}

}

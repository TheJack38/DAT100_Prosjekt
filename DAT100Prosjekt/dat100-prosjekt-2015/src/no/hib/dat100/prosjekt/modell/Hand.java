package no.hib.dat100.prosjekt.modell;

/**
 * Klasse for � representere en hand. Kortene er sortert i henhold compareTo()
 * for Kort.
 * 
 */

public class Hand extends KortSamling {

	// oppretter variablar

	/**
	 * Lager en tom hand.
	 */
	public Hand() {
		super();
	}



	/**
	 * Legger et kort til en hand.
	 * 
	 * @param kort
	 *            kortet som skal legges til.
	 */
	@Override
	public void leggTil(Kort kort) {
		// throw new RuntimeException("leggTil ikke implementert");
		super.leggTil(kort);
	}

	/**
	 * Sorterer en hand. Rekkef�lgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 */
	private void sorter() {
		int antallKort = getAntalKort();
		Kort kortTab[] = getSamling();

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

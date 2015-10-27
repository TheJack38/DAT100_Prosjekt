package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;
import java.util.Random;

import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Klasse som for Ã‚ representere en vriÃ‚tter spiller. Strategien er Ã‚ lete
 * gjennom kortene man har pÃ‚ hand og spille det fÂ¯rste som er lovlig.
 *
 */
public class FirstFitSpiller extends Spiller {

	/**
	 * KonstruktÂ¯r.
	 * 
	 * @param spiller
	 *            posisjon for spilleren (nord eller syd).
	 */
	public FirstFitSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for å implementere strategi. Strategien er å spille det første
	 * kortet som er lovlig (også en åtter selv om man har andre kort som også‚
	 * kan spilles). Dersom man ikke har lovlige kort å spille, trekker man om
	 * man ikke allerede har trukket maks antall ganger. I så fall sier man
	 * forbi.
	 * 
	 * @param topp
	 *            kort som ligg øverst på til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {
		ArrayList<Kort> h = getHand().toArrayList();
		ArrayList<Kort> lovlige = new ArrayList<Kort>();
		ArrayList<Kort> attere = new ArrayList<Kort>();

		// sjå gjennom kort
		for (Kort k : h) {
			if (Regler.kanLeggeNed(k, topp)) { // regler, kva ein kan legge ned
				if (Regler.kanLeggeNed(k, topp)) { // om åtter,
					lovlige.add(k); // legg til kort
				} else {             // om ikkje,
					attere.add(k);  // om lovlige, legg til kort
				}
			}
		
		}
		
		// spill første kortet som er lovlig å spille
				
			Kort spill = null; // oppretter objekt spill av Kort, setter verdi null
			ArrayList<Kort> spillFra = null; // oppretter array, setter verdi null
			
			if (attere.isEmpty()) {
				spillFra = lovlige;
			} else if (lovlige.isEmpty()) {
				spillFra = attere;
			} else {
				spillFra = null;
			}

//  Dersom man ikke har lovlige kort å spille, trekker man om
//man ikke allerede har trukket maks antall ganger. I så fall sier man forbi.
			
			Handling tur = null; // oppretter objekt tur, setter verdi null
			if (spillFra == null) {; // dersom spillFra ikkje har verdien null
				tur = new Handling(HandlingsType.LEGGNED, spill); // setter handling LEGGNED 
				setAntallTrekk(0); // setter antalltrekk fra Spiller-klassen
			} else if (getAntallTrekk() < Regler.maksTrekk()) { // om maksimale trekk ikkje er nådd
				tur = new Handling(HandlingsType.TREKK, spill); // setter handling TREKK
			} else { // om ikkje dei andre krava oppfyller
				tur = new Handling(HandlingsType.FORBI, spill); //setter handling FORBI
				setAntallTrekk(0); // setter antalltrekk fra Spiller-klassen
			}
			 return tur;
		}
}
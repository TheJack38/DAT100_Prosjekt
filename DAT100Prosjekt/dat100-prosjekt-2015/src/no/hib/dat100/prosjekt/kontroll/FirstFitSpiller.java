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

		// sjå gjennom kort
		for (Kort k : h) {
			if (Regler.kanLeggeNed(k, topp)) { // regler, kva ein kan legge ned
				lovlige.add(k); // legg til kort
				
			}
		
		}
		
			// spill første kortet som er lovlig å spille	
			//  Dersom man ikke har lovlige kort å spille, trekker man om
			//man ikke allerede har trukket maks antall ganger. I så fall sier man forbi.
			
			Handling tur = null; 
			Kort spill = null; // oppretter objekt spill av Kort, setter verdi null
			if(!lovlige.isEmpty()){
				spill = lovlige.get(0);
				tur = new Handling(HandlingsType.LEGGNED, spill); // setter handling LEGGNED 
				setAntallTrekk(0); // setter antalltrekk fra Spiller-klassen
			} 
			else if (getAntallTrekk() < Regler.maksTrekk()) { // om maksimale trekk ikkje er nådd
				tur = new Handling(HandlingsType.TREKK, null); // setter handling TREKK
				int trekk = this.getAntallTrekk();
				trekk++;
				this.setAntallTrekk(trekk);
			} 
			else { // om ikkje dei andre krava oppfyller
				tur = new Handling(HandlingsType.FORBI, null); //setter handling FORBI
				setAntallTrekk(0); // setter antalltrekk fra Spiller-klassen
			}
			 return tur;
		}
}
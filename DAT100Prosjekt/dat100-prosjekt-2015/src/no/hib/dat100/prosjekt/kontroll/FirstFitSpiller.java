package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;
import java.util.Random;

import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Klasse som for Â representere en vriÂtter spiller. Strategien er Â lete
 * gjennom kortene man har pÂ hand og spille det f¯rste som er lovlig.
 *
 */
public class FirstFitSpiller extends Spiller {

	/**
	 * Konstrukt¯r.
	 * 
	 * @param spiller
	 *            posisjon for spilleren (nord eller syd).
	 */
	public FirstFitSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for � implementere strategi. Strategien er � spille det f�rste
	 * kortet som er lovlig (ogs� en �tter selv om man har andre kort som ogs�
	 * kan spilles). Dersom man ikke har lovlige kort � spille, trekker man om
	 * man ikke allerede har trukket maks antall ganger. I s� fall sier man
	 * forbi.
	 * 
	 * @param topp
	 *            kort som ligg �verst p� til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {
		ArrayList<Kort> h = getHand().toArrayList();
		ArrayList<Kort> lovlige = new ArrayList<Kort>();

		// sj� gjennom kort
		for (Kort k : h) {
			if (Regler.kanLeggeNed(k, topp)) { // regler, kva ein kan legge ned
				lovlige.add(k); // legg til kort
				
			}
		
		}
		
			// spill f�rste kortet som er lovlig � spille	
			//  Dersom man ikke har lovlige kort � spille, trekker man om
			//man ikke allerede har trukket maks antall ganger. I s� fall sier man forbi.
			
			Handling tur = null; 
			Kort spill = null; // oppretter objekt spill av Kort, setter verdi null
			if(!lovlige.isEmpty()){
				spill = lovlige.get(0);
				tur = new Handling(HandlingsType.LEGGNED, spill); // setter handling LEGGNED 
				setAntallTrekk(0); // setter antalltrekk fra Spiller-klassen
			} 
			else if (getAntallTrekk() < Regler.maksTrekk()) { // om maksimale trekk ikkje er n�dd
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
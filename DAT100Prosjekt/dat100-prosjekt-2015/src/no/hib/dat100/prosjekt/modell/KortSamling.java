package no.hib.dat100.prosjekt.modell;

import java.util.ArrayList;
import java.util.Random;

/**
 * Struktur for Â lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * konstanter i klassen som angir antall kort i hver av de 4 fargene. NÂr
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det vÊre praktisk Â ha denne mindre.
 * 
 */
public abstract class KortSamling {

	public static final int MAKS_KORT_FARGE = 3;
	private final int MAKS_VERDI = 4; //for enkel forandring
	private final int MAKS_KORT = MAKS_VERDI * MAKS_KORT_FARGE;

	// legg til objektvariable her
	private int counter;
	private Kort samling[];

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		counter = 0;
		samling = new Kort[MAKS_KORT];
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		if(counter==0){
			return true;
		}
		return false;
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke vÊre
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan fÂ
	 * tilgang til antallet ved Â bruke metoden getAntallKort(). Metoden er
	 * f¯rst og fremst ment Â brukes i eventuelle subklasser. Om man trenger
	 * kortene utenfor arvehierarkiet, anbefales metoden toArrayList().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		return samling; 

	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		//Dette returnerer antal kort, *ikkje* indeksen til siste kortet.
		return counter;
	}

	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil vÊre sortert
	 * slik at de normalt mÂ stokkes f¯r bruk.
	 */
	public void leggTilAlle() {
		//TODO Sjekk at dette faktisk fungerer. Burde gj�re det, er ikkje sikker.
		Kortfarge kortFarge[] = Kortfarge.values();
		int index = 0;
		for(int i = 0; i<MAKS_KORT_FARGE; i++){
			for(int verdi = 1; verdi<=MAKS_VERDI; verdi++){
				Kort nyKort = new Kort(kortFarge[i], verdi);
				this.samling[index] = nyKort;
				index++;
				counter++;
			}
		}
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		samling = new Kort[MAKS_KORT];
		counter = 0;
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		if(counter<MAKS_KORT){
			//Passer p� at du bare kan legge til kort viss det er mer plass til det
			samling[counter] = kort;
			counter++;
		}
		else{
			throw new IllegalArgumentException("FEIL: Maksimal st�rrelse n�dd, kan ikkje legge til flere kort!");
		}
	}

	/**
	 * Ser pÂ siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet.
	 */
	public Kort seSiste() {
		return samling[counter-1];
		//samme som f�r, vil helst ikkje gi ut det faktiske objektet...
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		if(counter>0){
			Kort tempKort = samling[counter-1];
			samling[counter-1] = null;
			counter--;
			return tempKort;
		}
		return null;
	}

	/**
	 * Unders¯ker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		if(kort == null){
			return false;
		}
		for(Kort element : samling){
			if(kort.equals(element)){
				return true;
			}
		}

		return false;
	}

	/**
	 * Fjernar et kort frÂ samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting.
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 */
	public void fjern(Kort kort) {
		if(this.har(kort)){
			for(int i = 0; i<MAKS_KORT; i++){
				if(samling[i].equals(kort)){
					samling[i] = null;
					for(int next = 0; next<MAKS_KORT-i; next++){
						samling[i+next] = samling[i+next];
					}
					counter--;	
					//Tror dette lar noen ubrukte entries ha kort  object i dem
					//Men siden counteren er lavere kan de ikkje sees.
					break;
				}
			}

		}
	}

	/**
	 * Stokkar en kortsamling. Etter metoden er utf¯rt har alle kort samme
	 * sannsynligheit for Â vÊre pÂ ein spesiell plass.
	 * 
	 */
	public void stokk() {
		//make tempList[MAKS_KORT]
		//copy mainList to tempList
		//loop through mainList
		//for each, run a random from 0 to MAKS_KORT-i
		//assign the card at the position from random to the index i in mainList
		//remove that card from tempList
		Kort tempList[] = new Kort[MAKS_KORT];
		Random random = new Random();
		for(int i = 0; i<MAKS_KORT; i++){
			tempList[i] = samling[i];
		}
		for(int index = 0; index<MAKS_KORT; index++){
			int ran = random.nextInt(MAKS_KORT-index); //If vi mister et kort n�r vi stokker, er feilen sikkert her!
			samling[index] = tempList[ran];
			tempList[ran] = null;
			for(int next = 0; next<MAKS_KORT-ran; next++){
				tempList[ran+next] = tempList[ran+next+1];
			}
		}

	}

	/**
	 * Gir kortene som en ArrayList.
	 * 
	 * @return samlinga av kort som en ArrayList. Korta vil ha samme rekkef¯lge
	 *         som i kortsamlinga.
	 */
	public ArrayList<Kort> toArrayList() {
		ArrayList<Kort> arraySamling = new ArrayList<Kort>();
		for(int i=0; i<MAKS_KORT; i++){
			if(samling[i]!=null){
				arraySamling.add(samling[i]);
			}
		}
		System.out.println(arraySamling);
		return arraySamling;
	}
}

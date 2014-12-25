package TicTacToe_Dovrsiti;

public class Polje {
	public static final int PRVI_IGRAC = -1;
	public static final int DRUGI_IGRAC = 1;
	public static final int PRAZNO_POLJE = 0;

	private int vrijednost;

	public static char prvi_igrac = 'X';
	public static char drugi_igrac = 'O';
	public static char prazno_polje = ' ';
	
	// Ovo nam je za GUI kada budemo iscrtavali stanje tabele
	
	public static String prvi;
	public static String drugi;
	public static String prazno;
	
	/**
	 * Konstrukto koji pravi polja u matrici
	 */
	public Polje() {
		super();
		vrijednost = PRAZNO_POLJE;
	}
	
	/**
	 * Postavlja vrijednosti u polje 
	 * @param vrijednost
	 * @throws Exception
	 */
	public void postaviPolje(int vrijednost) throws Exception {
		//  Ovo je slucaj kada je vrijednost koju unosimo jednaka praznom polju =0
		if (this.vrijednost == PRAZNO_POLJE) { 
			// Ako vrijednost koju unosimo nije jedanka (prvi igrac)-1 ili (drugi igrac) 1
			if ((vrijednost != PRVI_IGRAC) && (vrijednost != DRUGI_IGRAC)) {
				// baca Excation ukoliko unesnei znak nije jedna 1 ili -1
				throw new IllegalArgumentException("Nije unesen odgovarajuci znak.");
			}
			// Postavlja novu vrijendost
			this.vrijednost = vrijednost;
		} else {
			throw new Exception("Polje je vec popunjeno!");
		}
	}
	
	/**
	 * Metoda koja vraca znak koji se nalazi u polju
	 * @return = Vraca vrijenost koja se nalazi u polja
	 */
	public char vratiVrijednostPolja() {
		if (vrijednost == PRAZNO_POLJE)
			return prazno_polje;
		if (vrijednost == PRVI_IGRAC)
			return prvi_igrac;
		return drugi_igrac;
	}
	
	/**
	 * Metoda koja postavlja znakove u polje matrice
	 * @param p =  znak koji postavlja prvi igrac
	 * @param d =  znak koji postavlja drugi igrac
	 * @param prazno =  prazno polje matrice koje se takodjer postavlja
	 */
	public static void postaviZnakove(char p, char d, char prazno) {
		prvi_igrac = p;
		drugi_igrac = d;
		prazno_polje = prazno;
	}
}

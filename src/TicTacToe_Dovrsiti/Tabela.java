package TicTacToe_Dovrsiti;

public class Tabela {
	private Polje[][] matrica;
	
	/**
	 * Konstruktor koj pravi tabelu visine i sirine po 3 polja
	 */
	public Tabela() {
		matrica = new Polje[3][3];
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[i].length; j++) {
				matrica[i][j] = new Polje();
			}
		}
	}
	
	public int getVisinaMatrice() {
		return 3;
	}
	
	public int getSirinaMatrice() {
		return 3;
	}
	
	/**
	 * Setter koji postavlja vrijednost 'X' ili 'O' u polje
	 * @param aktivniIgrac =  igrac koji trenutno igra
	 * @param i= koordinata x na koju postavljamo X ili O
	 * @param j = koordinata y na koju postavljamo X ili O
	 * @throws Exception u slucaju ako se ne unesu validne koordinate, 
	 * odnosno koordinate koje ne postoje
	 */
	public void setPolje(int aktivniIgrac, int i, int j) throws Exception {
		if (provjeriPolje(i, j)) {
			matrica[i][j].postaviPolje(aktivniIgrac);
		} else {
			throw new ArrayIndexOutOfBoundsException("Nisu dobri indeksi matrice (setPolje)!");
		}
	}
	
	/**
	 * Getter  koji vraca vrijednost iz polja u matrici odnosno tabeli
	 * @param i = koordinata x sa koje zelimo uzeti vrijenosti X ili O
	 * @param j = koordinata y sa koje zelimo uzeti vrijenosti X ili O
	 * @return vraca matrica[i][j]
	 */
	public Polje getPolje(int i, int j) {
		if (provjeriPolje(i, j)) {
			return matrica[i][j];
		}
		throw new ArrayIndexOutOfBoundsException("Nisu dobri indeksi matrice (getPolje)!");
	}
	
	/**
	 * Metoda koja provjerava da li je unesena vrijednost x ili y ulazi u postojece koordinate matrice
	 * @param i = koordinata x koju smo unijeli
	 * @param j = koordinata y koju smo unijeli
	 * @return vraca true ako se unesene koordinate nalaze u matrici
	 *         vraca false vrijednost ako se koordinate nalaze van matrice
	 */
	public boolean provjeriPolje(int i, int j) {
		return !((i < 0) || (i >= matrica.length) || (j < 0) || (j >= matrica[i].length));
	}
}

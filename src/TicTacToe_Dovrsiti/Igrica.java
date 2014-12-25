package TicTacToe_Dovrsiti;

public class Igrica {
	private Tabela poljanaZaIgru;
	private int aktivniIgrac;
	
	/**
	 * Konstruktro koji pravi igricu
	 */
	public Igrica () {
		poljanaZaIgru = new Tabela();
		aktivniIgrac = Polje.PRVI_IGRAC;
	}
	
	/**
	 * Metoda koja vraca tabelu u kojoj igramo
	 * @return tabelu u kojoj igramo, odnosno poljanu za igru
	 */
	public Tabela getPoljanaZaIgru(){
		return poljanaZaIgru;
	}
	
	/**
	 * Metoda koja provjerava da je potez koji zelimo odigrati dozvoljen
	 * @param i =  koordinata x matrice,tabele u kojoj igramo
	 * @param j =  koordinatay matrice,tabele u kojoj igramo
	 * @return true ako je potez dozovoljen 
	 *         false ako potez nije dozvoljen
	 */
	public boolean provjeriDaLiJeDozvoljenPotez(int i, int j) {
		if (poljanaZaIgru.provjeriPolje(i, j))
			return poljanaZaIgru.getPolje(i, j).vratiVrijednostPolja() == Polje.prazno_polje;
		return false;
	}
	
	/**
	 * Metoda pomocu koje igramo poteze
	 * @param i =  koordinata x matrice koju zelimo odigrati
	 * @param j =  koordinata y matrice koju zelimo odigrati
	 * @throws Exception u slucaju kada smo unijeli pogresne indexe
	 */
	public void odigrajPotez(int i, int j) throws Exception {
		if (provjeriDaLiJeDozvoljenPotez(i, j)) {
			poljanaZaIgru.setPolje(aktivniIgrac, i, j);
			if (aktivniIgrac == Polje.PRVI_IGRAC) {
				aktivniIgrac = Polje.DRUGI_IGRAC;
			} else {
				aktivniIgrac = Polje.PRVI_IGRAC;
			}
		} else {
			throw new Exception("Ne valjaju indeksi u odigrajPotez!");
		}
	}
	
	/**
	 * Metoda koja provjerava da li je kraj igre
	 * @return vraca true = da ako je kraj igre ili false=ne ako nije kraj igre
	 */
	public boolean daLiJeKraj() {
		boolean imaPraznih = false;
		for (int i = 0; i < poljanaZaIgru.getVisinaMatrice(); i++) {
			for (int j = 0; j < poljanaZaIgru.getSirinaMatrice(); j++) {
				imaPraznih |= (poljanaZaIgru.getPolje(i, j).vratiVrijednostPolja() == Polje.prazno_polje);
			}
		}
		if (!imaPraznih)
			return true;
		return nekoJePobjedio();
	}

	/**
	 * Metoda koja vraca koji je igrac pobijedio provjeravajuci sva polja
	 * @return vraca pobjednika igre
	 */
	public boolean nekoJePobjedio() {
		boolean pobjeda = false;
		for (int i = 0; i < 3; i++) {
			pobjeda |= (poljanaZaIgru.getPolje(i, 0).vratiVrijednostPolja() == poljanaZaIgru
					.getPolje(i, 1).vratiVrijednostPolja())
					&& (poljanaZaIgru.getPolje(i, 0).vratiVrijednostPolja() == poljanaZaIgru
							.getPolje(i, 2).vratiVrijednostPolja())
					&& (poljanaZaIgru.getPolje(i, 0).vratiVrijednostPolja() != Polje.prazno_polje);
			if (pobjeda)
				return pobjeda;
			pobjeda |= (poljanaZaIgru.getPolje(0, i).vratiVrijednostPolja() == poljanaZaIgru
					.getPolje(1, i).vratiVrijednostPolja())
					&& (poljanaZaIgru.getPolje(0, i).vratiVrijednostPolja() == poljanaZaIgru
							.getPolje(2, i).vratiVrijednostPolja())
					&& (poljanaZaIgru.getPolje(0, i).vratiVrijednostPolja() != Polje.prazno_polje);
			if (pobjeda)
				return pobjeda;
		}
		if ((poljanaZaIgru.getPolje(0, 0).vratiVrijednostPolja() == poljanaZaIgru
				.getPolje(1, 1).vratiVrijednostPolja())
				&& (poljanaZaIgru.getPolje(0, 0).vratiVrijednostPolja() == poljanaZaIgru
						.getPolje(2, 2).vratiVrijednostPolja())
				&& (poljanaZaIgru.getPolje(0, 0).vratiVrijednostPolja() != Polje.prazno_polje))
			return true;
		if ((poljanaZaIgru.getPolje(0, 2).vratiVrijednostPolja() == poljanaZaIgru
				.getPolje(1, 1).vratiVrijednostPolja())
				&& (poljanaZaIgru.getPolje(2, 0).vratiVrijednostPolja() == poljanaZaIgru
						.getPolje(1, 1).vratiVrijednostPolja())
				&& (poljanaZaIgru.getPolje(2, 0).vratiVrijednostPolja() != Polje.prazno_polje))
			return true;
		return pobjeda;
	}
	
	/**
	 * Metoda koja vraca pobjednika igre
	 * @return pobjednika igre odnosno prvog ili drugog igraca
	 */
	public char vratiPobjednika() {
		if (!nekoJePobjedio()) {
			return Polje.prazno_polje;
		}
		if (aktivniIgrac == Polje.PRVI_IGRAC)
			return Polje.drugi_igrac;
		return Polje.prvi_igrac;
	}
}

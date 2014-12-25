package TicTacToe_Dovrsiti;

public class IgrajIksOks {

	/**
	 * Metoda koja ispisuje tenutno stanje tabele sa svim unesnim poljima
	 * @param t =  tabela koju ispisuje
	 */
	private static void ispisStanja(Tabela t){
		for(int i=0; i<3;i++){
			
			for(int j=0; j<3;j++){
				System.out.printf("___");
				System.out.printf(" %s |", t.getPolje(i, j).vratiVrijednostPolja());
				
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
 
		Igrica nasaIgra = new Igrica();
		
		while(nasaIgra.daLiJeKraj()==false){
			System.out.println("Unesite koordinate i,j");
			int i = TextIO.getInt();
			int j = TextIO.getInt();
			
			nasaIgra.odigrajPotez(i, j);
			ispisStanja(nasaIgra.getPoljanaZaIgru());
			
		}
		
		if(nasaIgra.nekoJePobjedio() == true)
			System.out.println("Pobjednik je " +nasaIgra.vratiPobjednika());
		else
			System.out.println("Nerjeseno");
	}

}

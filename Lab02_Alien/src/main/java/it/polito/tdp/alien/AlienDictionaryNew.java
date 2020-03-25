package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionaryNew {

	private List<WordEnhanced> dizionario = new ArrayList<>();

	/**
	 * Aggiunge al dizionario una nuova parola insieme alla traduzione, se già
	 * presente viene aggiornata
	 * 
	 * @param alienWord   Parola aliena
	 * @param translation Traduzione
	 */
	public void addWord(String alienWord, String translation) {
		boolean b1 = alienWord.matches("^[a-zA-Z]*$");
		boolean b2 = translation.matches("^[a-zA-Z]*$");

		if (!b1 || !b2) {
			return;
		}

		String p1 = alienWord.toLowerCase();
		String p2 = translation.toLowerCase();
		
		WordEnhanced pN = new WordEnhanced(p1, p2);

		for (WordEnhanced w : dizionario) {
			if (w.equals(pN)) {
				w.setTranslation(translation);
				System.out.println("AGGIUNTA NUOVA TRADUZIONE");
				return;
			}
		}
		dizionario.add(pN);
		System.out.println("AGGIUNTA NUOVA PAROLA");
	}

	/**
	 * Traduce la parola aliena, se presente altrimenti null
	 * 
	 * @param alienWord Parola aliena
	 * @return Traduzione, altrimenti null
	 */
	public List<String> translateWord(String alienWord) {
		boolean b1 = alienWord.matches("^[a-zA-Z]*$");
		if (!b1) {
			return null;
		}

		String cerca = alienWord.toLowerCase();

		for (WordEnhanced w : dizionario) {
			if (w.getAlienWord().equals(cerca)) {
				return w.getTranslation();
			}
		}
		return null;
	}

}

package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<Word> dizionario = new ArrayList<>();

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
		
		Word pN = new Word(p1, p2);

		for (Word w : dizionario) {
			if (w.equals(pN)) {
				w.setTranslation(translation);
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
	public String translateWord(String alienWord) {
		boolean b1 = alienWord.matches("^[a-zA-Z]*$");
		if(!b1) {
			return null;
		}
		
		String cerca = alienWord.toLowerCase();
		
		for (Word w : dizionario) {
			if (w.getAlienWord().equals(cerca)) {
				return w.getTranslation();
			}
		}
		return null;
	}

}

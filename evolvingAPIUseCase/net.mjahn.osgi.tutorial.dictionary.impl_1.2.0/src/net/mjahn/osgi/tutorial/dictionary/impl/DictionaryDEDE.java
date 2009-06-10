package net.mjahn.osgi.tutorial.dictionary.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.mjahn.osgi.tutorial.dictionary.Dictionary;

public class DictionaryDEDE implements Dictionary {

	private List<String> fWords = new ArrayList<String>(Arrays.asList("Hund", "Katze", "Vogel", "Kamel"));
	private List<String> fWordsWithLemma = new ArrayList<String>(Arrays.asList("Hund", "Hunde", "Katze", "Katzen", "Vogel", "Voegel", "Kamel", "Kamele"));
	private String fLanguage = "de_DE";
	
	public String getLanguage() {
		return fLanguage;
	}

	public boolean check(String word) {
		return fWords.contains(word);
	}
	
	public String toString() {
		return fLanguage;
	}

	public boolean check(String word, boolean lemma) {
		if(lemma){
			return fWordsWithLemma.contains(word);
		} else {
			return check(word);
		}
	}

}

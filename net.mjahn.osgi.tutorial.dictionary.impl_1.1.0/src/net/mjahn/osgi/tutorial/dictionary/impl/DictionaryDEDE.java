package net.mjahn.osgi.tutorial.dictionary.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.mjahn.osgi.tutorial.dictionary.Dictionary;

public class DictionaryDEDE implements Dictionary {

	private List<String> fWords = new ArrayList<String>(Arrays.asList("Hund", "Katze", "Vogel", "Kamel"));
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

}

package net.mjahn.osgi.tutorial.dictionary.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.mjahn.osgi.tutorial.dictionary.Dictionary;

public class DictionaryDEDE implements Dictionary {

	private List<String> fWords = new ArrayList<String>(Arrays.asList("Hund", "Hunde", "Katze", "Katzen", "Vogel", "Voegel", "Kamel", "Kamele"));

	private String[] fLanguages = {"de_DE", "de", "de_AT"};
	
	public String[] getLanguages() {
		return fLanguages;
	}

	public boolean check(String word) {
		return fWords.contains(word);
	}
	
	public String toString() {
		return fLanguages.toString();
	}

	public boolean supportsLanguage(String lang) {
		for(int i=0;i<fLanguages.length;i++){
			if(fLanguages[i].equalsIgnoreCase(lang)){
				return true;
			}
		}
		return false;
	}

}

package net.mjahn.osgi.tutorial.dictionary.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.mjahn.osgi.tutorial.dictionary.Dictionary;

public class DictionaryENUS implements Dictionary {

	private List<String> fWords = new ArrayList<String>(Arrays.asList("dog", "cat", "bird", "camel"));
	private List<String> fWordsWithLemma = new ArrayList<String>(Arrays.asList("dog", "dogs", "cat", "cats", "bird", "birds", "camel", "camels"));
	private String fLanguage = "en_US";
	
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

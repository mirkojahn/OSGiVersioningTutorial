package net.mjahn.osgi.tutorial.dictionary.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.mjahn.osgi.tutorial.dictionary.Dictionary;

public class DictionaryENUS implements Dictionary {

	private List<String> fWords = new ArrayList<String>(Arrays.asList("dog", "dogs", "cat", "cats", "bird", "birds", "camel", "camels"));
	private String[] fLanguages = {"en", "en_US", "en_EN", "en_GB"};
	
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

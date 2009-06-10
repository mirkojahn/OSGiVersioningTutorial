package net.mjahn.osgi.tutorial.dictionary.impl;

import java.util.ArrayList;
import java.util.List;

import net.mjahn.osgi.tutorial.dictionary.Dictionary;
import net.mjahn.osgi.tutorial.dictionary.DictionaryService;

public class DictionaryServiceImpl implements DictionaryService {

	private List<Dictionary> fDictionaries = new ArrayList<Dictionary>();
	
    public void registerDictionary(Dictionary dictionary) {
    	fDictionaries.add(dictionary);
    }
    
    public void unregisterDictionary(Dictionary dictionary) {
    	fDictionaries.remove(dictionary);
    }

	public boolean check(String word) {
		return check(word,null);
	}

	public boolean check(String word, String language) {
		for (int i = 0; i < fDictionaries.size(); i++ ) {
			Dictionary dictionary = fDictionaries.get(i);
			if(language == null || dictionary.getLanguage().equalsIgnoreCase(language)){
				if(dictionary.check(word)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean check(String word, String language, boolean checkLemma) {
		for (int i = 0; i < fDictionaries.size(); i++ ) {
			Dictionary dictionary = fDictionaries.get(i);
			if(language == null || dictionary.getLanguage().equalsIgnoreCase(language)){
				if(dictionary.check(word, checkLemma)){
					return true;
				}
			}
		}
		return false;
	}

}

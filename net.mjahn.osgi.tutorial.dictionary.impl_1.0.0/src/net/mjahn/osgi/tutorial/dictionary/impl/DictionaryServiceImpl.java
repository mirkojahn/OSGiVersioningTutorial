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
		for (int i = 0; i < fDictionaries.size(); i++ ) {
			Dictionary dictionary = fDictionaries.get(i);
			if(dictionary.check(word))
				return true;
		}
		return false;
	}
}

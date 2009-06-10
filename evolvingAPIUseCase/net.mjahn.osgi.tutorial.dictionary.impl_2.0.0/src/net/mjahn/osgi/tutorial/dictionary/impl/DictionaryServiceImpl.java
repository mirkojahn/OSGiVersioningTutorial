package net.mjahn.osgi.tutorial.dictionary.impl;

import net.mjahn.osgi.tutorial.dictionary.Dictionary;
import net.mjahn.osgi.tutorial.dictionary.DictionaryService;

import org.osgi.framework.BundleContext;

public class DictionaryServiceImpl implements DictionaryService {

	private BundleContext bContext;
	public DictionaryServiceImpl(BundleContext context) {
		bContext = context;
	}

	public boolean check(String word) {
		return check(word,null);
	}

	public boolean check(String word, String language) {
		Object[] dictionaries = Activator.getDictionaries();
		for (int i = 0; i < dictionaries.length; i++ ) {
			Dictionary dictionary = (Dictionary)dictionaries[i];
			if(language == null || dictionary.supportsLanguage(language)){
				if(dictionary.check(word)){
					return true;
				}
			}
		}
		return false;
	}
	
	public Dictionary obtainDictionary(String[] languages) {
		return new CustomProxyDictionary(languages);
	}
	
	// naive implementation of the Dictionary
	class CustomProxyDictionary implements Dictionary {
		
		String[] fLanguages;
		
		public CustomProxyDictionary(String[] languages){
			fLanguages = languages;
		}

		public boolean check(String word) {
			for(int i=0;i<fLanguages.length;i++){
				if(DictionaryServiceImpl.this.check(word, fLanguages[i])){
					return true;
				}
			}
			return false;
		}

		public String[] getLanguages() {
			return fLanguages;
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
}

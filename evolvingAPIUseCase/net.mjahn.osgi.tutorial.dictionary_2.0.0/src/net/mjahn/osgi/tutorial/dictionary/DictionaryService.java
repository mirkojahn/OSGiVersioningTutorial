package net.mjahn.osgi.tutorial.dictionary;

public interface DictionaryService {
	
    /**
     * Check for the existence of a word across all dictionaries.
     * 
     * @param word the word to be checked.
     * @return true if the word is in any dictionary
     */
    public boolean check(String word);

    /**
     * Check for the existence of a word across all dictionaries, having
     * the given language.
     * 
     * @param word the word to be checked.
     * @param language the language of the dictionary/word like "DE" or "DE_de" or null for any
     * @return true if the word is in any dictionary
     */
    public boolean check(String word, String language);
    
    /**
     * In order to perform faster checks, a client can obtain a specific dictionary to avoid
     * going through multiple dictionaries for each word to find the fitting one. Depending on
     * the implementation, the Dictionary returned can be a federated one consisting of multiple
     * Dictionary services. The returned Dictionary however has to be a proxy taking care of 
     * potentially disappearing dictionary services.
     * 
     * @param languages the languages 
     * @return
     */
    public Dictionary obtainDictionary(String[] languages);

}

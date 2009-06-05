package net.mjahn.osgi.tutorial.dictionary;

public interface DictionaryService {
	
    /**
     * Register a dictionary.
     * 
     * @param dictionary the dictionary to be added.
     */
    public void registerDictionary(Dictionary dictionary);
    
    /**
     * Remove a dictionary.
     * 
     * @param dictionary the dictionary to be removed.
     */
    public void unregisterDictionary(Dictionary dictionary);
	
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
     * Check for the existence of a word across all dictionaries, having
     * the given language.
     * 
     * @param word the word to be checked.
     * @param language the language of the dictionary/word like "DE" or "DE_de" or null for any
     * @return true if the word is in any dictionary
     */
    public boolean check(String word, String language, boolean checkLemma);

}

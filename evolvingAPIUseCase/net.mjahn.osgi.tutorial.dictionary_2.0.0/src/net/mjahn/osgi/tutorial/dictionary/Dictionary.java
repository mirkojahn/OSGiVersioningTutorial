package net.mjahn.osgi.tutorial.dictionary;

public interface Dictionary {
	
    /**
     * Returns the languages the dictionary supports.
     *
     * @return the language of the dictionary
     */
    public String[] getLanguages();
    
    /**
     * Returns true if the language given is supported by this very dictionary.
     * 
     * @param lang Language String like "de" "de_de" (case insensitive)
     * @return true if it is a match
     */
    public boolean supportsLanguage(String lang);
	
    /**
     * Check for the existence of a word in the dictionary
     * 
     * @param word the word to be checked.
     * @return true if the word is in the dictionary
     */
    public boolean check(String word);
    
}

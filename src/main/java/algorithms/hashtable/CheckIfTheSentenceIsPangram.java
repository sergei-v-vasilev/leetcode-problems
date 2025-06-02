package algorithms.hashtable;

/**
 * 1832. Check if the Sentence Is Pangram
 * 
 */
public class CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        int[] alphabet = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            alphabet[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] < 1) {
                return false;
            }
        }
        return true;
    }
}

package algorithms.backtracking;


/**
 * 1079. Letter Tile Possibilities
 */
public class LetterTilePossibilities {

    public int numTilePossibilities(String tiles) {
        int[] letters = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            letters[tiles.charAt(i) - 'A']++;
        }
        return numTilePossibilities(letters);
    }

    private int numTilePossibilities(int[] letters) {
        int counter = 0;
        for (int j = 0; j < letters.length; j++) {
            if (letters[j] == 0) continue;

            counter++;
            letters[j]--;
            counter += numTilePossibilities(letters);
            letters[j]++;
        }
        return counter;
    }

}

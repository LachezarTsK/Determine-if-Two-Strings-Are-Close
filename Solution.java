
import java.util.Arrays;

public class Solution {

    private static final int ALPHABET_SIZE = 26;

    public boolean closeStrings(String wordOne, String wordTwo) {
        if (wordOne.length() != wordTwo.length()) {
            return false;
        }

        int[] frequenyWordOne = new int[ALPHABET_SIZE];
        int[] frequenyWordTwo = new int[ALPHABET_SIZE];
        for (int i = 0; i < wordOne.length(); ++i) {
            ++frequenyWordOne[wordOne.charAt(i) - 'a'];
            ++frequenyWordTwo[wordTwo.charAt(i) - 'a'];
        }

        return wordsHaveSameUniqueLettersRegardlessOfFrequency(frequenyWordOne, frequenyWordTwo)
                && wordsHaveSameFrequencyPatternRegardlessOfLetters(frequenyWordOne, frequenyWordTwo);
    }

    private boolean wordsHaveSameUniqueLettersRegardlessOfFrequency(int[] frequenyWordOne, int[] frequenyWordTwo) {
        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            if (frequenyWordOne[i] == 0 ^ frequenyWordTwo[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean wordsHaveSameFrequencyPatternRegardlessOfLetters(int[] frequenyWordOne, int[] frequenyWordTwo) {
        Arrays.sort(frequenyWordOne);
        Arrays.sort(frequenyWordTwo);
        return Arrays.equals(frequenyWordOne, frequenyWordTwo);
    }
}

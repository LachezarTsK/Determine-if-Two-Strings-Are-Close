
import java.util.Arrays;

public class Solution {

    private static final int ALPHABET_SIZE = 26;

    public boolean closeStrings(String wordOne, String wordTwo) {
        if (wordOne.length() != wordTwo.length()) {
            return false;
        }

        int[] frequencyWordOne = new int[ALPHABET_SIZE];
        int[] frequencyWordTwo = new int[ALPHABET_SIZE];
        for (int i = 0; i < wordOne.length(); ++i) {
            ++frequencyWordOne[wordOne.charAt(i) - 'a'];
            ++frequencyWordTwo[wordTwo.charAt(i) - 'a'];
        }

        return wordsHaveSameUniqueLettersRegardlessOfFrequency(frequencyWordOne, frequencyWordTwo)
                && wordsHaveSameFrequencyPatternRegardlessOfLetters(frequencyWordOne, frequencyWordTwo);
    }

    private boolean wordsHaveSameUniqueLettersRegardlessOfFrequency(int[] frequencyWordOne, int[] frequencyWordTwo) {
        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            if (frequencyWordOne[i] == 0 ^ frequencyWordTwo[i] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean wordsHaveSameFrequencyPatternRegardlessOfLetters(int[] frequencyWordOne, int[] frequencyWordTwo) {
        Arrays.sort(frequencyWordOne);
        Arrays.sort(frequencyWordTwo);
        return Arrays.equals(frequencyWordOne, frequencyWordTwo);
    }
}

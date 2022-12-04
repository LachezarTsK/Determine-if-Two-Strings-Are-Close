
/**
 * @param {string} wordOne
 * @param {string} wordTwo
 * @return {boolean}
 */
var closeStrings = function (wordOne, wordTwo) {
    if (wordOne.length !== wordTwo.length) {
        return false;
    }
    this.ALPHABET_SIZE = 26;
    const ASCCI_SMALL_CASE_A = 97;

    const frequencyWordOne = new Array(this.ALPHABET_SIZE).fill(0);
    const frequencyWordTwo = new Array(this.ALPHABET_SIZE).fill(0);
    for (let i = 0; i < wordOne.length; ++i) {
        ++frequencyWordOne[wordOne.codePointAt(i) - ASCCI_SMALL_CASE_A];
        ++frequencyWordTwo[wordTwo.codePointAt(i) - ASCCI_SMALL_CASE_A];
    }

    return wordsHaveSameUniqueLettersRegardlessOfFrequency(frequencyWordOne, frequencyWordTwo)
            && wordsHaveSameFrequencyPatternRegardlessOfLetters(frequencyWordOne, frequencyWordTwo);
};

/**
 * @param {number[]} frequencyWordOne
 * @param {number[]} frequencyWordTwo
 * @return {boolean}
 */
function wordsHaveSameUniqueLettersRegardlessOfFrequency(frequencyWordOne, frequencyWordTwo) {
    for (let i = 0; i < this.ALPHABET_SIZE; ++i) {
        if (frequencyWordOne[i] === 0 ^ frequencyWordTwo[i] === 0) {
            return false;
        }
    }
    return true;
}

/**
 * @param {number[]} frequencyWordOne
 * @param {number[]} frequencyWordTwo
 * @return {boolean}
 */
function wordsHaveSameFrequencyPatternRegardlessOfLetters(frequencyWordOne, frequencyWordTwo) {
    frequencyWordOne.sort((first, second) => first - second);
    frequencyWordTwo.sort((first, second) => first - second);
    for (let i = 0; i < this.ALPHABET_SIZE; ++i) {
        if (frequencyWordOne[i] !== frequencyWordTwo[i]) {
            return false;
        }
    }
    return true;
}

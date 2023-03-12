class MagicDictionary {
    private var dictionaryWords: Array<String>? = null
    fun buildDict(dictionary: Array<String>?) {
        dictionaryWords = dictionary
    }

    fun search(searchWord: String): Boolean {
        for (word in dictionaryWords!!) {
            if (isOffByOneLetter(word, searchWord)) {
                return true
            }
        }
        return false
    }

    private fun isOffByOneLetter(word: String, searchWord: String): Boolean {
        if (isDifferentLengths(word, searchWord) || word == searchWord) {
            return false
        }
        var numDifferentLetters = 0
        for (i in word.indices) {
            if (isNotTheSameLetter(word[i], searchWord[i])) {
                numDifferentLetters++
            }
            if (numDifferentLetters > 1) {
                return false
            }
        }
        return numDifferentLetters == 1
    }

    private fun isDifferentLengths(word: String, searchWord: String): Boolean {
        return word.length != searchWord.length
    }

    private fun isNotTheSameLetter(c1: Char, c2: Char): Boolean {
        return c1 != c2
    }
}


/**
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = MagicDictionary()
 * obj.buildDict(dictionary)
 * var param_2 = obj.search(searchWord)
 */
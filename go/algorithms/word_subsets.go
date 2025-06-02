package main

/*
*
916. Word Subsets
*/
func wordSubsets(words1 []string, words2 []string) []string {
	var letters [26]int
	for _, word := range words2 {
		var temp [26]int
		for j := 0; j < len(word); j++ {
			temp[word[j]-'a']++
			if letters[word[j]-'a'] < temp[word[j]-'a'] {
				letters[word[j]-'a'] = temp[word[j]-'a']
			}
		}
	}
	conditions := 0
	for _, letter := range letters {
		if letter > 0 {
			conditions++
		}
	}
	result := make([]string, 0, len(words1))
	for _, word := range words1 {
		var wordLetters [26]int
		count := conditions
		for j := 0; j < len(word); j++ {
			wordLetters[word[j]-'a']++
			if letters[word[j]-'a'] > 0 && wordLetters[word[j]-'a'] == letters[word[j]-'a'] {
				count--
			}
		}
		if count <= 0 {
			result = append(result, word)
		}
	}
	return result
}

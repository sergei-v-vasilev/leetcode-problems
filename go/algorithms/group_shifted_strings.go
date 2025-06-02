package main

import (
	"strconv"
)

/*
249. Group Shifted Strings
*/
func groupStrings(strings []string) [][]string {
	wordMap := make(map[string][]string)
	for i := 0; i < len(strings); i++ {
		word := strings[i]
		code := convert(word)
		_, exist := wordMap[code]
		if !exist {
			wordMap[code] = make([]string, 0)
		}
		wordMap[code] = append(wordMap[code], word)
	}
	result := make([][]string, len(wordMap))
	i := 0
	for _, value := range wordMap {
		result[i] = value
		i++
	}
	return result
}

func convert(word string) string {
	i := 0
	builder := ""
	for i+1 < len(word) {
		diff := int(rune(word[i]) - rune(word[i+1]))
		if diff < 0 {
			diff = 26 + diff
		}
		builder += strconv.Itoa(diff) + ","
		i++
	}
	return builder
}

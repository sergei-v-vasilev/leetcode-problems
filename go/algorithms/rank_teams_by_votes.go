package main

import "sort"

/**
1366. Rank Teams by Votes
*/
func rankTeams(votes []string) string {
	ranks := map[byte]map[int]int{}
	for _, vote := range votes {
		for place, letter := range []byte(vote) {
			if ranks[letter] == nil {
				ranks[letter] = map[int]int{}
			}
			ranks[letter][place]++
		}
	}
	result := []byte(votes[0])
	sort.Slice(result, func(i, j int) bool {
		for k := 0; k < 26; k++ {
			if ranks[result[i]][k] != ranks[result[j]][k] {
				return ranks[result[i]][k] > ranks[result[j]][k]
			}
		}
		return result[i] < result[j]
	})
	return string(result)
}

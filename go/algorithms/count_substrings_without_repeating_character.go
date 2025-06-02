package main

/*
*
2743. Count Substrings Without Repeating Character
*/
func numberOfSpecialSubstrings(s string) int {
	letters := make(map[byte]bool)
	result := 0
	start := 0
	end := 0
	for end < len(s) {
		for end < len(s) && !letters[s[end]] {
			letters[s[end]] = true
			end++
			result += end - start
		}
		for start < end && end < len(s) {
			if s[start] == s[end] {
				result += end - start
				start++
				break
			} else {
				letters[s[start]] = false
				start++
			}
		}
		end++
	}
	return result
}

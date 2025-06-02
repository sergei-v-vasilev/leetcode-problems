package main

/*
*
340. Longest Substring with At Most K Distinct Characters
*/
func lengthOfLongestSubstringKDistinct(s string, k int) int {
	start := 0
	end := 0
	result := 0
	frequencyMap := make(map[byte]int)
	for end < len(s) {
		for len(frequencyMap) > k {
			count, exist := frequencyMap[s[start]]
			if exist && count == 1 {
				delete(frequencyMap, s[start])
			} else if exist {
				frequencyMap[s[start]]--
			}
			start++
		}
		for end < len(s) && len(frequencyMap) <= k {
			frequencyMap[s[end]]++
			end++
			if len(frequencyMap) <= k && end-start > result {
				result = end - start
			}
		}
	}
	return result
}

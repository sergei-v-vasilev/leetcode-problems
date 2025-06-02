package main

/*
*
205. Isomorphic Strings
*/
func isIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	letterMap := make(map[byte]byte)       // s -> t
	hasMappedLetter := make(map[byte]bool) // t

	for i := 0; i < len(s); i++ {
		mappedLetter, exist := letterMap[s[i]]
		if exist {
			if mappedLetter != t[i] {
				return false
			}
		} else {
			if hasMappedLetter[t[i]] {
				return false
			}
			letterMap[s[i]] = t[i]
			hasMappedLetter[t[i]] = true
		}
	}
	return true
}

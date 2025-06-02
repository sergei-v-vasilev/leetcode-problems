package main

/*
*
161. One Edit Distance
*/
func isOneEditDistance(s string, t string) bool {
	var n int
	var isPossible func(i int, s, t string) bool
	defaultOutcome := true
	if len(s) < len(t) {
		if len(s)+1 != len(t) {
			return false
		}
		n = len(s)
		isPossible = func(i int, s, t string) bool {
			return check(i, i+1, s, t)
		}
	} else if len(t) < len(s) {
		if len(t)+1 != len(s) {
			return false
		}
		n = len(t)
		isPossible = func(i int, s, t string) bool {
			return check(i+1, i, s, t)
		}
	} else {
		n = len(s)
		isPossible = func(i int, s, t string) bool {
			return check(i+1, i+1, s, t)
		}
		defaultOutcome = false
	}
	for i := 0; i < n; i++ {
		if s[i] != t[i] {
			if isPossible(i, s, t) {
				return true
			} else {
				return false
			}
		}
	}
	return defaultOutcome
}

func check(is, it int, s, t string) bool {
	for is < len(s) || it < len(t) {
		if is >= len(s) || it >= len(t) {
			return false
		}
		if s[is] != t[it] {
			return false
		}
		is++
		it++
	}
	return true
}

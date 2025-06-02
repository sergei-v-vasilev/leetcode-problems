package main

/*
*
  - The knows API is already defined for you.
  - knows := func(a int, b int) bool

277. Find the Celebrity
*/
func solution(knows func(a int, b int) bool) func(n int) int {
	return func(n int) int {
		celebrity := findCelebrity(0, n, knows)
		if isCelebrity(celebrity, n, knows) {
			return celebrity
		}
		return -1
	}
}

func findCelebrity(k, n int, knows func(a int, b int) bool) int {
	for i := k + 1; i < n; i++ {
		if knows(k, i) {
			return findCelebrity(i, n, knows)
		}
	}
	return k
}

func isCelebrity(k, n int, knows func(a int, b int) bool) bool {
	for i := 0; i < n; i++ {
		if i == k {
			continue
		}
		if knows(k, i) || !knows(i, k) {
			return false
		}
	}
	return true
}

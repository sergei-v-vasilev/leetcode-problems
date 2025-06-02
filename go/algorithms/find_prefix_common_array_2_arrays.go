package main

/*
*
2657. Find the Prefix Common Array of Two Arrays
*/
func findThePrefixCommonArray(A []int, B []int) []int {
	n := len(A)
	result := make([]int, n)
	aMap := make(map[int]bool)
	bMap := make(map[int]bool)
	count := 0
	for i := 0; i < n; i++ {
		aMap[A[i]] = true
		bMap[B[i]] = true
		if A[i] == B[i] {
			count++
		} else {
			if aMap[B[i]] {
				count++
			}
			if bMap[A[i]] {
				count++
			}
		}
		result[i] = count
	}
	return result
}

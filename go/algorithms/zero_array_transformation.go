package main

/*
*
3355. Zero Array Transformation I
*/
func isZeroArray(nums []int, queries [][]int) bool {
	shift := make([]int, len(nums))
	for i := 0; i < len(queries); i++ {
		l := queries[i][0]
		r := queries[i][1]
		shift[l] -= 1
		if r+1 < len(shift) {
			shift[r+1] += 1
		}
	}
	prefixSum := 0
	for i := 0; i < len(shift); i++ {
		prefixSum += shift[i]
		shift[i] = prefixSum
	}
	for i := 0; i < len(nums); i++ {
		if nums[i]+shift[i] > 0 {
			return false
		}
	}
	return true
}

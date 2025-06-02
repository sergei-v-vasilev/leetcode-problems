package main

/*
*
1004. Max Consecutive Ones III
*/
func longestOnes(nums []int, k int) int {
	start := 0
	end := 0
	zeros := 0
	maxLength := 0
	for end < len(nums) {
		for end < len(nums) && zeros <= k {
			if nums[end] == 0 {
				zeros++
			}
			end++
			if zeros <= k && maxLength < end-start {
				maxLength = end - start
			}
		}
		for start < end && zeros > k {
			if nums[start] == 0 {
				zeros--
			}
			start++
		}
		if zeros <= k && maxLength < end-start {
			maxLength = end - start
		}
	}
	return maxLength
}

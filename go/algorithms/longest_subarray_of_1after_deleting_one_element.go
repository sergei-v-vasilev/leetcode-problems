package main

/*
1493. Longest Subarray of 1's After Deleting One Element
*/
func longestSubarray(nums []int) int {
	count := 0
	start := 0
	end := 0
	currentZeros := 0
	for end < len(nums) {
		for currentZeros < 2 && end < len(nums) {
			if nums[end] == 0 {
				currentZeros++
			}
			end++
		}
		if count < end-start-currentZeros {
			count = end - start - currentZeros
		}
		for currentZeros > 1 && start < end {
			if nums[start] == 0 {
				currentZeros--
			}
			start++
		}
	}
	if count == len(nums) {
		count--
	}
	return count
}

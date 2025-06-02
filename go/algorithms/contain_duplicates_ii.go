package main

/*
*
219. Contains Duplicate II
*/
func containsNearbyDuplicate(nums []int, k int) bool {
	if k == 0 {
		return false
	}
	start := 0
	end := 0
	numbers := make(map[int]bool)
	for end <= k && end < len(nums) {
		if numbers[nums[end]] {
			return true
		}
		numbers[nums[end]] = true
		end++
	}
	for end < len(nums) {
		numbers[nums[start]] = false
		start++
		if numbers[nums[end]] {
			return true
		}
		numbers[nums[end]] = true
		end++
	}
	return false
}

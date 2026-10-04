package main

/**
992. Subarrays with K Different Integers
*/

func subarraysWithKDistinct(nums []int, k int) int {
	return atMostK(nums, k) - atMostK(nums, k-1)
}

func atMostK(nums []int, k int) int {
	if k == 0 {
		return 0
	}
	left := 0
	count := 0
	frequency := map[int]int{}
	for right := 0; right < len(nums); right++ {
		frequency[nums[right]] += 1
		for len(frequency) > k {
			if frequency[nums[left]] > 1 {
				frequency[nums[left]] -= 1
			} else {
				delete(frequency, nums[left])
			}
			left++
		}
		count += right - left + 1
	}
	return count
}

package main

/**
* 974. Subarray Sums Divisible by K
**/

func subarraysDivByK(nums []int, k int) int {
	sum := 0
	modMap := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		modMap[sum%k] += 1
	}
	result := 0
	for key, value := range modMap {
		if key == 0 {
			result += value
		}
		result += (value - 1) * value / 2
		oppositeValue := modMap[key-k]
		result += oppositeValue * value
	}
	return result
}

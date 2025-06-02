package main

/*
*
977. Squares of a Sorted Array
*/
func sortedSquares(nums []int) []int {
	result := make([]int, len(nums))
	if nums[0] >= 0 {
		for i := 0; i < len(nums); i++ {
			result[i] = nums[i] * nums[i]
		}
		return result
	}
	if nums[len(nums)-1] <= 0 {
		for i := 0; i < len(nums); i++ {
			result[i] = nums[len(nums)-i-1] * nums[len(nums)-i-1]
		}
		return result
	}

	lastNegativeIndex := -1
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] < 0 && 0 <= nums[i+1] {
			lastNegativeIndex = i
			break
		}
	}

	index, left, right := 0, lastNegativeIndex, lastNegativeIndex+1
	for 0 <= left && right < len(nums) {
		if nums[left]*nums[left] <= nums[right]*nums[right] {
			result[index] = nums[left] * nums[left]
			index++
			left--
		} else {
			result[index] = nums[right] * nums[right]
			index++
			right++
		}
	}
	for 0 <= left {
		result[index] = nums[left] * nums[left]
		index++
		left--
	}
	for right < len(nums) {
		result[index] = nums[right] * nums[right]
		index++
		right++
	}
	return result
}

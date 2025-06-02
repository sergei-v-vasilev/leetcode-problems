package main

/*
*
1814. Count Nice Pairs in an Array
*/
func countNicePairs(nums []int) int {
	frequencyMap := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		val := nums[i] - rev(nums[i])
		frequencyMap[val]++
	}
	result := 0
	for _, frequency := range frequencyMap {
		if frequency > 1 {
			result += (frequency * (frequency - 1) / 2) % 1000000009
			result = result % 1000000009
		}
	}
	return result
}

func rev(num int) int {
	result := 0

	for num > 0 {
		result = result*10 + num%10
		num /= 10
	}

	return result
}

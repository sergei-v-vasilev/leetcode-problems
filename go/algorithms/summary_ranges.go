package main

import "fmt"
import "strconv"

/*
*
228. Summary Ranges
*/
func summaryRanges(nums []int) []string {
	result := make([]string, 0)
	start := 0
	n := len(nums)
	if n == 0 {
		return result
	}
	if n == 1 {
		return append(result, strconv.Itoa(nums[0]))
	}
	for i := 1; i < n; i++ {
		if nums[i] == nums[i-1]+1 {
			continue
		} else if start < i-1 {
			result = append(result, fmt.Sprintf("%d->%d", nums[start], nums[i-1]))
			start = i
		} else {
			result = append(result, strconv.Itoa(nums[start]))
			start = i
		}
	}
	if nums[n-1] == nums[n-2]+1 {
		result = append(result, fmt.Sprintf("%d->%d", nums[start], nums[n-1]))
	} else {
		result = append(result, strconv.Itoa(nums[start]))
	}
	return result
}

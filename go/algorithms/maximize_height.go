package main

import "sort"

/**
3301. Maximize the Total Height of Unique Towers
*/
func maximumTotalSum(maximumHeight []int) int64 {
	sort.Slice(maximumHeight, func(i, j int) bool {
		return maximumHeight[i] > maximumHeight[j]
	})
	currentMax := maximumHeight[0]
	sum := int64(currentMax)
	for i := 1; i < len(maximumHeight); i++ {
		if currentMax > maximumHeight[i] {
			sum += int64(maximumHeight[i])
			currentMax = maximumHeight[i]
		} else if currentMax > 1 {
			currentMax--
			sum += int64(currentMax)
		} else {
			return -1
		}
	}
	return sum
}

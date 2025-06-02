package main

import "sort"

/*
*
1229. Meeting Scheduler
*/
func minAvailableDuration(slots1 [][]int, slots2 [][]int, duration int) []int {
	result := make([]int, 2)
	sort.Slice(slots1, func(i, j int) bool {
		return slots1[i][0] < slots1[j][0]
	})
	sort.Slice(slots2, func(i, j int) bool {
		return slots2[i][0] < slots2[j][0]
	})
	first := 0
	second := 0
	for first < len(slots1) && second < len(slots2) {
		start1, end1 := slots1[first][0], slots1[first][1]
		start2, end2 := slots2[second][0], slots2[second][1]
		var start int
		if start1 > start2 {
			start = start1
		} else {
			start = start2
		}
		var end int
		if end1 < end2 {
			end = end1
		} else {
			end = end2
		}
		if duration <= end-start {
			result[0] = start
			result[1] = start + duration
			return result
		} else {
			if end1 < end2 {
				first++
			} else {
				second++
			}
		}
	}
	return make([]int, 0)
}

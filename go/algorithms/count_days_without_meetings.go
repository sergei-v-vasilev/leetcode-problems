package main

import "sort"

/*
*
3169. Count Days Without Meetings
*/
func countDays(days int, meetings [][]int) int {
	sort.Slice(meetings, func(i, j int) bool {
		if meetings[i][0] == meetings[j][0] {
			return meetings[i][1] < meetings[j][1]
		} else {
			return meetings[i][0] < meetings[j][0]
		}
	})
	count := 0
	end := 0
	for i := range len(meetings) {
		meeting := meetings[i]
		if end < meeting[0] {
			count += meeting[0] - end - 1
		}
		if meeting[1] > end {
			end = meeting[1]
		}
	}
	if end < days {
		count += days - end
	}
	return count
}

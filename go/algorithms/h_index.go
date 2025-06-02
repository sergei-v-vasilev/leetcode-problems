package main

import "sort"

/*
* 274. H-Index
 */
func hIndex(citations []int) int {
	sort.Slice(citations, func(i, j int) bool {
		return citations[j] < citations[i]
	})
	h := 0
	for h < len(citations) && citations[h] >= h+1 {
		h++
	}
	return h
}

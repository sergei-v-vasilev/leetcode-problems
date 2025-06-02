package main

/*
*
849. Maximize Distance to Closest Person
*/
func maxDistToClosest(seats []int) int {
	previous := -1
	maxDistance := 0
	for i := 0; i < len(seats); i++ {
		if seats[i] == 1 {
			if previous == -1 {
				maxDistance = i
			} else if (i-previous)/2 > maxDistance {
				maxDistance = (i - previous) / 2
			}
			previous = i
		}
	}
	if len(seats)-1-previous > maxDistance {
		maxDistance = len(seats) - 1 - previous
	}
	return maxDistance
}

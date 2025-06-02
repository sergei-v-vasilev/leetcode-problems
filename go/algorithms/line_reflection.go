package main

/*
*
356. Line Reflection
*/
func isReflected(points [][]int) bool {
	minX, maxX := 9999999999, -9999999999
	for _, point := range points {
		if minX > point[0] {
			minX = point[0]
		}
		if maxX < point[0] {
			maxX = point[0]
		}
	}

	line := float64(maxX) - float64(maxX-minX)/2

	//check if for every point from the right there is point from the left
	reflectedPointLeftMap := make(map[float64]map[float64]bool, len(points))
	for _, point := range points {
		if float64(point[0]) <= line {
			reflectedX := 2*line - float64(point[0])
			reflectedY := float64(point[1])
			if reflectedPointLeftMap[reflectedX] == nil {
				reflectedPointLeftMap[reflectedX] = make(map[float64]bool)
			}
			reflectedPointLeftMap[reflectedX][reflectedY] = true
		}
	}

	for _, point := range points {
		if float64(point[0]) >= line {
			reflectedX := float64(point[0])
			reflectedY := float64(point[1])
			if reflectedPointLeftMap[reflectedX] == nil || !reflectedPointLeftMap[reflectedX][reflectedY] {
				return false
			}
		}
	}

	//check if for every point from the left there is point from the right
	reflectedPointRightMap := make(map[float64]map[float64]bool)
	for _, point := range points {
		if float64(point[0]) >= line {
			reflectedX := line - (float64(point[0]) - line)
			reflectedY := float64(point[1])
			if reflectedPointRightMap[reflectedX] == nil {
				reflectedPointRightMap[reflectedX] = make(map[float64]bool)
			}
			reflectedPointRightMap[reflectedX][reflectedY] = true
		}
	}

	for _, point := range points {
		if float64(point[0]) <= line {
			reflectedX := float64(point[0])
			reflectedY := float64(point[1])
			if reflectedPointRightMap[reflectedX] == nil || !reflectedPointRightMap[reflectedX][reflectedY] {
				return false
			}
		}
	}
	return true
}

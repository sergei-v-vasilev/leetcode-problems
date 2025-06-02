package main

/**
3071. Minimum Operations to Write the Letter Y on a Grid
*/

func minimumOperationsToWriteY(grid [][]int) int {
	yCells, nonYCells := 0, 0
	yCellMap := [3]int{0, 0, 0}
	nonYCellMap := [3]int{0, 0, 0}
	n := len(grid)
	mid := n / 2
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if i < mid {
				if i == j || i+j == n-1 {
					yCellMap[grid[i][j]]++
					yCells++
				} else {
					nonYCellMap[grid[i][j]]++
					nonYCells++
				}
			} else {
				if j == mid {
					yCellMap[grid[i][j]]++
					yCells++
				} else {
					nonYCellMap[grid[i][j]]++
					nonYCells++
				}
			}
		}
	}

	minOperations := 999999999
	for keyY := range yCellMap {
		existingYCells := yCellMap[keyY]
		for keyNonY := range nonYCellMap {
			existingNonYCells := nonYCellMap[keyNonY]
			if keyNonY != keyY && minOperations > (yCells-existingYCells)+(nonYCells-existingNonYCells) {
				minOperations = (yCells - existingYCells) + (nonYCells - existingNonYCells)
			}
		}
	}
	return minOperations
}

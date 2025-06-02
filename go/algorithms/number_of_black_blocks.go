package main

/*
*
2768. Number of Black Blocks
*/
func countBlackBlocks(m int, n int, coordinates [][]int) []int64 {
	result := make([]int64, 5)
	result[0] = int64(n-1) * int64(m-1)
	blackMap := make(map[int]map[int]int)
	for i := 0; i < len(coordinates); i++ {
		if blackMap[coordinates[i][0]] == nil {
			blackMap[coordinates[i][0]] = make(map[int]int)
		}
		blackMap[coordinates[i][0]][coordinates[i][1]] = 1
	}
	visited := make(map[int]map[int]bool)
	count := 0
	for i := 0; i < len(coordinates); i++ {
		x := coordinates[i][0]
		y := coordinates[i][1]
		count = countBlacksInBlock(x, y, m, n, blackMap, visited)
		if count > 0 {
			result[count]++
			result[0]--
		}
		count = countBlacksInBlock(x-1, y, m, n, blackMap, visited)
		if count > 0 {
			result[count]++
			result[0]--
		}
		count = countBlacksInBlock(x, y-1, m, n, blackMap, visited)
		if count > 0 {
			result[count]++
			result[0]--
		}
		count = countBlacksInBlock(x-1, y-1, m, n, blackMap, visited)
		if count > 0 {
			result[count]++
			result[0]--
		}
	}
	return result
}

func countBlacksInBlock(i int, j int, m int, n int, blackMap map[int]map[int]int, visited map[int]map[int]bool) int {
	if i < 0 || j < 0 || i >= m-1 || j >= n-1 {
		return 0
	}
	if visited[i] != nil && visited[i][j] {
		return 0
	}

	count := 0
	count += blackMap[i][j]
	count += blackMap[i+1][j]
	count += blackMap[i][j+1]
	count += blackMap[i+1][j+1]

	if visited[i] == nil {
		visited[i] = make(map[int]bool)
	}
	visited[i][j] = true
	return count
}

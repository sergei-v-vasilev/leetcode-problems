package main

import "fmt"
import "strings"
import "strconv"

/*
*
286. Walls and Gates
*/
func wallsAndGates(rooms [][]int) {
	m := len(rooms)
	n := len(rooms[0])
	queue := make([]string, 0, m*n)
	for i := range m {
		for j := range n {
			if rooms[i][j] == 0 {
				queue = append(queue, fmt.Sprintf("%d,%d,%d", i, j, 0))
			}
		}
	}
	for len(queue) > 0 {
		coordinates := strings.Split(queue[0], ",")
		queue = queue[1:]
		i, _ := strconv.Atoi(coordinates[0])
		j, _ := strconv.Atoi(coordinates[1])
		length, _ := strconv.Atoi(coordinates[2])
		//up
		if i > 0 && rooms[i-1][j] != -1 && rooms[i-1][j] > length+1 {
			rooms[i-1][j] = length + 1
			queue = append(queue, fmt.Sprintf("%d,%d,%d", i-1, j, length+1))
		}
		//down
		if i < m-1 && rooms[i+1][j] != -1 && rooms[i+1][j] > length+1 {
			rooms[i+1][j] = length + 1
			queue = append(queue, fmt.Sprintf("%d,%d,%d", i+1, j, length+1))
		}
		//left
		if j > 0 && rooms[i][j-1] != -1 && rooms[i][j-1] > length+1 {
			rooms[i][j-1] = length + 1
			queue = append(queue, fmt.Sprintf("%d,%d,%d", i, j-1, length+1))
		}
		//right
		if j < n-1 && rooms[i][j+1] != -1 && rooms[i][j+1] > length+1 {
			rooms[i][j+1] = length + 1
			queue = append(queue, fmt.Sprintf("%d,%d,%d", i, j+1, length+1))
		}
	}
}

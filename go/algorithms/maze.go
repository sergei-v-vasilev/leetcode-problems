package main

/*
*
490. The Maze
*/

type Point struct {
	i, j      int
	direction string
}

func hasPath(maze [][]int, start []int, destination []int) bool {
	m := len(maze)
	n := len(maze[0])
	queue := make([]Point, 0, m*n)
	visited := make([][]int, m)
	for i := 0; i < m; i++ {
		visited[i] = make([]int, n)
	}
	queue = addDirections(start[0], start[1], maze, visited, queue)
	visited[start[0]][start[1]] = 1
	for len(queue) > 0 {
		x, y, direction := queue[0].i, queue[0].j, queue[0].direction
		queue = queue[1:]
		if touchTheWall(x, y, maze, direction) {
			if x == destination[0] && y == destination[1] {
				return true
			}
			if visited[x][y] != 1 {
				queue = addDirections(x, y, maze, visited, queue)
				visited[x][y] = 1
			}
		} else {
			queue = addDirection(x, y, direction, maze, queue)
		}
	}
	return false
}

func touchTheWall(i, j int, maze [][]int, direction string) bool {
	if direction == "up" && (i > 0 && maze[i-1][j] == 1 || i == 0) {
		return true
	}
	if direction == "left" && (j > 0 && maze[i][j-1] == 1 || j == 0) {
		return true
	}
	if direction == "down" && (i+1 < len(maze) && maze[i+1][j] == 1 || i+1 == len(maze)) {
		return true
	}
	if direction == "right" && (j+1 < len(maze[0]) && maze[i][j+1] == 1 || j+1 == len(maze[0])) {
		return true
	}
	return false
}

func addDirections(i, j int, maze [][]int, visited [][]int, queue []Point) []Point {
	if i > 0 && maze[i-1][j] == 0 {
		queue = append(queue, Point{i - 1, j, "up"})
	}
	if j > 0 && maze[i][j-1] == 0 {
		queue = append(queue, Point{i, j - 1, "left"})
	}
	if i+1 < len(maze) && maze[i+1][j] == 0 {
		queue = append(queue, Point{i + 1, j, "down"})
	}
	if j+1 < len(maze[0]) && maze[i][j+1] == 0 {
		queue = append(queue, Point{i, j + 1, "right"})
	}
	return queue
}

func addDirection(i, j int, direction string, maze [][]int, queue []Point) []Point {
	if i > 0 && maze[i-1][j] != 1 && direction == "up" {
		queue = append(queue, Point{i - 1, j, "up"})
	}
	if j > 0 && maze[i][j-1] != 1 && direction == "left" {
		queue = append(queue, Point{i, j - 1, "left"})
	}
	if i+1 < len(maze) && maze[i+1][j] != 1 && direction == "down" {
		queue = append(queue, Point{i + 1, j, "down"})
	}
	if j+1 < len(maze[0]) && maze[i][j+1] != 1 && direction == "right" {
		queue = append(queue, Point{i, j + 1, "right"})
	}
	return queue
}

package main

/**
2685. Count the Number of Complete Components
*/

func countCompleteComponents(n int, edges [][]int) int {
    graph := make(map[int]map[int]bool, n)
    for i := range n {
        graph[i] = map[int]bool{}
    }
    for _, edge := range edges {
        graph[edge[0]][edge[1]] = true
        graph[edge[1]][edge[0]] = true
    }

    visited := map[int]bool{}
    count := 0
    for i := range n {
        if !visited[i] && isCompleteComponent(i, graph) {
            count++
            visited[i] = true
            for neighbour, v := range graph[i] {
                visited[neighbour] = v
            }
        }
    }
    return count
}

func isCompleteComponent(i int, graph map[int]map[int]bool) bool {
    neighbours := graph[i]
    visited := map[int]bool{}
    visited[i] = true
    for neighbour, v := range neighbours {
        visited[neighbour] = v
    }
    for neighbour := range neighbours {
        nextNeighbours := graph[neighbour]
        unvisited := false
        for nextNeighbour, f := range nextNeighbours {
            if f && !visited[nextNeighbour] {
                unvisited = true
                break
            }
        }
        if unvisited {
            return false
        }
        if len(nextNeighbours) != len(neighbours) {
            return false
        }
    }
    return true
}

package main

import "container/list"

/*
*
1424. Diagonal Traverse II
*/
func findDiagonalOrder(nums [][]int) []int {
	queue := list.New()
	resultList := list.New()
	queue.PushBack([]int{0, 0})
	for queue.Len() > 0 {
		e
		e := queue.Front()
		queue.Remove(e)
		row := e.Value.([]int)[0]
		col := e.Value.([]int)[1]
		resultList.PushBack(-nums[row][col])
		// row+1,col
		if row+1 < len(nums) && col < len(nums[row+1]) && nums[row+1][col] > 0 {
			queue.PushBack([]int{row + 1, col})
			nums[row+1][col] = -nums[row+1][col]
		}
		//row,col+1
		if col+1 < len(nums[row]) && nums[row][col+1] > 0 {
			queue.PushBack([]int{row, col + 1})
			nums[row][col+1] = -nums[row][col+1]
		}
	}

	result := make([]int, resultList.Len())
	i := 0
	for e := resultList.Front(); e != nil; e = e.Next() {
		result[i] = e.Value.(int)
		i++
	}
	return result
}

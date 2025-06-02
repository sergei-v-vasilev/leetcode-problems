package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var leftMostIsFilled = false
var initialRoot *TreeNode

/*
545. Boundary of Binary Tree
*/
func boundaryOfBinaryTree(root *TreeNode) []int {
	array := []int{root.Val}
	if root.Left == nil && root.Right == nil {
		return array
	}
	initialRoot = root
	leftMostIsFilled = false
	dfsBoundary(root, root.Left != nil, root.Right != nil, &array)
	return array
}

func dfsBoundary(root *TreeNode, leftMost bool, rightMost bool, array *[]int) {
	if !leftMostIsFilled && leftMost && (root.Left != nil || root.Right != nil) && initialRoot != root {
		*array = append(*array, root.Val)
	}
	if root.Left != nil && root.Right != nil {
		dfsBoundary(root.Left, leftMost, false, array)
		dfsBoundary(root.Right, false, rightMost, array)
	} else if root.Left != nil {
		dfsBoundary(root.Left, leftMost, rightMost, array)
	} else if root.Right != nil {
		dfsBoundary(root.Right, leftMost, rightMost, array)
	} else {
		leftMostIsFilled = true
		*array = append(*array, root.Val)
	}
	if !leftMost && rightMost && (root.Left != nil || root.Right != nil) && initialRoot != root {
		*array = append(*array, root.Val)
	}
}

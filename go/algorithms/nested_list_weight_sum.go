package main

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
type NestedInteger struct {
	val  int
	list []*NestedInteger
}

func New() *NestedInteger {
	return &NestedInteger{
		val: 101,
	}
}

// Return true if this NestedInteger holds a single integer, rather than a nested list.
func (n *NestedInteger) IsInteger() bool {
	return n.val == 101
}

// Return the single integer that this NestedInteger holds, if it holds a single integer
// The result is undefined if this NestedInteger holds a nested list
// So before calling this method, you should have a check
func (n *NestedInteger) GetInteger() int {
	return n.val
}

// Set this NestedInteger to hold a single integer.
func (n *NestedInteger) SetInteger(value int) {
	n.val = value
}

// Set this NestedInteger to hold a nested list and adds a nested integer to it.
func (n *NestedInteger) Add(elem *NestedInteger) {
	n.list = append(n.list, elem)
}

// Return the nested list that this NestedInteger holds, if it holds a nested list
// The result is undefined if this NestedInteger holds a single integer
// You can access NestedInteger's List element directly if you want to modify it
func (n *NestedInteger) GetList() []*NestedInteger {
	return n.list
}

/*
*
339. Nested List Weight Sum
*/
func depthSum(nestedList []*NestedInteger) int {
	return calculateSum(1, nestedList)
}

func calculateSum(depth int, nestedList []*NestedInteger) int {
	sum := 0
	for _, nestedInteger := range nestedList {
		if nestedInteger.IsInteger() {
			sum += depth * nestedInteger.GetInteger()
		} else {
			sum += calculateSum(depth+1, nestedInteger.GetList())
		}
	}
	return sum
}

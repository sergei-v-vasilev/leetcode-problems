package main

import "math/rand"

/*
*
380. Insert Delete GetRandom O(1)
*/
type RandomizedSet struct {
	valueMap map[int]int
	values   []int
	index    int
}

func Constructor() RandomizedSet {
	return RandomizedSet{valueMap: make(map[int]int), values: make([]int, 0), index: 0}
}

func (this *RandomizedSet) Insert(val int) bool {
	if this.valueMap[val] != 0 {
		return false
	}
	//add to array
	if len(this.values) == this.index {
		this.values = append(this.values, val)
	} else {
		this.values[this.index] = val
	}
	//add to map of possible values
	this.valueMap[val] = this.index + 1
	this.index++
	return true
}

func (this *RandomizedSet) Remove(val int) bool {
	//remove from map of possible values
	if this.valueMap[val] == 0 {
		return false
	}
	//remove from array
	index := this.valueMap[val] - 1
	delete(this.valueMap, val)
	if index < this.index-1 {
		newVal := this.values[this.index-1]
		this.values[index] = newVal
		this.valueMap[newVal] = index + 1
	}
	this.index--
	return true
}

func (this *RandomizedSet) GetRandom() int {
	randomIndex := rand.Intn(this.index)
	return this.values[randomIndex]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */

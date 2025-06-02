package main

/*
*
1570. Dot Product of Two Sparse Vectors
*/
type SparseVector struct {
	shortedVector map[int]int
}

func ConstructorSparseVector(nums []int) SparseVector {
	shortedVector := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			shortedVector[i] = nums[i]
		}
	}
	return SparseVector{shortedVector}
}

// Return the dotProduct of two sparse vectors
func (this *SparseVector) dotProduct(vec SparseVector) int {
	product := 0
	for key, value := range this.shortedVector {
		if vec.shortedVector[key] != 0 {
			product += value * vec.shortedVector[key]
		}
	}
	return product
}

package main

/*
*
1052. Grumpy Bookstore Owner
*/
func maxSatisfied(customers []int, grumpy []int, minutes int) int {
	satisfaction := 0
	maxTechniqueSatisfaction := 0
	for i := 0; i < minutes; i++ {
		if grumpy[i] == 1 {
			maxTechniqueSatisfaction += customers[i]
		}
	}
	window := maxTechniqueSatisfaction
	for i := 0; i < len(customers); i++ {
		if grumpy[i] == 0 {
			satisfaction += customers[i]
		}
		if minutes+i < len(customers) {
			if grumpy[i] == 1 {
				window -= customers[i]
			}
			if grumpy[minutes+i] == 1 {
				window += customers[minutes+i]
			}
			if maxTechniqueSatisfaction < window {
				maxTechniqueSatisfaction = window
			}
		}
	}
	return maxTechniqueSatisfaction + satisfaction
}

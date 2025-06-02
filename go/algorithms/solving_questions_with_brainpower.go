package main

/*
2140. Solving Questions With Brainpower
*/
func mostPoints(questions [][]int) int64 {
	return dp(0, questions, make([]int64, len(questions)))
}

func dp(i int, questions [][]int, memo []int64) int64 {
	if i >= len(questions) {
		return 0
	}
	if memo[i] != 0 {
		return memo[i]
	}

	pointForFirst := int64(questions[i][0]) + dp(i+questions[i][1]+1, questions, memo)
	pointForSecond := dp(i+1, questions, memo)
	if pointForSecond > pointForFirst {
		memo[i] = pointForSecond
	} else {
		memo[i] = pointForFirst
	}
	return memo[i]
}

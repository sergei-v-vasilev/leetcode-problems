package main

/**
 * 3466. Maximum Coin Collection
 */
func maxCoins(lane1 []int, lane2 []int) int64 {
	n := len(lane1)
	dp1 := make([][]int64, n)
	dp2 := make([][]int64, n)
	for i := 0; i < n; i++ {
		dp1[i] = make([]int64, 3)
		dp2[i] = make([]int64, 3)
	}

	for i := n - 1; i >= 0; i-- {
		if i == n-1 {
			dp1[i][0] = int64(lane1[i])
			dp2[i][0] = int64(lane2[i])
		} else {
			dp1[i][0] = int64(lane1[i]) + Max(dp1[i+1][0], 0)
			dp2[i][0] = int64(lane2[i]) + Max(dp2[i+1][0], 0)
		}
	}
	for j := 1; j < 3; j++ {
		for i := n - 1; i >= 0; i-- {
			if i == n-1 {
				dp1[i][j] = int64(lane1[i])
				dp2[i][j] = int64(lane2[i])
			} else {
				dp1[i][j] = int64(lane1[i]) + Max(Max(dp1[i+1][j], dp2[i+1][j-1]), 0)
				dp2[i][j] = int64(lane2[i]) + Max(Max(dp1[i+1][j-1], dp2[i+1][j]), 0)
			}
		}
	}
	var maxCoin int64 = -9223372036854775808
	for i := 0; i < n; i++ {
		maxCoin = Max(maxCoin, dp1[i][2])
		maxCoin = Max(maxCoin, dp2[i][1])
	}
	return maxCoin
}

func Max(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}

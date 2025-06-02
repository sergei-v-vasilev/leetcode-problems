package main

/*
*
1868. Product of Two Run-Length Encoded Arrays
*/
func findRLEArray(encoded1 [][]int, encoded2 [][]int) [][]int {
	n := len(encoded1)
	m := len(encoded2)
	result := make([][]int, 1)

	index := 0
	i, j := 0, 0
	for i < n && j < m {
		val := encoded1[i][0] * encoded2[j][0]
		if encoded1[i][1] < encoded2[j][1] {
			if result[index] == nil {
				result[index] = []int{val, encoded1[i][1]}
			} else if result[index][0] == val {
				result[index][1] += encoded1[i][1]
			} else {
				result = append(result, []int{val, encoded1[i][1]})
				index++
			}
			encoded2[j][1] -= encoded1[i][1]
			i++
			if encoded2[j][1] == 0 {
				j++
			}
		} else {
			if result[index] == nil {
				result[index] = []int{val, encoded2[j][1]}
			} else if result[index][0] == val {
				result[index][1] += encoded2[j][1]
			} else {
				result = append(result, []int{val, encoded2[j][1]})
				index++
			}
			encoded1[i][1] -= encoded2[j][1]
			j++
			if encoded1[i][1] == 0 {
				i++
			}
		}
	}
	return result
}

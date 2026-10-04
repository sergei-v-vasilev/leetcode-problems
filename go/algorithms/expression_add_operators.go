package main

import (
	"container/list"
	"strconv"
)

/*
*
282. Expression Add Operators
*/
func addOperators(num string, target int) []string {
	var result []string
	currentList := list.New()
	return backtrackingAddOperations(0, num, target, currentList, result)
}

func backtrackingAddOperations(pos int, num string, target int, currentList *list.List, result []string) []string {
	if pos >= len(num) {
		val, s := calculate(currentList)
		if val == int64(target) {
			result = append(result, s)
		}
		return result
	}
	end := len(num)
	if num[pos] == '0' {
		end = pos + 1
	}
	for i := pos + 1; i <= end; i++ {
		currentList.PushBack(num[pos:i])
		if i == len(num) {
			result = backtrackingAddOperations(i, num, target, currentList, result)
		} else {
			for _, op := range []string{"+", "-", "*"} {
				currentList.PushBack(op)
				result = backtrackingAddOperations(i, num, target, currentList, result)
				currentList.Remove(currentList.Back())
			}
		}
		currentList.Remove(currentList.Back())
	}
	return result
}

func calculate(currentList *list.List) (int64, string) {
	resString := ""
	resVal := int64(0)
	isPositive := true
	stackVal := int64(1)
	for e := currentList.Front(); e != nil; e = e.Next() {
		valueStr := e.Value.(string)
		resString += valueStr
		if val, e := strconv.Atoi(valueStr); e == nil {
			stackVal *= int64(val)
		} else if valueStr == "-" {
			if isPositive {
				resVal += stackVal
			} else {
				resVal -= stackVal
			}
			stackVal = int64(1)
			isPositive = false
		} else if valueStr == "+" {
			if isPositive {
				resVal += stackVal
			} else {
				resVal -= stackVal
			}
			stackVal = int64(1)
			isPositive = true
		} else if resString == "*" {
			//do nothing
		}
	}
	if isPositive {
		resVal += stackVal
	} else {
		resVal -= stackVal
	}
	return resVal, resString
}

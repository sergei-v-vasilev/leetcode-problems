package main

/*
*
1152. Analyze User Website Visit Pattern
*/
import (
	"fmt"
	"sort"
	"strings"
)

type Activity struct {
	username, website string
	timestamp         int
}

func mostVisitedPattern(username []string, timestamp []int, website []string) []string {
	n := len(username)
	activities := make([]Activity, n)
	for i := 0; i < n; i++ {
		activities[i] = Activity{username: username[i], timestamp: timestamp[i], website: website[i]}
	}
	sort.Slice(activities, func(i, j int) bool {
		return activities[i].timestamp < activities[j].timestamp
	})
	userActivities := make(map[string][]string)
	patternUserScore := make(map[string]map[string]bool)
	for i := 0; i < n; i++ {
		lastActivities, exist := userActivities[activities[i].username]
		if exist {
			lastActivities = append(lastActivities, activities[i].website)
			userActivities[activities[i].username] = lastActivities
			for k := 0; k < len(lastActivities)-2; k++ {
				for l := k + 1; l < len(lastActivities)-1; l++ {
					patternUserScore =
						addPattern(activities[i].username, lastActivities[k], lastActivities[l], lastActivities[len(lastActivities)-1], patternUserScore)
				}
			}
		} else {
			lastActivities = make([]string, 0, n)
			lastActivities = append(lastActivities, activities[i].website)
			userActivities[activities[i].username] = lastActivities
		}
	}

	patternScore := make(map[string]int)
	for _, patternMap := range patternUserScore {
		for pattern, exist := range patternMap {
			if exist {
				patternScore[pattern] += 1
			}
		}
	}
	m := 0
	for _, score := range patternScore {
		if score > m {
			m = score
		}
	}
	patterns := make([]string, 0, len(patternScore))
	for pattern, score := range patternScore {
		if score == m {
			patterns = append(patterns, pattern)
		}
	}
	sort.Slice(patterns, func(i, j int) bool {
		return patterns[i] < patterns[j]
	})
	return strings.Split(patterns[0], ",")
}

func addPattern(user string, first string, second string, last string, patternScore map[string]map[string]bool) map[string]map[string]bool {
	if first == "" || second == "" || last == "" {
		return patternScore
	}
	pattern := fmt.Sprintf("%s,%s,%s", first, second, last)
	_, exist := patternScore[user]
	if !exist {
		patternScore[user] = make(map[string]bool)
	}
	patternScore[user][pattern] = true
	return patternScore
}

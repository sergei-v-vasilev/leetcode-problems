package main

/*
2115. Find All Possible Recipes from Given Supplies
*/
func findAllRecipes(recipes []string, ingredients [][]string, supplies []string) []string {
	storage := map[string]int{}
	for i := 0; i < len(supplies); i++ {
		storage[supplies[i]] = 1
	}
	ingredientMap := map[string][]string{}
	for i, recipe := range recipes {
		ingredientMap[recipe] = ingredients[i]
	}
	var result []string
	path := map[string]bool{}
	for _, recipe := range recipes {
		if dfs(recipe, ingredientMap, storage, path) {
			result = append(result, recipe)
		}
	}
	return result
}

func dfs(recipe string, ingredientMap map[string][]string, storage map[string]int, path map[string]bool) bool {
	if storage[recipe] == 1 {
		return true
	}
	if storage[recipe] == 2 {
		return false
	}
	ingredients := ingredientMap[recipe]
	if len(ingredients) == 0 || path[recipe] {
		storage[recipe] = 2
		return false
	}
	path[recipe] = true
	for i := 0; i < len(ingredients); i++ {
		if storage[ingredients[i]] != 1 && !dfs(ingredients[i], ingredientMap, storage, path) {
			storage[recipe] = 2
			return false
		}
	}
	path[recipe] = false
	storage[recipe] = 1
	return true
}

func findAllRecipesBFS(recipes []string, ingredients [][]string, supplies []string) []string {
	storage := map[string]bool{}
	for i := 0; i < len(supplies); i++ {
		storage[supplies[i]] = true
	}
	shouldContinue := true
	for shouldContinue {
		shouldContinue = false
		for i := 0; i < len(recipes); i++ {
			recipe := recipes[i]
			if !storage[recipe] {
				canBeCreated := true
				for j := 0; j < len(ingredients[i]); j++ {
					ingredient := ingredients[i][j]
					if !storage[ingredient] {
						canBeCreated = false
						break
					}
				}
				if canBeCreated {
					storage[recipe] = true
					shouldContinue = true
				}
			}
		}
	}
	var result []string
	for i := 0; i < len(recipes); i++ {
		if storage[recipes[i]] {
			result = append(result, recipes[i])
		}
	}
	return recipes
}

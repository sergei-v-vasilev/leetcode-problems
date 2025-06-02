package main

type Employee struct {
	Id           int
	Importance   int
	Subordinates []int
}

/*
*
690. Employee Importance
*/
func getImportance(employees []*Employee, id int) int {
	employeeMap := make(map[int]*Employee, len(employees))
	for i := 0; i < len(employees); i++ {
		employee := employees[i]
		employeeMap[employee.Id] = employee
	}
	return sumImportance(id, employeeMap)
}

func sumImportance(id int, employeeMap map[int]*Employee) int {
	importance := 0
	employee := employeeMap[id]
	for i := 0; i < len(employee.Subordinates); i++ {
		importance += sumImportance(employee.Subordinates[i], employeeMap)
	}
	importance += employee.Importance
	return importance
}

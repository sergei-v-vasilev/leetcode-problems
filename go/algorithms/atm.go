package main

/*
*
2241. Design an ATM Machine
*/
type ATM struct {
	availableBanknotes [5]int
	nominals           [5]int
}

func ATMConstructor() ATM {
	return ATM{availableBanknotes: [5]int{0, 0, 0, 0, 0}, nominals: [5]int{20, 50, 100, 200, 500}}
}

func (this *ATM) Deposit(banknotesCount []int) {
	for i := 0; i < 5; i++ {
		this.availableBanknotes[i] += banknotesCount[i]
	}
}

func (this *ATM) Withdraw(amount int) []int {
	if !this.isPossibleWithdraw(amount) {
		return []int{-1}
	}

	i := 4
	usedBanknotes := []int{0, 0, 0, 0, 0}
	for i >= 0 && amount > 0 {
		requiredBanknotes := this.min(this.availableBanknotes[i], amount/this.nominals[i])
		if requiredBanknotes > 0 {
			amount -= this.nominals[i] * requiredBanknotes
			this.availableBanknotes[i] -= requiredBanknotes
			usedBanknotes[i] = requiredBanknotes
		}
		i--
	}
	return usedBanknotes
}

func (this ATM) isPossibleWithdraw(amount int) bool {
	i := 4
	for i >= 0 && amount > 0 {
		requiredBanknotes := this.min(this.availableBanknotes[i], amount/this.nominals[i])
		if requiredBanknotes > 0 {
			amount -= this.nominals[i] * requiredBanknotes
		}
		i--
	}
	return amount == 0
}

func (this ATM) min(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

/**
 * Your ATM object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Deposit(banknotesCount);
 * param_2 := obj.Withdraw(amount);
 */

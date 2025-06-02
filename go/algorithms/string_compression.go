package main

/*
*
443. String Compression
*/
func compress(chars []byte) int {
	letterCounter := 1
	position := 0
	for i := 1; i < len(chars); i++ {
		if chars[i] != chars[i-1] {
			position, chars = adjust(position, chars[i-1], letterCounter, chars)
			letterCounter = 1
		} else {
			letterCounter++
		}
	}
	position, chars = adjust(position, chars[len(chars)-1], letterCounter, chars)
	return position
}

func adjust(position int, letter byte, number int, chars []byte) (int, []byte) {
	chars[position] = letter
	position++
	if number == 1 {
		return position, chars
	}
	n := number
	size := 1
	for number/10 > 0 {
		size++
		number /= 10
	}
	nextPosition := position + size
	for size > 0 {
		chars[position+size-1] = byte(n%10) + '0'
		n /= 10
		size--
	}
	return nextPosition, chars
}

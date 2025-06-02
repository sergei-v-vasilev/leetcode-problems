package main

/*
*
362. Design Hit Counter
*/
type CounterNode struct {
	timestamp int
	next      *CounterNode
}

type HitCounter struct {
	head    *CounterNode
	tail    *CounterNode
	counter int
	period  int
}

func ConstructorHitCounter() HitCounter {
	return HitCounter{period: 300}
}

func (this *HitCounter) Hit(timestamp int) {
	if this.tail == nil {
		this.tail = &CounterNode{timestamp: timestamp}
		this.head = this.tail
	} else {
		n := &CounterNode{timestamp: timestamp}
		this.tail.next = n
		this.tail = n
	}
	this.counter++
	for this.head != nil && this.head.timestamp <= timestamp-this.period {
		this.head = this.head.next
		this.counter--
	}
	if this.head == nil {
		this.tail = nil
	}
}

func (this *HitCounter) GetHits(timestamp int) int {
	for this.head != nil && this.head.timestamp <= timestamp-this.period {
		this.head = this.head.next
		this.counter--
	}
	if this.head == nil {
		this.tail = nil
	}
	return this.counter
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Hit(timestamp);
 * param_2 := obj.GetHits(timestamp);
 */

package _go

/*
*
432. All O`one Data Structure
*/
type Node struct {
	count int
	keys  map[string]bool
	prev  *Node
	next  *Node
}

type AllOne struct {
	head *Node
	tail *Node
	// key -> count
	keyMap map[string]*Node
}

func Constructor() AllOne {
	return AllOne{
		keyMap: make(map[string]*Node),
	}
}

func (this *AllOne) Inc(key string) {
	node := this.keyMap[key]
	if node == nil {
		this.insertKeyByCount(this.head, key, 1)
	} else if node.next == nil { // node == this.tail
		this.insertKeyByCount(node, key, node.count+1)
	} else {
		this.insertKeyByCount(node.next, key, node.count+1)
	}
	this.removeKeyFromNode(node, key)
}

func (this *AllOne) Dec(key string) {
	node := this.keyMap[key]
	if node.count > 1 && node.prev == nil { // node == this.head
		this.insertKeyByCount(node, key, node.count-1)
	} else if node.count > 1 {
		this.insertKeyByCount(node.prev, key, node.count-1)
	}
	this.removeKeyFromNode(node, key)
}

func (this *AllOne) GetMaxKey() string {
	if this.tail == nil {
		return ""
	}
	for key := range this.tail.keys {
		if this.tail.keys[key] {
			return key
		}
	}
	return ""
}

func (this *AllOne) GetMinKey() string {
	if this.head == nil {
		return ""
	}
	for key := range this.head.keys {
		if this.head.keys[key] {
			return key
		}
	}
	return ""
}

func (this *AllOne) insertKeyByCount(node *Node, key string, count int) {
	if node == nil { // keyMap is empty
		this.head = &Node{
			count: count,
			keys: map[string]bool{
				key: true,
			},
		}
		this.tail = this.head
		this.keyMap[key] = this.head
	} else if node.count < count { // inc +1 to node
		if node.next == nil { // node == this.tail
			node.next = &Node{
				count: count,
				keys: map[string]bool{
					key: true,
				},
				prev: node,
			}
			this.tail = node.next
			this.keyMap[key] = this.tail
		} else {
			// node -> NewNode -> node.next
			newNode := &Node{
				count: count,
				keys: map[string]bool{
					key: true,
				},
				prev: node,
				next: node.next,
			}
			node.next.prev = newNode
			node.next = newNode
			this.keyMap[key] = newNode
		}
	} else if count < node.count { // dec -1 to node
		if node.prev == nil { // node == this.head
			node.prev = &Node{
				count: count,
				keys: map[string]bool{
					key: true,
				},
				next: node,
			}
			this.head = node.prev
			this.keyMap[key] = this.head
		} else {
			// node.prev -> NewNode -> node
			newNode := &Node{
				count: count,
				keys: map[string]bool{
					key: true,
				},
				prev: node.prev,
				next: node,
			}
			node.prev.next = newNode
			node.prev = newNode
			this.keyMap[key] = newNode
		}
	} else {
		node.keys[key] = true
		this.keyMap[key] = node
	}
}

func (this *AllOne) removeKeyFromNode(node *Node, key string) {
	if node == nil {
		return
	}
	if !node.keys[key] {
		panic("Wrong key removal")
	}
	if len(node.keys) == 1 { // remove node
		if node.prev == nil && node.next == nil { //node == this.head && node == this.tail
			this.head = nil
			this.tail = nil
		} else if node.prev == nil { //node == this.head
			this.head = node.next
			this.head.prev = nil
		} else if node.next == nil { // node == this.tail
			this.tail = node.prev
			this.tail.next = nil
		} else {
			node.prev.next = node.next
			node.next.prev = node.prev
		}
	} else { // remove key from node
		delete(node.keys, key)
	}
	if this.keyMap[key] == node {
		delete(this.keyMap, key)
	}
}

/**
 * Your AllOne object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Inc(key);
 * obj.Dec(key);
 * param_3 := obj.GetMaxKey();
 * param_4 := obj.GetMinKey();
 */

package main

/*
*
1650. Lowest Common Ancestor of a Binary Tree III
*/
type NodeIII struct {
	Val    int
	Left   *NodeIII
	Right  *NodeIII
	Parent *NodeIII
}

func lowestCommonAncestor(p *NodeIII, q *NodeIII) *NodeIII {
	knownAncestors := make(map[int]bool)
	for p != nil {
		knownAncestors[p.Val] = true
		p = p.Parent
	}
	for q != nil {
		if knownAncestors[q.Val] {
			return q
		}
		q = q.Parent
	}
	return nil
}

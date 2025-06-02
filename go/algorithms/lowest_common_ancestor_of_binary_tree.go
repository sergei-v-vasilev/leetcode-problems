package main

/*
*
236. Lowest Common Ancestor of a Binary Tree
*/
type LNode struct {
	treeNode *TreeNode
	next     *LNode
}

func lowestCommonAncestorI(root, p, q *TreeNode) *TreeNode {
	if root == p || root == q {
		return root
	}
	pNode := dfsLNode(root, p)
	qNode := dfsLNode(root, q)
	lowestCommonAncestor := root
	for pNode != nil && qNode != nil && pNode.treeNode == qNode.treeNode {
		lowestCommonAncestor = pNode.treeNode
		pNode = pNode.next
		qNode = qNode.next
	}
	return lowestCommonAncestor
}

func dfsLNode(root, element *TreeNode) *LNode {
	if root == nil {
		return nil
	}
	if root.Val == element.Val {
		return &LNode{treeNode: root}
	}
	leftNode := dfsLNode(root.Left, element)
	if leftNode != nil {
		return &LNode{treeNode: root, next: leftNode}
	}
	rightNode := dfsLNode(root.Right, element)
	if rightNode != nil {
		return &LNode{treeNode: root, next: rightNode}
	}
	return nil
}

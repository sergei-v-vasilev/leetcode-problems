package algorithms.graph.dfs;

/**
 * 427. Construct Quad Tree
 */
public class ConstructQuadTree {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return construct(0, 0, grid.length, grid);
    }

    private Node construct(int startRow, int startCol, int size, int[][] grid) {
        Integer value = getAllSameValue(startRow, startCol, size, grid);
        if (value != null) {
            return new Node(value == 1, true);
        }
        Node root = new Node(true, false);
        root.topLeft = construct(startRow, startCol, size / 2, grid);
        root.topRight = construct(startRow, startCol + size / 2, size / 2, grid);
        root.bottomLeft = construct(startRow + size / 2, startCol, size / 2, grid);
        root.bottomRight = construct(startRow + size / 2, startCol + size / 2, size / 2, grid);
        return root;
    }


    private Integer getAllSameValue(int startRow, int startCol, int size, int[][] grid) {
        int value = grid[startRow][startCol];
        for (int row = startRow; row < startRow + size; row++) {
            for (int col = startCol; col < startCol + size; col++) {
                if (grid[row][col] != value) {
                    return null;
                }
            }
        }
        return value;
    }
}

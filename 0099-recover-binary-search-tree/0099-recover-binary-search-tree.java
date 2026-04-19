class Solution {
    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        traverse(root);
        
        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        // Identify the two nodes to swap
        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev; // First mistake is the 'prev' node
            second = root;                   // Second mistake is the 'current' node
        }
        prev = root;

        traverse(root.right);
    }
}

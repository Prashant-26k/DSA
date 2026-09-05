/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Step 1: Initialize queue and result list
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        // Step 2: Handle edge case
        if (root == null) return result;

        // Step 3: Add root to queue
        queue.offer(root);

        // Step 4: Loop while queue has nodes
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();   // ← Extract node
                levelValues.add(curr.val);      // ← Add VALUE
                
                if (curr.left != null) {        // ← Check children
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(levelValues);           // ← Add this level to results
        }

        return result;
    }
}
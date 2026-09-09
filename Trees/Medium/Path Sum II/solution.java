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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        path(root, targetSum, 0, res, new ArrayList<>());

        return res;
    }

    public void path(TreeNode root, int targetSum, int curSum, List<List<Integer>> res, List<Integer> currentPath) {
        if(root == null) return;

        curSum += root.val;
        currentPath.add(root.val);

        if(root.left == null && root.right == null && curSum == targetSum) {
            res.add(new ArrayList<>(currentPath));
        }

        path(root.left, targetSum, curSum, res, currentPath);
        path(root.right,  targetSum, curSum,  res, currentPath);

        currentPath.remove(currentPath.size() - 1); // remove the current node

    }
}
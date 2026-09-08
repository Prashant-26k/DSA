# Validate Binary Search Tree

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 8, 2026 |
| **Tags** | Tree, Depth-First Search, Binary Search Tree, Binary Tree |
| **Link** | [View Problem](https://leetcode.com/problems/validate-binary-search-tree/) |
| **Runtime** | 0 ms |
| **Memory** | 45.2 MB |

## Approach

Use a helper function for comparing the root value to the minimum and maximum and return the and of left and right.

## Problem Description

<p>Given the <code>root</code> of a binary tree, <em>determine if it is a valid binary search tree (BST)</em>.</p>

<p>A <strong>valid BST</strong> is defined as follows:</p>

<ul>
	<li>The left <span data-keyword="subtree" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_t_" data-state="closed" class="">subtree</button></span> of a node contains only nodes with keys&nbsp;<strong>strictly less than</strong> the node's key.</li>
	<li>The right subtree of a node contains only nodes with keys <strong>strictly greater than</strong> the node's key.</li>
	<li>Both the left and right subtrees must also be binary search trees.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg" style="width: 302px; height: 182px;">
<pre><strong>Input:</strong> root = [2,1,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg" style="width: 422px; height: 292px;">
<pre><strong>Input:</strong> root = [5,1,4,null,null,3,6]
<strong>Output:</strong> false
<strong>Explanation:</strong> The root node's value is 5 but its right child's value is 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Learn one iterative inorder traversal, apply it to multiple tree questions (Java Solution)
**Author**: [@issac3](https://leetcode.com/issac3/)
**Upvotes**: 3807 👍
**Link**: [View Original Post](https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/)

---

I will show you all how to tackle various tree questions using iterative inorder traversal. First one is the standard iterative inorder traversal using stack. Hope everyone agrees with this solution. 

Question : [Binary Tree Inorder Traversal][1]

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
            
        }
        return list;
    }

Now, we can use this structure to find the Kth smallest element in BST.

Question : [Kth Smallest Element in a BST][2]

     public int kthSmallest(TreeNode root, int k) {
         Stack<TreeNode> stack = new Stack<>();
         while(root != null || !stack.isEmpty()) {
             while(root != null) {
                 stack.push(root);    
                 root = root.left;   
             } 
             root = stack.pop();
             if(--k == 0) break;
             root = root.right;
         }
         return root.val;
     }

We can also use this structure to solve BST validation question. 

Question : [Validate Binary Search Tree][3]

    public boolean isValidBST(TreeNode root) {
       if (root == null) return true;
       Stack<TreeNode> stack = new Stack<>();
       TreeNode pre = null;
       while (root != null || !stack.isEmpty()) {
          while (root != null) {
             stack.push(root);
             root = root.left;
          }
          root = stack.pop();
          if(pre != null && root.val <= pre.val) return false;
          pre = root;
          root = root.right;
       }
       return true;
    }



  [1]: https://leetcode.com/problems/binary-tree-inorder-traversal/
  [2]: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
  [3]: https://leetcode.com/problems/validate-binary-search-tree/

</details>

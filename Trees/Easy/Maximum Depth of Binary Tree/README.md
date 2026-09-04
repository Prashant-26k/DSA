# Maximum Depth of Binary Tree

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 4, 2026 |
| **Tags** | Tree, Depth-First Search, Breadth-First Search, Binary Tree |
| **Link** | [View Problem](https://leetcode.com/problems/maximum-depth-of-binary-tree/) |
| **Runtime** | 0 ms |
| **Memory** | 47.1 MB |

## Approach

use recursion : the base condition is if root is null return 0, then calculate for left and right and at the end return 1 + max of left and right.

## Problem Description

<p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>

<p>A binary tree's <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1,null,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Simple solution using Java
**Author**: [@ray050899](https://leetcode.com/ray050899/)
**Upvotes**: 579 👍
**Link**: [View Original Post](https://leetcode.com/problems/maximum-depth-of-binary-tree/solutions/34216/)

---

if the node does not exist, simply return 0. Otherwise, return the 1+the longer distance of its subtree.

    public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }

</details>

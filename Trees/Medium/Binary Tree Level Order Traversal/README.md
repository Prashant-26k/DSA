# Binary Tree Level Order Traversal

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 5, 2026 |
| **Tags** | Tree, Breadth-First Search, Binary Tree |
| **Link** | [View Problem](https://leetcode.com/problems/binary-tree-level-order-traversal/) |
| **Runtime** | 1 ms |
| **Memory** | 46.9 MB |

## Approach

here BFS is used in which we use queue data structure which stores TreeNode and add the root then while the queue is not empty add the values in a temporary list and then add left and right nodes to the queue (after checking if it is not null) then add the final list in the result. 

## Problem Description

<p>Given the <code>root</code> of a binary tree, return <em>the level order traversal of its nodes' values</em>. (i.e., from left to right, level by level).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;">
<pre><strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> [[3],[9,20],[15,7]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> root = [1]
<strong>Output:</strong> [[1]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java solution with a queue used
**Author**: [@SOY](https://leetcode.com/SOY/)
**Upvotes**: 638 👍
**Link**: [View Original Post](https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/33450/)

---

    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
            
            if(root == null) return wrapList;
            
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelNum = queue.size();
                List<Integer> subList = new LinkedList<Integer>();
                for(int i=0; i<levelNum; i++) {
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);
                    subList.add(queue.poll().val);
                }
                wrapList.add(subList);
            }
            return wrapList;
        }
    }

</details>

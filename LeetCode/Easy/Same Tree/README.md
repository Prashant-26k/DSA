# Same Tree

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 3, 2026 |
| **Tags** | Tree, Depth-First Search, Breadth-First Search, Binary Tree |
| **Link** | [View Problem](https://leetcode.com/problems/same-tree/) |
| **Runtime** | 0 ms |
| **Memory** | 43.1 MB |

## Approach

use recursion to check the values and the base conditions are 3 :
if both roots are null, if one is null and not other and if other is null and not the first.

## Problem Description

<p>Given the roots of two binary trees <code>p</code> and <code>q</code>, write a function to check if they are the same or not.</p>

<p>Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg" style="width: 622px; height: 182px;">
<pre><strong>Input:</strong> p = [1,2,3], q = [1,2,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg" style="width: 382px; height: 182px;">
<pre><strong>Input:</strong> p = [1,2], q = [1,null,2]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg" style="width: 622px; height: 182px;">
<pre><strong>Input:</strong> p = [1,2,1], q = [1,1,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both trees is in the range <code>[0, 100]</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Recursive Approach with Easy Steps
**Author**: [@deepankyadav](https://leetcode.com/deepankyadav/)
**Upvotes**: 832 👍
**Link**: [View Original Post](https://leetcode.com/problems/same-tree/solutions/3746149/)

---

## ***Please Upvote my solution, if you find it helpful ;)***

# Intuition
The intuition behind the solution is to recursively check if two binary trees are identical. If both trees are empty (null), they are considered identical. If only one tree is empty or the values of the current nodes are different, the trees are not identical. Otherwise, we recursively check if the left and right subtrees of both trees are identical.

# Approach
1. Check the base case: if both trees are null, return true.
1. Check if only one tree is null or the values of the current nodes are different, return false.
1. Recursively check if the left subtrees of both trees are identical.
1. Recursively check if the right subtrees of both trees are identical.
1. Return the logical AND of the results from steps 3 and 4.

 Complexity
- Time complexity:
The time complexity of the solution is $$O(min(N, M))$$, where N and M are the number of nodes in the two trees, respectively. This is because we need to visit each node once in order to compare their values. In the worst case, where both trees have the same number of nodes, the time complexity would be O(N).

- Space complexity:
The space complexity of the solution is$$O(min(H1, H2))$$, where H1 and H2 are the heights of the two trees, respectively. This is because the space used by the recursive stack is determined by the height of the smaller tree. In the worst case, where one tree is significantly larger than the other, the space complexity would be closer to O(N) or O(M), depending on which tree is larger.

# Code
```java []
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: if both trees are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // If only one tree is null or the values are different, they are not identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check if the left and right subtrees are identical
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

```
```python []
class Solution:
    def isSameTree(self, p, q):
        # If both nodes are None, they are identical
        if p is None and q is None:
            return True
        # If only one of the nodes is None, they are not identical
        if p is None or q is None:
            return False
        # Check if values are equal and recursively check left and right subtrees
        if p.val == q.val:
            return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
        # Values are not equal, they are not identical
        return False
```
```C++ []
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        // If both nodes are NULL, they are identical
        if (p == NULL && q == NULL) {
            return true;
        }
        // If only one of the nodes is NULL, they are not identical
        if (p == NULL || q == NULL) {
            return false;
        }
        // Check if values are equal and recursively check left and right subtrees
        if (p->val == q->val) {
            return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
        }
        // Values are not equal, they are not identical
        return false;
    }
};
```
## ***Please Upvote my solution, if you find it helpful ;)***
![6a87bc25-d70b-424f-9e60-7da6f345b82a_1673875931.8933976.jpeg](https://assets.leetcode.com/users/images/779ca60d-af64-404b-8240-038c7cee76af_1689003011.760921.jpeg)


</details>

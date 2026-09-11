# Binary Tree Right Side View

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 11, 2026 |
| **Tags** | Tree, Depth-First Search, Breadth-First Search, Binary Tree |
| **Link** | [View Problem](https://leetcode.com/problems/binary-tree-right-side-view/) |
| **Runtime** | 0 ms |
| **Memory** | 43.7 MB |

## Approach

Use BFS : queue to store current level nodes and only add the last elements from it. (hint: only when i == size - 1);

## Problem Description

<p>Given the <code>root</code> of a binary tree, imagine yourself standing on the <strong>right side</strong> of it, return <em>the values of the nodes you can see ordered from top to bottom</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,null,5,null,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3,4]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/11/24/tmpd5jn43fs-1.png" style="width: 400px; height: 207px;"></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,null,null,null,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3,4,5]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2024/11/24/tmpkpe40xeh-1.png" style="width: 400px; height: 214px;"></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,null,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3]</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = []</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: My simple accepted solution(JAVA)
**Author**: [@zwangbo](https://leetcode.com/zwangbo/)
**Upvotes**: 1335 👍
**Link**: [View Original Post](https://leetcode.com/problems/binary-tree-right-side-view/solutions/56012/)

---

The core idea of this algorithm: 

1.Each depth of the tree only select one node.  
2. View depth is current size of result list.

Here is the code: 

    public class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            rightView(root, result, 0);
            return result;
        }
        
        public void rightView(TreeNode curr, List<Integer> result, int currDepth){
            if(curr == null){
                return;
            }
            if(currDepth == result.size()){
                result.add(curr.val);
            }
            
            rightView(curr.right, result, currDepth + 1);
            rightView(curr.left, result, currDepth + 1);
            
        }
    }
	


</details>

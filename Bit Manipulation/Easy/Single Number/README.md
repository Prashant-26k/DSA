# Single Number

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 24, 2026 |
| **Tags** | Array, Bit Manipulation |
| **Link** | [View Problem](https://leetcode.com/problems/single-number/) |
| **Runtime** | 1 ms |
| **Memory** | 47 MB |

## Approach

Using XOR function we can check if  a number is present only once because of the property of XOR that :
x ^ x = 0 
x ^ 0 = x

## Problem Description

<p>Given a <strong>non-empty</strong>&nbsp;array of integers <code>nums</code>, every element appears <em>twice</em> except for one. Find that single one.</p>

<p>You must&nbsp;implement a solution with a linear runtime complexity and use&nbsp;only constant&nbsp;extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,2,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,1,2,1,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-3 * 10<sup>4</sup> &lt;= nums[i] &lt;= 3 * 10<sup>4</sup></code></li>
	<li>Each element in the array appears twice except for one element which appears only once.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Solution
**Author**: [@deleted_user](https://leetcode.com/deleted_user/)
**Upvotes**: 525 👍
**Link**: [View Original Post](https://leetcode.com/problems/single-number/solutions/3171261/)

---

```C++ []
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        
        int ans = nums[0];

        for(int i = 1 ; i < nums.size() ; i++){
            ans = ans ^ nums[i];
        }

        return ans;
    }
};
```

```Python3 []
class Solution:
  def singleNumber(self, nums: List[int]) -> int:
    return functools.reduce(lambda x, y: x ^ y, nums, 0)
```

```Java []
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0; i<nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}
```


</details>

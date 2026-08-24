# Find the XOR of Numbers Which Appear Twice

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | August 24, 2026 |
| **Tags** | Array, Hash Table, Bit Manipulation |
| **Link** | [View Problem](https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/) |
| **Runtime** | 1 ms |
| **Memory** | 44.6 MB |

## Approach

Can use hahmap as well as boolean array seen and check whether the value is repeated second time and if yes then xor else update seen array.

## Problem Description

<p>You are given an array <code>nums</code>, where each number in the array appears <strong>either</strong><em> </em>once<em> </em>or<em> </em>twice.</p>

<p>Return the bitwise<em> </em><code>XOR</code> of all the numbers that appear twice in the array, or 0 if no number appears twice.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,1,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The only number that appears twice in&nbsp;<code>nums</code>&nbsp;is 1.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>No number appears twice in&nbsp;<code>nums</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,2,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>Numbers 1 and 2 appeared twice. <code>1 XOR 2 == 3</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 50</code></li>
	<li>Each number in <code>nums</code> appears either once or twice.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Easiest JAVA solution for Beginners [ 75.08% ] [ 2ms ]
**Author**: [@RajarshiMitra](https://leetcode.com/RajarshiMitra/)
**Upvotes**: 16 👍
**Link**: [View Original Post](https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/solutions/5227307/)

---

# Approach
1. **Initialize XOR Variable**:
   - Create a variable `xor` and set it to 0.

2. **Sort the Array**:
   - Sort the array `nums` using `Arrays.sort(nums)`.

3. **Iterate Through the Array**:
   - Use a loop to iterate through the sorted array from the beginning to the second last element (`for (int i = 0; i < nums.length - 1; i++)`).

4. **Check for Duplicates**:
   - Inside the loop, check if the current element is equal to the next element (`if (nums[i] == nums[i + 1])`).

5. **XOR Operation**:
   - If a duplicate is found, perform an XOR operation with the current element and update the `xor` variable (`xor = xor ^ nums[i]`).

6. **Skip the Next Element**:
   - Increment `i` by 1 to skip the next element, as it has already been accounted for (`i++`).

7. **Return Result**:
   - After the loop, return the `xor` value as the result.

# Complexity
- Time complexity:
O(n log n)

- Space complexity:
O(1)

# Code
```
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums [i+1]){
                xor=xor^nums[i];
                i++;
            }
        }
        return xor;
    }
}
```

![193730892e8675ebafc11519f6174bee5c4a5ab0.jpeg](https://assets.leetcode.com/users/images/70e4f761-3fdc-4834-aadb-4133e73a1778_1718520122.903755.jpeg)


</details>

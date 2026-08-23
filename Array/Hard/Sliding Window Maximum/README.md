# Sliding Window Maximum

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | August 23, 2026 |
| **Tags** | Array, Queue, Sliding Window, Heap (Priority Queue), Monotonic Queue, Range Minimum/Maximum Query |
| **Link** | [View Problem](https://leetcode.com/problems/sliding-window-maximum/) |
| **Runtime** | 30 ms |
| **Memory** | 146.7 MB |

## Approach

use a dequeue for storing max indexes over k window. remove the indexes out of range and then add the max of the window in the answer array.

## Problem Description

<p>You are given an array of integers&nbsp;<code>nums</code>, there is a sliding window of size <code>k</code> which is moving from the very left of the array to the very right. You can only see the <code>k</code> numbers in the window. Each time the sliding window moves right by one position.</p>

<p>Return <em>the max sliding window</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,-1,-3,5,3,6,7], k = 3
<strong>Output:</strong> [3,3,5,5,6,7]
<strong>Explanation:</strong> 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       <strong>3</strong>
 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1], k = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java O(n) solution using deque with explanation
**Author**: [@flyingpenguin](https://leetcode.com/flyingpenguin/)
**Upvotes**: 1256 👍
**Link**: [View Original Post](https://leetcode.com/problems/sliding-window-maximum/solutions/65884/)

---

We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n) as each element is put and polled once.

At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means

1. If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

2. Now only those elements within [i-(k-1),i]  are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate. 

3. As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]


-----------------------------------
    public int[] maxSlidingWindow(int[] a, int k) {		
    		if (a == null || k <= 0) {
    			return new int[0];
    		}
    		int n = a.length;
    		int[] r = new int[n-k+1];
    		int ri = 0;
    		// store index
    		Deque<Integer> q = new ArrayDeque<>();
    		for (int i = 0; i < a.length; i++) {
    			// remove numbers out of range k
    			while (!q.isEmpty() && q.peek() < i - k + 1) {
    				q.poll();
    			}
    			// remove smaller numbers in k range as they are useless
    			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
    				q.pollLast();
    			}
    			// q contains index... r contains content
    			q.offer(i);
    			if (i >= k - 1) {
    				r[ri++] = a[q.peek()];
    			}
    		}
    		return r;
    	}

</details>

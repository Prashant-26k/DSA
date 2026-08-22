# Longest Repeating Character Replacement

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 22, 2026 |
| **Tags** | Hash Table, String, Sliding Window |
| **Link** | [View Problem](https://leetcode.com/problems/longest-repeating-character-replacement/) |
| **Runtime** | 25 ms |
| **Memory** | 46.9 MB |

## Approach

Inside loop  Store frequency in hashmap and update max frequency  variable then again loop while the window is not valid (right - left + 1) - maxfreq > k and shrink from left and decrease its frequency in hashmap and increade left then update answer .

## Problem Description

<p>You are given a string <code>s</code> and an integer <code>k</code>. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most <code>k</code> times.</p>

<p>Return <em>the length of the longest substring containing the same letter you can get after performing the above operations</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "ABAB", k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> Replace the two 'A's with two 'B's or vice versa.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "AABABBA", k = 1
<strong>Output:</strong> 4
<strong>Explanation:</strong> Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of only uppercase English letters.</li>
	<li><code>0 &lt;= k &lt;= s.length</code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Easy || 100% || Fully Explained || C++, Java, Python, JavaScript, Python3 || Sliding Window
**Author**: [@PratikSen07](https://leetcode.com/PratikSen07/)
**Upvotes**: 178 👍
**Link**: [View Original Post](https://leetcode.com/problems/longest-repeating-character-replacement/solutions/2524523/)

---

# **PROBLEM STATEMENT:**
Given a string s and an integer k. Choose any character of the string and change it to any other uppercase English character. Perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
# **Example 1:**
# Input: 
s = "ABAB", k = 2
# Output: 
4
Explanation: Replace the two \'A\'s with two \'B\'s or vice versa.

# **Example 2:**
# Input: 
s = "AABABBA",  k = 1
# Output: 
4
# Explanation:
Replace the one \'A\' in the middle with \'B\' and form "AABBBBA". 
The substring "BBBB" has the longest repeating letters, which is 4.


# **C++ Solution:**
```
// Time Complexity :  O(n)
// Space Complexity : O(1)
class Solution {
public:
    int characterReplacement(string s, int k) {
        // Base case...
        if (s.size() == 0) return 0;
        // Make an array...
        vector <int> arr(128);
        // Initialize largestCount & beg pointer...
        int beg = 0, largestCount = 0;
        // Traverse all characters through the loop...
        for (int end = 0; end < s.size(); end++) {
            // Get the largest count of a single, unique character in the current window...
            largestCount = max(largestCount, ++arr[s[end]]);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // That means we have met a largest possible sequence, we can move the window to right...
            if (end - beg + 1 - largestCount > k)       // The main equation is: end - beg + 1 - largestCount...
                arr[s[beg++]]--;
        }
        // Return the sequence we have passes, which is s.length() - beg...
        return s.length() - beg;
    }
};
```

# **Java Solution:**
```
// Time Complexity :  O(n)
// Space Complexity : O(1)
class Solution {
    public int characterReplacement(String s, int k) {
        // Make an array of size 26...
        int[] arr = new int[26];
        // Initialize largestCount, maxlen & beg pointer...
        int largestCount = 0, beg = 0, maxlen = 0;
        // Traverse all characters through the loop...
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - \'A\']++;
            // Get the largest count of a single, unique character in the current window...
            largestCount = Math.max(largestCount, arr[s.charAt(end) - \'A\']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k charactres. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            if(end - beg + 1 - largestCount > k){     // The main equation is: end - beg + 1 - largestCount...
                arr[s.charAt(beg) - \'A\']--;
                beg ++;
            }
            // Get the maximum length of repeating character...
            maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
        }
        return maxlen;      // Return the maximum length of repeating character...
    }
}
```

# **Python/Python3 Solution:**
```
# Time Complexity :  O(n)
# Space Complexity : O(1)
class Solution(object):
    def characterReplacement(self, s, k):
        maxlen, largestCount = 0, 0
        arr = collections.Counter()
        for idx in xrange(len(s)):
            arr[s[idx]] += 1
            largestCount = max(largestCount, arr[s[idx]])
            if maxlen - largestCount >= k:
                arr[s[idx - maxlen]] -= 1
            else:
                maxlen += 1
        return maxlen
```
        
# **JavaScript Solution:**
```
// Time Complexity :  O(n)
// Space Complexity : O(1)
var characterReplacement = function(s, k) {
    // Make a map of size 26...
    var map = [26]
    // Initialize largestCount, maxlen & beg pointer...
    let largestCount = 0, beg = 0, maxlen = 0;
    // Traverse all characters through the loop...
    for(let end = 0; end < s.length; end++){
        const c = s[end]
        map[c] = (map[c] || 0) + 1
        // Get the largest count of a single, unique character in the current window...
        largestCount = Math.max(largestCount, map[c])
        // We are allowed to have at most k replacements in the window...
        // So, if max character frequency + distance between beg and end is greater than k...
        // this means we have considered changing more than k charactres. So time to shrink window...
        // Then there are more characters in the window than we can replace, and we need to shrink the window...
        if(end - beg + 1 - largestCount > k){     // The main equation is: end - beg + 1 - largestCount...
            map[s[beg]] -= 1
            beg += 1
        }
        // Get the maximum length of repeating character...
        maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
    }
    return maxlen;      // Return the maximum length of repeating character...
};
```
**I am working hard for you guys...
Please upvote if you found any help with this code...**

</details>

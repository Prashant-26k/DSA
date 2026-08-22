# Group Anagrams

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | August 22, 2026 |
| **Tags** | Array, Hash Table, String, Sorting |
| **Link** | [View Problem](https://leetcode.com/problems/group-anagrams/) |
| **Runtime** | 7 ms |
| **Memory** | 49.5 MB |

## Approach

Make a hashMap with String as key(sorted) and list of string as values, then compute the key by sorting the characters of each element in a loop then add the value of the sorted key as the normal string (since anagrams will have same sorted value therefore keys for anagrams will be same ).

Add the list in the list of list of strings from the values of hashmap.

## Problem Description

<p>Given an array of strings <code>strs</code>, group the <span data-keyword="anagram" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_t_" data-state="closed" class="">anagrams</button></span> together. You can return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = ["eat","tea","tan","ate","nat","bat"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["bat"],["nat","tan"],["ate","eat","tea"]]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is no string in strs that can be rearranged to form <code>"bat"</code>.</li>
	<li>The strings <code>"nat"</code> and <code>"tan"</code> are anagrams as they can be rearranged to form each other.</li>
	<li>The strings <code>"ate"</code>, <code>"eat"</code>, and <code>"tea"</code> are anagrams as they can be rearranged to form each other.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = [""]</span></p>

<p><strong>Output:</strong> <span class="example-io">[[""]]</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = ["a"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["a"]]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code> consists of lowercase English letters.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: ✅Beats 100% || C++ || JAVA || PYTHON || Beginner Friendly🔥🔥🔥
**Author**: [@rahulvarma5297](https://leetcode.com/rahulvarma5297/)
**Upvotes**: 2007 👍
**Link**: [View Original Post](https://leetcode.com/problems/group-anagrams/solutions/3687735/)

---


# Intuition:

The intuition is to group words that are anagrams of each other together. Anagrams are words that have the `same` characters but in a `different` order.

# Explanation:

Let\'s go through the code step by step using the example input `["eat","tea","tan","ate","nat","bat"]` to understand how it works.

1. **Initializing Variables**
    - We start by initializing an empty unordered map called `mp` (short for map), which will store the groups of anagrams.

2. **Grouping Anagrams**
We iterate through each word in the input vector `strs`. Let\'s take the first word, "eat", as an example.

    - **Sorting the Word**
We create a string variable called `word` and assign it the value of the current word ("eat" in this case). 

        Next, we sort the characters in `word` using the `sort()` function. After sorting, `word` becomes "aet". 

    - **Grouping the Anagram**
We insert `word` as the key into the `mp` unordered map using `mp[word]`, and we push the original word ("eat") into the vector associated with that key using `mp[word].push_back(x)`, where `x` is the current word.

        Since "aet" is a unique sorted representation of all the anagrams, it serves as the key in the `mp` map, and the associated vector holds all the anagrams. 

For the given example, the `mp` map would look like this after processing all the words:
```
{
  "aet": ["eat", "tea", "ate"],
  "ant": ["tan", "nat"],
  "abt": ["bat"]
}
```

3. **Creating the Result**
We initialize an empty vector called `ans` (short for answer) to store the final result.

    - We iterate through each key-value pair in the `mp` map using a range-based for loop. For each pair, we push the vector of anagrams (`x.second`) into the `ans` vector.

For the given example, the `ans` vector would look like this:
```
[
  ["eat", "tea", "ate"],
  ["tan", "nat"],
  ["bat"]
]
```

4. **Returning the Result**
We return the `ans` vector, which contains the groups of anagrams.

# Code
```C++ []
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        
        for(auto x: strs){
            string word = x;
            sort(word.begin(), word.end());
            mp[word].push_back(x);
        }
        
        vector<vector<string>> ans;
        for(auto x: mp){
            ans.push_back(x.second);
        }
        return ans;
    }
};
```
```Java []
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}
```
```Python3 []
class Solution:
    def groupAnagrams(self, strs):
        anagram_map = defaultdict(list)
        
        for word in strs:
            sorted_word = \'\'.join(sorted(word))
            anagram_map[sorted_word].append(word)
        
        return list(anagram_map.values())
```

![CUTE_CAT.png](https://assets.leetcode.com/users/images/86270fe9-da59-416b-a22e-21b787b13712_1687773427.3564198.png)

**If you are a beginner solve these problems which makes concepts clear for future coding:**
1. [Two Sum](https://leetcode.com/problems/two-sum/solutions/3619262/3-method-s-c-java-python-beginner-friendly/)
2. [Roman to Integer](https://leetcode.com/problems/roman-to-integer/solutions/3651672/best-method-c-java-python-beginner-friendly/)
3. [Palindrome Number](https://leetcode.com/problems/palindrome-number/solutions/3651712/2-method-s-c-java-python-beginner-friendly/)
4. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/solutions/3666304/beats-100-c-java-python-beginner-friendly/)
5. [Remove Element](https://leetcode.com/problems/remove-element/solutions/3670940/best-100-c-java-python-beginner-friendly/)
6. [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/solutions/3672475/4-method-s-c-java-python-beginner-friendly/)
7. [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/solutions/3675747/beats-100-c-java-python-beginner-friendly/)
8. [Majority Element](https://leetcode.com/problems/majority-element/solutions/3676530/3-methods-beats-100-c-java-python-beginner-friendly/)
9. [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/3676877/best-method-100-c-java-python-beginner-friendly/)
10. [Valid Anagram](https://leetcode.com/problems/valid-anagram/solutions/3687854/3-methods-c-java-python-beginner-friendly/)
11. [Group Anagrams](https://leetcode.com/problems/group-anagrams/solutions/3687735/beats-100-c-java-python-beginner-friendly/)
12. **Practice them in a row for better understanding and please Upvote for more questions.**

**If you found my solution helpful, I would greatly appreciate your upvote, as it would motivate me to continue sharing more solutions.**

</details>

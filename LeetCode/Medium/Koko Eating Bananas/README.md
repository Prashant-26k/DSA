# Koko Eating Bananas

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Medium |
| **Language** | java |
| **Solved On** | September 1, 2026 |
| **Tags** | Array, Binary Search |
| **Link** | [View Problem](https://leetcode.com/problems/koko-eating-bananas/) |
| **Runtime** | 13 ms |
| **Memory** | 47.9 MB |

## Approach

use binary search , starting from left = 1 to right = max number and calculating hours needed at speed mid and adjust the speed accordingly.

## Problem Description

<p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: [Java/C++] A very-very well detailed explanation
**Author**: [@hi-malik](https://leetcode.com/hi-malik/)
**Upvotes**: 527 👍
**Link**: [View Original Post](https://leetcode.com/problems/koko-eating-bananas/solutions/1703687/)

---

```
Let\'s understand the solution, as we are going to be using Binary Search we have given an Array [3,6,7,11] 
And we have to eat every single pile of bananas in less than or equals to hours = 8.
If we not able to do that Gurad will kill KOKO [just a joke] 
```
As we know that the potential rate that we\'re eating bananas at **k** is going to be between **1**  that\'s the minimum it could possibly be. The max it could possibly be is going to be whatever the max in our input array is and that is **11**.
So, then we\'re going to initialize a range like this **k = [1,2,3,4,5,6,7,8,9,10,11]** the entire range we have. Going all the way from **1** to the max value **11**.
![image](https://assets.leetcode.com/users/images/012f952e-b395-419a-b8fc-cfafd16cb907_1642649929.7762113.png)

So, in other words we\'re going to have a **left pointer** at the **minimum** and a **right pointer** at the **maximum** . Then we compute the middle by taking the **average of left & right / 2 i.e. 1 + 11 / 2 = 6**. So, our **middle** will be here at **6** in other words that **k** we\'re trying is going to be here at this rate that we\'re going to eat bananas at rate of **6** .

`Now let\'s check can we eat all the piles of bananas at rate of 6. Let\'s check it,`
![image](https://assets.leetcode.com/users/images/e89c158c-d94e-470d-b614-5cce7c826784_1642650601.5053208.png)

If you see that we just eat all piles of bananas in **6 hour** is that a good value. Well it is less than or equals to **8 hours**, but still we have to find the **minimum possible** of **k** value. This might be the solution but less try is there any more **smaller** **k** value then **6**. 
So, we **decrement** our **right pointer to mid - 1** becuase there might be the best possible solution available.

So, once again we compute the middle by taking the **average of left & right / 2 i.e. 1 + 5 / 2 = 3** our **k** is here at **3** value 

`Now let\'s check can we eat all the piles of bananas at rate of 3. Let\'s check it,`
![image](https://assets.leetcode.com/users/images/6d2a2019-34c4-49f7-b5ad-f4468862d490_1642651233.9354265.png)

If you see that we just eat all piles of bananas in **10 hour** but if you see we went over **8 hours** we took too long to eat all the bananas. So, eating at **rate of 3** didn\'t work.
Let\'s start searching to right of our range we **increment** our **left pointer to mid + 1** *but remember when we shift our right pointer from the last position to mid -1 we just consider that this range will not work. And that\'s how Binary search work!*

So, once again we compute the middle by taking the **average of left & right / 2 i.e. 4 + 5 / 2 = 4** our **k** is here at **4** value 

`Now let\'s check can we eat all the piles of bananas at rate of 4. Let\'s check it,`
![image](https://assets.leetcode.com/users/images/ee337cb4-121f-4239-93f0-825e66119386_1642653637.250936.png)


If you see that we just eat all piles of bananas in **8 hour**. So, we able to eat all bananas in less than or equals to **8 hours** if we had a rate of **4**. Let\'s compare this with our current result. So, far we find a value of **6** we update this **6** and we can say there is a more smaller rate we can use i.e. **4**.
```
But if we try to calculate more further on then we see our right pointer moves more left to the left pointer. Then we can now stop our Binar Search.
```
**I hope you got the point. Let\'s code it up**

*code each line explained :* `Similar for C++ & Java`

* Step 1 :
```
int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        
        while(left <= right){ // performing binary search
            int mid = left + (right - left) / 2; // doing in that way, to handle overflow instead of left + right / 2
            // if koko can eat, mid bananas per hour in less then or equals to h time
            if(canEatInTime(piles, mid, h)) right = mid - 1; // means decrement our right pointer to optimise better solution 
            else left = mid + 1; // if not true, increment left pointer
        }
        return left; // bcz left pointer hold our optimize k, at the end of BS
    }
```
* Step 2 : 
```
boolean canEatInTime(int piles[], int k, int h){
        
        int hours = 0; // track count of hours
        for(int pile : piles){
            // performing claculation, take an example 
            // k = 4
            // pile = 10

            // pile / k => 10 / 4 = 2
            // pile % k => 2, so we need to have one more hour to eat remaining bananas left over as remainder 
            // hours = 3;
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++; // if remainder value is not 0, we need to have an extra hour
        }
        return hours <= h;
```
**Java**
```
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEatInTime(piles, mid, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public boolean canEatInTime(int piles[], int k, int h){
        int hours = 0;
        for(int pile : piles){
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
}
```
**C++**
```
class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1;
        int right = 1000000000;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEatInTime(piles, mid, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    bool canEatInTime(vector<int>& piles, int k, int h){
        int hours = 0;
        for(int pile : piles){
            int div = pile / k;
            hours += div;
            if(pile % k != 0) hours++;
        }
        return hours <= h;
    }
};
```
ANALYSIS :-
* **Time Complexity :-** BigO(N * log(M)) where N is no of piles & M is range of K (left to right)

* **Space Complexity :-** BigO(1) as not using any extra space

</details>

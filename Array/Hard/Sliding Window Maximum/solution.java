class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // Result array index
        
        // Deque stores indices of elements
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // 1. Remove indices that are out of the current window boundary
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            
            // 2. Remove elements from the back that are smaller than the current element
            // (They can never be the maximum since the current element is larger and newer)
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            
            // 3. Add the current element's index to the back
            q.offer(i);
            
            // 4. If the window has reached size k, the front of the queue is our max
            if (i >= k - 1) {
                result[ri++] = nums[q.peek()];
            }
        }
        
        return result;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;
        int answer = max;

        
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            long sum = 0;

            // Calculate hours needed at speed = mid
            for (int i = 0; i < piles.length; i++) {
                sum += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    sum++;
                }
            }

            if (sum <= h) {
                // feasible, try slower speed
                answer = mid;
                right = mid - 1;
            } else {
                // too slow, need higher speed
                left = mid + 1;
            }
        }

        return answer;
    }
}
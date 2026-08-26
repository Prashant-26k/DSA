class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i]; 
        }

        int firstUnique = 0, secondUnique = 0 ;

        int mask = xor & -xor;

        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & mask) == 0){
                firstUnique ^= nums[i];
            } else{
                secondUnique ^= nums[i];
            }
        }

        ans[0] = firstUnique;
        ans[1] = secondUnique;
        return ans;
    }
}
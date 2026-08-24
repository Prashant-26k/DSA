// class Solution {
//     public int duplicateNumbersXOR(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int i = 0; i < nums.length; i++) {
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);    
//         }

//         int ans = 0;
//         for(int num : map.keySet()) {
//             if(map.get(num) == 2) ans ^= num;
//         }

//         return ans;
//     }
// }

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        boolean[] seen = new boolean[50];
        int xor = 0;

        for(int i = 0; i < nums.length; i++){
            if(seen[nums[i] - 1] == true) xor ^= nums[i];
            else seen[nums[i] - 1] = true;
        }

        return xor;
    }
}
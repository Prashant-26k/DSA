class Solution {
    public int majorityElement(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < size; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        for(int i = 0; i < size; i++){
            if(map.get(nums[i]) > size/2) return nums[i];
        }

        return 0;
    }
}
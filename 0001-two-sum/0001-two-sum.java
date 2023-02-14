class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                indexes[0] = map.get(nums[i]);
                indexes[1] = i;
                return indexes;
            }
            map.put(target - nums[i], i);
        }
        return indexes;
    }
}
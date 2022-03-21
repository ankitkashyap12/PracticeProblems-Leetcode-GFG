class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indicesValue=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(indicesValue.get(diff)!=null){
                int[] indices={indicesValue.get(diff),i};
                 return indices;
            }
            else{
                indicesValue.put(nums[i],i);
            }
        }
        return null;
}
}
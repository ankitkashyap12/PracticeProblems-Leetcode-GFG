class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices=new int[2];
        Map<Integer,Integer> indicesValue=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(indicesValue.get(diff)!=null){
                indices[0]=indicesValue.get(diff);
                indices[1]=i;
            }
            else{
                indicesValue.put(nums[i],i);
            }
        }
        return indices;
}
}
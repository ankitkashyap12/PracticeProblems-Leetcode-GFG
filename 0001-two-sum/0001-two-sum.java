class Solution {
    public int[] twoSum(int[] nums, int target) {
        //return brute(nums,target);
        return optimized(nums,target);
    }

    static int[] optimized(int[] nums,int target){
        Map<Integer,Integer> indexAndNums = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int targetNum= target-nums[i];
            if(indexAndNums.containsKey(targetNum)){
                return new int[]{i,indexAndNums.get(targetNum)};
            }
            indexAndNums.put(nums[i],i);
        }
        return null;
    }

    //brute
    static int[] brute(int[] nums,int sum){
    for(int i=0;i< nums.length;i++){
        for(int j=1;j<nums.length;j++){
            if(nums[i]+nums[j]==sum)
            return new int[]{i,j};
        }
    }
    return null;
    }
}

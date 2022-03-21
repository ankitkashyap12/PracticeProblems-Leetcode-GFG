import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Integer[] intNums = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            intNums[i]=Integer.valueOf(nums[i]);
        }
        Set<Integer> uniqueSet = new HashSet<>(Arrays.asList(intNums));
        if(intNums.length==uniqueSet.size()){
            return false;
        }
        return true;
        // for(int i=0;i<nums.length;i++){
        //     for (int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
}
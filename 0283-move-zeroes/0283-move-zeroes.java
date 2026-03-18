class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        // wheneeve we swap, we keep track this was ex to last non-zero place
        int nonZero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                //swap
                int temp=nums[nonZero];
                nums[nonZero]=nums[i];
                nums[i]=temp;
                nonZero++;
            }

        }
    }
        
}
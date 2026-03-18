class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort the array
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2]
        //HashSet<Integer> visited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num= nums[i];
            if(i > 0 && nums[i]==nums[i-1])
                continue;
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum= nums[i]+nums[l]+nums[r];
                if(sum > 0 )
                    // need to decrease sum so 
                    r--;
                else if( sum <0 )
                 l++;
                 else{
                    result.add(List.of(nums[i],nums[l],nums[r]));
                    l++;
                    while(nums[l]==nums[l-1] && (l<r))
                        l++;
                 }
            }
            
        }
        return result;

    }

    List<Integer> getTriplet(int i,int[]nums){
        int left=i+1;
        int right=nums.length-1;
        int target = -nums[i];
        List<Integer> result= new ArrayList<>();

        while(left<right && left <=nums.length){

            int sum = nums[left]+nums[right];
            if(sum==target){
                result.add(nums[i]);
                result.add(nums[left]);
                result.add(nums[right]);
                return result; 
            }
            if(sum > target ){
                right--;
            }
            else{
                left++;
            }

        }
        return null;
    }
}
class Solution {
    public int maxArea(int[] height) {

        int left=0;
        int right=height.length-1;
        int maxVolume=Integer.MIN_VALUE;
        while(left < right ){
            int width = right-left;
            int area = Math.min(height[left] , height[right])*width;
            maxVolume = Math.max(maxVolume,area);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxVolume;
        
    }
}
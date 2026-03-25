class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //return brute(piles,h);
        return binarySearch(piles,h);
    }


    static int binarySearch(int[] banana,int h){
        // in an array of 1..maxRate(max num of banans in pile), search which takes lowest time.
        int left=1;
        int right= Arrays.stream(banana).max().getAsInt();
        while(left<right){
            int mid=(left+right)/2;
            if(timeTaken(banana,mid) > h){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;

    }

    public static int  timeTaken(int[] banana,int rate){
        int time=0;
        for(int numOfBanana: banana){
            time+=(numOfBanana/rate)+(numOfBanana%rate==0?0:1);

        }
        return time;
    }

    static int brute(int[] banana,int h){
        //sort
        Arrays.sort(banana);
        // time will be min 1hr - to max time taken for a tree
        //start from 1 and calculate for each and compare ith total time
        for(int i=1;i<=banana[banana.length-1];i++){
            int totalTime=0;
            for(int j=0;j<banana.length;j++){
                totalTime+=((banana[j]+i-1)/i);
                //System.out.println("total time taken when "+i+" banana per hour for "+banana[j]+" banana is "+((banana[j]+i-1)/i));
            }

            //System.out.println("Total time taken when "+i+" banana per hour is "+totalTime);
            if(totalTime<=h){
                return i;

            }
                
            

        }
        return 0;

    }
    }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        return optimizedSlidingWindow(s);
    }

    int optimizedSlidingWindow(String s){
        int left=0;
        int right=0;
         if(s.length()==0)
            return 0;
        
        Integer maxSize=Integer.MIN_VALUE;
        Set<Character> seenChar= new HashSet<>();
        for(right=0;right<s.length();right++){
            char currChar = s.charAt(right);
           while(seenChar.contains(s.charAt(right))){
            seenChar.remove(s.charAt(left));
            left++;
           }
           seenChar.add(s.charAt(right));
           maxSize=Math.max(maxSize,right-left+1);

        }
        return maxSize;
    }

    int bruteSlidingWindow(String s){
         //int firstPt=0;
        int len = s.length();
        if(len==0)
            return 0;
        
        Set<Character> uniqueCharInSubStr = new HashSet<>();
        int maxSize= Integer.MIN_VALUE;
        for(int firstPt=0;firstPt<len;firstPt++){
            char startChar= s.charAt(firstPt);
            uniqueCharInSubStr.add(startChar);
            int secondPt=firstPt+1;
            StringBuilder sb = new StringBuilder();
            sb.append(startChar);
            while(secondPt < len && uniqueCharInSubStr.add(s.charAt(secondPt))){
                sb.append(s.charAt(secondPt));
                secondPt++;
            }
            uniqueCharInSubStr.clear();
            maxSize=Math.max(maxSize,sb.toString().length());
        }
        return maxSize;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
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
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //insert in map with frequencies.
        //then use min-heap to track only top k
        Map<Integer,Integer> numFreq= new HashMap<>();
        for(int num : nums){
            numFreq.put(num, numFreq.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (numFreq.get(a)-numFreq.get(b)));
        for(int num : numFreq.keySet()){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            result[i]=pq.poll();
            i++;
        }
        
        return result;

    }
       }



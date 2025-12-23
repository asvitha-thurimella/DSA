class Solution {
    public int maxTwoEvents(int[][] events) {
    
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int numOfEvents = events.length;
      
        
        int[] maxValueAfter = new int[numOfEvents + 1];
        for (int i = numOfEvents - 1; i >= 0; --i) {
            maxValueAfter[i] = Math.max(maxValueAfter[i + 1], events[i][2]);
        }

        int maxTotalValue = 0;
      
        for (int[] event : events) {
            int value = event[2];
            int left = 0, right = numOfEvents;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (events[mid][0] > event[1]) {
                    
                    right = mid;
                } else {
                   
                    left = mid + 1;
                }
            }
          
           
            if (left < numOfEvents) {
                value += maxValueAfter[left];
            }
          
            
            maxTotalValue = Math.max(maxTotalValue, value);
        }
        return maxTotalValue;
    }
}

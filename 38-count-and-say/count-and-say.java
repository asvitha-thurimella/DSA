class Solution {
    public String countAndSay(int n) {
     String currentSequence = "1";
      
      
        while (--n > 0) {
            StringBuilder nextSequence = new StringBuilder();
          
            
            for (int currentIndex = 0; currentIndex < currentSequence.length();) {
            
                int endIndex = currentIndex;
                while (endIndex < currentSequence.length() && 
                       currentSequence.charAt(endIndex) == currentSequence.charAt(currentIndex)) {
                    endIndex++;
                }
              
                
                int count = endIndex - currentIndex;
                nextSequence.append(count);
              
              
                nextSequence.append(currentSequence.charAt(currentIndex));
              
               
                currentIndex = endIndex;
            }
          
            // Update the current sequence for the next iteration
            currentSequence = nextSequence.toString();
        }
      
        return currentSequence;
        
    }
}
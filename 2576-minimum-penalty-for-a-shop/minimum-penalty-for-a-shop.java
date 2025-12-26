class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') penalty++;
        }
        
        int minPenalty = penalty;
        int bestHour = 0;
        
        // Move closing hour from 0 to n
        for (int j = 0; j < customers.length(); j++) {
            if (customers.charAt(j) == 'Y') {
                penalty--; // no longer penalized
            } else {
                penalty++; // open but no customers
            }
            
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j + 1;
            }
        }
        
        return bestHour;
    }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // track which elements are already used
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: if current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // add a copy of current list
            return;
        }

        // Try every unused number in this position
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip if already used

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore further
            backtrack(nums, current, used, result);

            // Undo (backtrack)
            used[i] = false;
            current.remove(current.size() - 1);
        }    
    }
}
class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        // Map prime factor -> indices divisible by it
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            List<Integer> factors = getPrimeFactors(nums[i]);

            for (int f : factors) {
                map.computeIfAbsent(f, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int idx = q.poll();

                if (idx == n - 1)
                    return jumps;

                // Adjacent left
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // Adjacent right
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // Prime teleportation
                if (isPrime(nums[idx])) {

                    int p = nums[idx];

                    if (map.containsKey(p)) {

                        for (int next : map.get(p)) {

                            if (!visited[next]) {
                                visited[next] = true;
                                q.offer(next);
                            }
                        }

                        // Important optimization
                        map.remove(p);
                    }
                }
            }

            jumps++;
        }

        return -1;
    }

    // Check if number is prime
    private boolean isPrime(int x) {

        if (x < 2) return false;

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }

        return true;
    }

    // Get unique prime factors
    private List<Integer> getPrimeFactors(int x) {

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0) {

                factors.add(i);

                while (x % i == 0)
                    x /= i;
            }
        }

        if (x > 1)
            factors.add(x);

        return factors;
        
    }
}
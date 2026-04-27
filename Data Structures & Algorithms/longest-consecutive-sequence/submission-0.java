
class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        Map<Integer, Boolean> exploredMap = new HashMap<>();

        for (int num : nums) {
            exploredMap.put(num, false);
        }

        for (int num : nums) {
            if (exploredMap.get(num)) continue;

            int currentLength = 1;
            exploredMap.put(num, true);

            int nextNum = num + 1;
            while (exploredMap.containsKey(nextNum) && !exploredMap.get(nextNum)) {
                currentLength++;
                exploredMap.put(nextNum, true);
                nextNum++;
            }

            int prevNum = num - 1;
            while (exploredMap.containsKey(prevNum) && !exploredMap.get(prevNum)) {
                currentLength++;
                exploredMap.put(prevNum, true);
                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;
    }
}
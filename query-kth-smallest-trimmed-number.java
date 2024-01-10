class Solution {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int numOfStrings = nums.length;
        int numOfQueries = queries.length;
        int[] answers = new int[numOfQueries];
        String[][] trimmedAndIndices = new String[numOfStrings][2];
        for (int i = 0; i < numOfQueries; ++i) {
            int k = queries[i][0];
            int trimLength = queries[i][1];
          
            for (int j = 0; j < numOfStrings; ++j) {
                trimmedAndIndices[j] = new String[] {
                    nums[j].substring(nums[j].length() - trimLength),
                    String.valueOf(j)
                };
            }
            Arrays.sort(trimmedAndIndices, (a, b) -> {
                int comparison = a[0].compareTo(b[0]);
                return comparison == 0 ? Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])) : comparison;
            });
            answers[i] = Integer.parseInt(trimmedAndIndices[k - 1][1]);
        }
        return answers;
    }
}

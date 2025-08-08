class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> arr = new ArrayList<>();
        int n = intervals.length;
        int i=0;
        while(i<n && intervals[i][1] < newInterval[0])
        {
            arr.add(new ArrayList(Arrays.asList(intervals[i][0], intervals[i][1])));
            i++;
        }
        while(i<n && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        arr.add(new ArrayList(Arrays.asList(newInterval[0], newInterval[1])));
        while(i<n)
        {
            arr.add(new ArrayList(Arrays.asList(intervals[i][0], intervals[i][1])));
            i++;
        }

        int m = arr.size();
        int[][] res = new int[m][2];
        for (int j = 0; j < m; j++) {
            res[j][0] = arr.get(j).get(0);
            res[j][1] = arr.get(j).get(1);
        }
        return res;
    }
}
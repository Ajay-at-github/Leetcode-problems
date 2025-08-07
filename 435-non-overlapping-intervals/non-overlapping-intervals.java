class Solution {
    static class Data
    {
        int start;
        int end;
        Data(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Data[] arr = new Data[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            arr[i] = new Data(intervals[i][0], intervals[i][1]);
        }
        
        Arrays.sort(arr, (a, b) -> a.end - b.end);
        
        int count = 0;
        int lastFreeTime = arr[0].end;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i].start < lastFreeTime)
            {
                count++;
            }
            else
            {
                lastFreeTime = arr[i].end;
            }
        }
        return count;
    }
}
package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumFind {
    public static int findTargetSumWays(int[] nums, int S) {
//        return dfsRecursive(0, nums, 0, S);
        return dfsNoRecursive(nums, S);
    }

    public static int dfsRecursive(int i, int nums[], int sum, int S) {
        if (i == nums.length  && sum== S)
            return 1;
        if (i == nums.length ) return 0;
        else {
            return dfsRecursive(i + 1, nums, sum + nums[i], S) + dfsRecursive(i + 1, nums, sum - nums[i], S);
        }
    }
    public static int dfsNoRecursive(int []nums,int S){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        boolean first=true;
        int levelcnt=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
                int t=queue.size();
                HashSet<Integer> integers=new HashSet<>();
                for(int j=0;j<t;j++){
                    int sum=queue.poll();
                    if(!integers.contains(sum)) {
                        if (i == nums.length) {
                            break;
                        } else {
                            queue.offer(sum + nums[i]);
                            queue.offer(sum - nums[i]);
                        }
                        integers.add(sum);
                    }
                }
        }
        while (!queue.isEmpty()){
            if(queue.poll()==S){
                ans++;
            }
        }
        return ans;
    }
    public int sum(int nums[],boolean sign[]){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sign[i])
                sum+=nums[i];
            else
                sum-=nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(SumFind.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}

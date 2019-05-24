package LeetCode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTravel {
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int levelcnt=0;
        if(root!=null){
            q.offer(root);
            levelcnt=1;
        }
        while(!q.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int n=levelcnt;
            levelcnt=0;
            for(int i=0;i<n;i++){
                TreeNode tmp=q.poll();
                if(tmp==null) continue;
                if(tmp.left!=null){
                    q.offer(tmp.left);
                    levelcnt++;
                }
                if(tmp.right!=null){
                    q.offer(tmp.right);
                    levelcnt++;
                }
                list.add(tmp.val);
            }
            ans.add(list);
        }
        return ans;
    }
}
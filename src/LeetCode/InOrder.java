package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null) return ans;
        stack.push(root);
        TreeNode temp=root;
        while(!stack.isEmpty()){
            if(temp!=null&&temp.left!=null){
                stack.push(temp.left);
                temp=temp.left;
            }
            else{
                temp=stack.pop();
                ans.add(temp.val);
                if(temp!=null&&temp.right!=null){
                    stack.push(temp.right);
                    temp=temp.right;
                }else
                    temp=null;

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        System.out.println(InOrder.inorderTraversal(root).toString());
    }
}
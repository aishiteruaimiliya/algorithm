package LeetCode;

import java.util.Stack;

class SolutionR {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);

    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null^right==null) return false;
        if(left.val == right.val){
            return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
        }
        return false;
    }
}
class SolutionS{
    public boolean isSymmetric(TreeNode root){
        Stack<TreeNode> s=new Stack<>();
        if(root==null) return true;
        if(root.left!=null&&root.right!=null){
            s.push(root.left);
            s.push(root.right);
        }else if(root.left!=null^root.right!=null){
            return false;
        }
        while(!s.isEmpty()){
            TreeNode right=s.peek();
            s.pop();
            TreeNode left=s.peek();
            s.pop();
            if(left.val!=right.val)
                return false;
            if(left.left!=null&&right.right!=null){
                s.push(left.left);
                s.push(right.right);
            }else if(left.left!=null^right.right!=null){
                return false;
            }
            if(left.right!=null&&right.left!=null){
                s.push(left.right);
                s.push(right.left);
            }else if(left.right!=null^right.left!=null){
                return false;
            }
        }
        return true;
    }
}

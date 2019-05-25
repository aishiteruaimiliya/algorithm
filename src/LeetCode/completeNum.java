package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class completeNum {
    public static int numSquares(int n) {
        ArrayList<Integer> mi=new ArrayList<>();
        int idx=1;
        /**
         * 获取可能的完全平方数
         */
        while(idx*idx<=n){
            mi.add(idx*idx);
            idx++;
        }
        int cnt=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(n);
        boolean first=true;
        int size=0;
        while(!q.isEmpty()){
            int t=size;
            size=0;
            if(first) {t=1;first=false;}
            /***
             * 上次bfs加入的一圈状态
             */
            for(int i=0;i<t;i++){
                int start=q.poll();
                /***
                 * 枚举状态
                 */
                for(int j=0;j<mi.size();j++){
                    int tmp=start-mi.get(j);
                    if(tmp==0) return cnt;
                    else if(tmp>0){
                        q.offer(tmp);
                        size++;
                    }
                }
            }
            cnt++;
        }
        return cnt+1;
    }

    public static void main(String[] args) {
       System.out.println(completeNum.numSquares(12));
       MinStack minStack=new MinStack();
       minStack.push(-2);
       minStack.push(0);
       minStack.push(-3);
       minStack.getMin();
       minStack.pop();
       minStack.top();
       minStack.getMin();
    }
}
class MinStack {
    ArrayList<Integer> stack;
    int min=Integer.MAX_VALUE;
    int sp=-1;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new ArrayList<>();
    }

    public void push(int x) {
        if(x<min)
            min=x;
        stack.add(x);
        sp++;
    }

    public void pop() {
        if(stack.get(sp)==min){
            stack.remove(sp);
            sp--;
            min=stack.get(sp);
            for(int i:stack){
                if(i<min)
                    min=i;
            }
        }else{
            stack.remove(sp);
            sp--;
        }
    }

    public int top() {
        return stack.get(sp);
    }

    public int getMin() {
        return min;
    }
}
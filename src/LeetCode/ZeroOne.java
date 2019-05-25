package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOne {
    /**
     *
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     *
     * 两个相邻元素间的距离为 1 。
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        Queue<Integer> q=new LinkedList<>();
        int row=matrix.length;
        int col=matrix[0].length;
        int forward[][]=new int[][]{{0,0,1,-1},{1,-1,0,0}};
        int ans[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    int x=i;
                    int y=j;
                    ans[x][y]=row*col;
                    int cnt=0;
                    q.offer(x);
                    q.offer(y);
                    boolean first=true;
                    int level=0;
                    while(!q.isEmpty()){
                        int t=level;
                        if(first){
                            t=1;
                            first=false;
                        }
                        level=0;
                        for(int m=0;m<t&&!q.isEmpty();m++){
                            int tempx=q.poll();
                            int tempy=q.poll();
                            for(int k=0;k<4;k++){
                                int nextx=tempx+forward[0][k];
                                int nexty=tempy+forward[1][k];
                                if(nextx<row&&nextx>=0&&nexty>=0&&nexty<col){
                                    if(matrix[nextx][nexty]==0) {ans[x][y]=cnt+1;q.clear();break;}
                                    else{
                                        q.offer(nextx);
                                        q.offer(nexty);
                                        level++;
                                    }
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }
        }
        return ans;
    }
}

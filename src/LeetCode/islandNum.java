package LeetCode;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

class islandNum {
    /***
     * used bfs
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        Queue<Integer> q=new LinkedList<>();
        if(grid.length==0) return 0;
        int pos[][]=new int[][]{{0,0,1,-1},{1,-1,0,0}};
        int row=grid.length;
        int col=grid[0].length;
        int cnt=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                boolean flag=false;
                if(grid[i][j]=='1'){
                    q.offer(i);
                    q.offer(j);
                    flag=true;
                }
                while(!q.isEmpty()){
                    int x=q.poll();
                    int y=q.poll();
                    grid[x][y]='0';
                    for(int k=0;k<4;k++){
                        int nextx=x+pos[0][k];
                        int nexty=y+pos[1][k];
                        if(nextx>=0&&nextx<row&&nexty>=0&&nexty<col){
                            if(grid[nextx][nexty]=='1'){
                                q.offer(nextx);
                                q.offer(nexty);
                                //避免一种情况，就是两个连着的一，可能会有某一个1的位置会不停的被加入又弹出。
                                grid[nextx][nexty]='0';
                            }
                        }
                    }
//                    for(char c[]:grid){
//                        System.out.println(Arrays.toString(c));
//                    }
                }
                if(flag)
                    cnt++;

            }
        }
        return cnt;
    }

    /***
     * used dfs
     * @param grid
     * @return
     */
    public static int numIslandsdfs( char grid[][]){
        Stack<Integer> s=new Stack<>();
        boolean mark[][]=new boolean[grid.length][grid[0].length];
        int forward[][]=new int[][]{{0,0,1,-1},{1,-1,0,0}};
        int ans=0;
        for(int m=0;m<grid.length;m++){
            for(int n=0;n<grid[0].length;n++){
                if(grid[m][n]=='1'&&!mark[m][n]){
                    s.push(m);
                    s.push(n);
                    while(!s.isEmpty()){
                        int y=s.pop();
                        int x=s.pop();
                        for(int i=0;i<4;i++){
                            int nextx=x+forward[0][i];
                            int nexty=y+forward[1][i];
                            /***
                             * 枚举搜索状态并压栈标记已访问，避免免重复访问死循环
                             */
                            if(nextx>=0&&nextx<grid.length&&nexty<grid[0].length&&nexty>=0&&!mark[nextx][nexty]&&grid[nextx][nexty]=='1'){
                                s.push(nextx);
                                s.push(nexty);
                                mark[nextx][nexty]=true;
                            }
                        }
                    }
                    ans++;
                }

//                for(boolean bool[]:mark)
//                System.out.println(Arrays.toString(bool));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        char input[][]={{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                        {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                        {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                        {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                        {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        //System.out.println(input.length);
        long begin=System.currentTimeMillis();
        System.out.println(islandNum.numIslands(input));
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
        begin=System.currentTimeMillis();
        System.out.println(islandNum.numIslandsdfs(input));
        end=System.currentTimeMillis();
        System.out.println(end-begin);
    }

}
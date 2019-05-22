package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class NO3 {
    /***
     * 这一题使用了窗口算法
     * 首先先使用两个指针i，j，并创建一个set保存已经出现过的字符
     * 先让j向右移动，直到遇到重复字符，然后移动左边的指针i，直到左边的指针排除掉重复的字符，j才能移动
     */
    public int solve(String s){
        int i=0,j=0,ans=0;
        HashSet<Character> set=new HashSet<>();
        while(i<s.length()&&j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

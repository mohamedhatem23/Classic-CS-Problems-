import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int[] nxtG = new int[height.length];
        
        for (int i = height.length-1; i >= 0; --i)
        {
            int mx = -1;
            while (!st.empty() && height[i] > st.peek())
                mx = Math.max(mx, st.pop());

            if (st.empty() && mx == -1)
                nxtG[i] = -1;
            else if (st.empty())
                nxtG[i] = mx;
            else
                nxtG[i] = st.peek();

            st.push(height[i]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; )
        {
            if (nxtG[i] == -1)
            {
                i++;
                continue;
            }
            
            int need = nxtG[i], sum = 0, idx = 0;
            for (int j = i+1; j < height.length; ++j)
            {
                if (height[j] == need)
                {
                    ans += Math.min(height[i], nxtG[i]) * (j - i - 1) - sum;
                    idx = j;
                    break;
                }
                sum += height[j];
            }
            i = idx;
        }

        return (int)ans;
    }
}


public class Main
{
    public static void main(String[] args)
    {
        Solution S = new Solution();
        System.out.println(S.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));    // 6
        System.out.println(S.trap(new int[] {4,2,0,3,2,5}));                // 9
        System.out.println(S.trap(new int[] {4,2,3}));                      // 1
    }
}

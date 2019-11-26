还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴
拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/matchsticks-to-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean makesquare(int[] nums) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%4!=0||nums.length<4){
            return false;
        }
        Arrays.sort(nums);
        int target=sum/4;
        int[] bucket=new int[4];
        return makesquare(nums.length-1,nums,bucket,target);
    }

    private boolean makesquare(int i,int[] nums,int[] bucket,int target){
        if(i<0){
            return bucket[0]==target&&bucket[1]==target&&bucket[2]==target&&bucket[3]==target;
        }
        for(int j=0;j<4;j++){
            if(bucket[j]+nums[i]>target){
                continue;
            }
            bucket[j]+=nums[i];
            if(makesquare(i-1,nums,bucket,target)){
                return true;
            }
            bucket[j]-=nums[i];
        }
        return false;
    }
}


我们有两个长度相等且不为空的整型数组 A 和 B 。

我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。

在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。

给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int minSwap(int[] A, int[] B) {
        int n1=0;
        int s1=1;
        for(int i=1;i<A.length;i++){
            int n2=Integer.MAX_VALUE;
            int s2=Integer.MAX_VALUE;
            if(A[i-1]<A[i]&&B[i-1]<B[i]){
                n2=Math.min(n2,n1);
                s2=Math.min(s2,s1+1);
            }
            if(A[i-1]<B[i]&&B[i-1]<A[i]){
                n2=Math.min(n2,s1);
                s2=Math.min(s2,n1+1);
            }
            n1=n2;
            s1=s2;
        }
        return Math.min(n1,s1);
    }
}


在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。

注意:
n 是正数且在32为整形范围内 ( n < 231)。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/nth-digit
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findNthDigit(int n) {
        int i=0;
        for(i=1;n-i*9*Math.pow(10,i-1)>0;i++){
            n-=i*9*Math.pow(10,i-1);
        }
        int k_num=(int)Math.pow(10,i-1)-1;
        int a=n/i;
        int b=n%i;
        k_num+=a;
        if(b==0){
            return k_num%10;
        }
        k_num++;
        int num=0;
        int tmp=i-b+1;
        while(tmp!=0){
            num=k_num%10;
            tmp--;
            k_num/=10;
        }
        return num;
    }
}
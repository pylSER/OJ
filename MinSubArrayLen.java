package HelloTest;

import java.util.Arrays;

public class MinSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {
        int sum=0;
        for (int a:nums
             ) {
            sum+=a;
        }

        if(sum<s){
            return 0;
        }else if(sum==s){
            return nums.length;
        }else{
            int minLength=nums.length;
            for (int i = 0; i <nums.length ; i++) {
                int partialSum=nums[i];
                if(partialSum>=s){
                    return 1;
                }


                if(i==nums.length-1){
                    return minLength;
                }

                int looptime=minLength+i;
                if(looptime>nums.length){
                    looptime=nums.length;
                }


                for(int j=i+1;j<looptime;j++){
                    partialSum+=nums[j];
                    if(partialSum>=s){
                        minLength=j-i+1;
                        break;
                    }
                }
            }

            return minLength;
        }



    }





    public static void main(String[] args){
        int[] test ={5,1,3,5,10,7,4,9,2,8};
        int res=minSubArrayLen(15,test);
        System.out.println(res);
    }
}

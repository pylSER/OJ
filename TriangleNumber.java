package HelloTest;

import java.util.Arrays;

public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int res=0;

        for (int i = 0; i <nums.length ; i++) {
            int firstNum=nums[i];

            for (int j = i+1; j <nums.length; j++) {
                int secondNum=nums[j];

                //nums[j] always greater than nums[i]

                int twoSum=firstNum+secondNum;

                int index=Arrays.binarySearch(nums,twoSum);

                int realIndex=0;

                if(index>=0){//find one
                    realIndex=index;
                }else{ // -x
                    realIndex=0-index-1;
                }

                if(realIndex>nums.length-1){
                    realIndex=nums.length-1;
                }

                for (int k = realIndex; k >=j+1; k--) {
                    if(nums[k]<twoSum){
                        res++;
                    }
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        TriangleNumber test =new TriangleNumber();
        int[] testArr={2,2,3,4};
        System.out.println(test.triangleNumber(testArr));
    }
}

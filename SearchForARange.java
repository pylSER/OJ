package HelloTest;

import java.util.Arrays;

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {

        int a=Arrays.binarySearch(nums,target);

        if(a<0){
            return new int[]{-1,-1};
        }


        int leftcount=0;
        //go left
        for (int i = a; i >=0 ; i--) {
            if(nums[i]!=target){
                break;
            }else {
                leftcount++;
            }
        }

        int rightcount=0;
        //go right
        for (int i = a; i <nums.length ; i++) {
            if(nums[i]!=target){
                break;
            }else {
                 rightcount++;
            }
        }

        int[] res=new int[2];
        res[0]=a-leftcount+1;
        res[1]=a+rightcount-1;

        return res;
    }




    public static void main(String[] args){
        SearchForARange test=new SearchForARange();

        int[] nums={5,7,7,8,8,10};

        int target=6;

        System.out.println(Arrays.toString(test.searchRange(nums,target)));
    }
}

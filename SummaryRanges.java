package HelloTest;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<>();


        boolean isSingle=true;

        if(nums.length==0){
            return list;
        }else if (nums.length==1){
            list.add(nums[0]+"");
            return list;
        }

        String startNum=nums[0]+"";

        for (int i =0; i <nums.length; i++) {

            if(i==nums.length-1){
                if(nums[i]-1==nums[i-1]){
                    list.add(startNum+"->"+nums[i]);
                }else {
                    list.add(""+nums[i]);
                }
                break;
            }



            if((nums[i]+1)!=nums[i+1]){
                if(isSingle){
                    list.add(startNum);
                }else {
                    list.add(startNum+"->"+nums[i]);
                }
                isSingle=true;
                startNum=nums[i+1]+"";

            }else{



                isSingle=false;
            }
        }

        return list;
    }


    public static void main(String[] args){
        SummaryRanges test=new SummaryRanges();

        int[] nums={0,2,3,4,6,8,9};

        System.out.println(test.summaryRanges(nums));
    }




}

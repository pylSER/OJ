package HelloTest;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {



    public void nextPermutation(int[] nums) {

        boolean isSwaped=false;

//        ArrayList<IandJ> iList=new ArrayList<>();

        int biggestI=-1;
        int biggestJ=-1;

        for(int j=nums.length-1;j>=0;j--){
            for (int i = j; i>=0; i--) {
                if(nums[i]<nums[j]){

                    if(i>biggestI){
                        biggestI=i;
                        biggestJ=j;
                    }

                    isSwaped=true;

//                    swap(nums,i,j);
//
//                    System.out.println("swap"+i+"to"+j);
//
//                    sortAfterI(nums,i);
//                    isSwaped=true;
//                    break;
//                    IandJ iandJ=new IandJ();
//                    iandJ.i=i;
//                    iandJ.j=j;
//                    iList.add(iandJ);
                }
            }
        }


        if(!isSwaped){
            Arrays.sort(nums);
            return;
        }else{
            // find the biggest i

            swap(nums,biggestI,biggestJ);
            sortAfterI(nums,biggestI);
        }

        System.out.println(Arrays.toString(nums));
    }



    private void swap(int[] nums,int i,int j){
        int a=nums[i];

        nums[i]=nums[j];

        nums[j]=a;

    }


    private void sortAfterI(int[] nums,int i){
        int j=nums.length-1;
        i++;

        for (;i<j;i++){
            swap(nums,i,j);
            j--;
        }
    }



    public static void main(String[] args){
        int[] nums={4,2,0,2,3,2,0};

        NextPermutation nextPermutation=new NextPermutation();

        nextPermutation.nextPermutation(nums);
    }
}

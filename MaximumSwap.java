package HelloTest;

import java.util.Arrays;

public class MaximumSwap {

    public int maximumSwap(int num) {

        String numStr=num+"";

        int[] numArr=new int[numStr.length()];

        int[] orgArr=new int[numStr.length()];

        for (int i = 0; i < numStr.length(); i++) {
            numArr[i]=numStr.charAt(i)-'0';
            orgArr[i]=numStr.charAt(i)-'0';
        }



        Arrays.sort(numArr);

        int[] resArr=new int[numStr.length()];

        int j=0;

        for (int i = numArr.length-1; i >=0; i--) {
            resArr[j]=numArr[i];
            j++;
        }


        //res now is reverse sort
        int bigNum=0;
        int smallNum=0;
        for (int i = 0; i <numArr.length ; i++) {
            if(resArr[i]==orgArr[i]){
                continue;
            }

            bigNum=resArr[i];
            smallNum=orgArr[i];
            orgArr[i]=resArr[i];


            break;
        }


        //replace the small num in orgArr

        for (int i = orgArr.length-1; i >=0 ; i--) {
            if(orgArr[i]==bigNum){
                orgArr[i]=smallNum;
                break;
            }
        }

        // assemble to int
        String result="";
        for (int i = 0; i <orgArr.length ; i++) {
            result+=orgArr[i];
        }

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        MaximumSwap testCase=new MaximumSwap();

        System.out.println(testCase.maximumSwap(983688));
    }
}

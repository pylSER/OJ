package HelloTest;

public class FindTargetSumWays {
    int[] publicNum;
    int res=0;
    int publicTarget=0;
    public int findTargetSumWays(int[] nums, int S) {
        publicNum=nums;
        publicTarget=S;

        dp(0,0);

        return res;
    }

    private void dp(int startIndex,int currSum){


        if(startIndex==publicNum.length){
            if(currSum==publicTarget){
                res++;
            }
            return;
        }else{
            dp(startIndex+1,currSum+publicNum[startIndex]);
            dp(startIndex+1,currSum-publicNum[startIndex]);
        }
    }

    public static void main(String[] args) {
        FindTargetSumWays test=new FindTargetSumWays();

        int[] nums={1, 1, 1, 1, 1};
        int target=3;

        System.out.println(test.findTargetSumWays(nums,target));
    }
}

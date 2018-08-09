package HelloTest;

import java.util.HashMap;
import java.util.HashSet;

public class CanJump {

    HashMap<Integer,Boolean> memoMap=new HashMap<>();

    public boolean canJump(int[] nums) {
        return dp(nums,nums.length-1);
    }

    private boolean dp(int[] nums,int targetIndex){
        if(targetIndex==0){
            return true;
        }else{
            if(memoMap.containsKey(targetIndex)){
                return memoMap.get(targetIndex);
            }

            for (int i = targetIndex-1; i >=0; i--) {
                int maxStep=nums[i];

                int realStep=targetIndex-i;

                if(realStep<=maxStep){
                    boolean res=dp(nums,i);
                    if(res==true){
                        memoMap.put(i,true);
                        return true;
                    }else {
                        memoMap.put(i,false);
                    }
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        CanJump canJump=new CanJump();

        int[] arr={2,3,1,1,4};

        System.out.println(canJump.canJump(arr));
    }
}

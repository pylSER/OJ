package HelloTest;

import java.util.HashMap;

public class MinSteps {
//Wrong

    HashMap<Integer,Integer> memoMap=new HashMap<>();

    public int minSteps(int n) {
        if(n<=1){
            return 0;
        }


        if(isPrime(n)){
            return n;
        }
        
        memoMap.put(1,0);
        memoMap.put(2,2);
        memoMap.put(3,3);
        memoMap.put(4,4);
        memoMap.put(5,5);
        memoMap.put(6,5);
        memoMap.put(7,7);
        memoMap.put(8,6);
        memoMap.put(9,6);

        int bias=0;

        if(n%2==0){
            bias=2;
        }else {
            for (int i = 3; i < 10 ; i++) {
                if(n%i==0){
                    bias=i;
                }
            }
        }


        int res=dp(n,bias);

        if(bias!=2){
            return res+1;
        }else {
            return res;
        }
    }


    private int dp(int n,int bias){
        if(memoMap.containsKey(n)){
            return memoMap.get(n);
        }else {
            if(isPrime(n)){
                memoMap.put(n,n);
                return n;
            }

            int res=0;

            if(bias==2){
                res=dp(n/2,bias)+2;
            }else{
                res=dp(n-bias,bias)+1;
            }

            memoMap.put(n,res);
            return res;
        }
    }

    private boolean isPrime(int num){
        boolean isprime=true;
        int len=num/2;
        for(int i=2;i<len;i++){
            if(num%i==0){
                isprime=false;
                break;
            }
        }
        return isprime;
    }

    public static void main(String[] args) {
        MinSteps test=new MinSteps();
        System.out.println(test.minSteps(999));
    }
}

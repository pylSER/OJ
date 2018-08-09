package HelloTest;

import java.util.Arrays;

public class MinEatingSpeed {

    int bananaTotal=0;

    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);

        if(H<=piles[piles.length-1]){
            return piles[piles.length-1];
        }else {
            //eat less than max
            int lowerIndex=0;

            for (int i = piles.length-1; i >=0; i--) {

            }
        }

        return 0;


    }


    private int eatHour(int[] piles,int rate){
        bananaTotal=0;
        int[] copy=new int[piles.length];

        for (int i = 0; i <piles.length ; i++) {
            copy[i]=piles[i];
            bananaTotal+=piles[i];
        }

        int currIndex=0;

        while (bananaTotal!=0){
            if(copy[currIndex]>rate){
                copy[currIndex]-=rate;
                bananaTotal-=rate;
            }else {
                bananaTotal-=copy[currIndex];
                copy[currIndex]=0;
                currIndex+=1;
            }
        }

return 0;

    }

    public static void main(String[] args) {
        MinEatingSpeed test=new MinEatingSpeed();
        int[] piles={3,6,7,11};

        System.out.println(test.minEatingSpeed(piles,8));
    }
}

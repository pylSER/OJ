package HelloTest;

import java.util.Arrays;

public class UpdateMatrix {

    int[][] memoArr;

    int[][] resArr;


    public int[][] updateMatrix(int[][] matrix) {
        resArr=new int[matrix.length][matrix[0].length];
        memoArr =new int[matrix.length][matrix[0].length];

        //init
        for (int i = 0; i <matrix.length ; i++) {
            Arrays.fill(resArr[i],0);
            Arrays.fill(memoArr[i],-1);
        }

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                int[][] markArr=new int[matrix.length][matrix[0].length];

                resArr[i][j]=getDistance(matrix,i,j,markArr);
            }
        }


//        int[][] markArr=new int[matrix.length][matrix[0].length];
//        System.out.println(getDistance(matrix,2,2,markArr));

        for (int i = 0; i <memoArr.length ; i++) {
            System.out.println(Arrays.toString(memoArr[i]));
        }


        return resArr;
    }


    private int getDistance(int[][] matrix,int i,int j,int[][] markArr){
        //now judge need to explore

        //out of bounds
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length){
            return 99999;
        }

        //explored

        if(markArr[i][j]==1){
            return 9999;
        }

        //now explore

        //in the cache
        if(memoArr[i][j]!=-1){
            return memoArr[i][j];
        }

        //0
        if(matrix[i][j]==0){
            memoArr[i][j]=0;
            markArr[i][j]=0;
            return 0;
        }else{
            markArr[i][j]=1;

            int downDis=9999;
            int upDis=9999;
            int leftDis=9999;
            int rightDis=9999;



            downDis=getDistance(matrix,i+1,j,markArr)+1;

            if(downDis>1){
                upDis=getDistance(matrix,i-1,j,markArr)+1;
            }

            if(upDis>1){
                leftDis=getDistance(matrix,i,j-1,markArr)+1;
            }

            if(leftDis>1){
                rightDis=getDistance(matrix,i,j+1,markArr)+1;
            }


            int minDis1=Math.min(upDis,downDis);
            int minDis2=Math.min(leftDis,rightDis);

            int minDis=Math.min(minDis1,minDis2);

            System.out.println("("+j+","+i+") is "+minDis+"  up is"+upDis+" down is"+downDis+" left is"+leftDis+" right is"+rightDis);

            markArr[i][j]=0;


            if(minDis<matrix.length*matrix[0].length) {
                memoArr[i][j] = minDis;
            }
            return minDis;

        }

    }

    public static void main(String[] args) {
        UpdateMatrix test=new UpdateMatrix();
        int[][]arr={{1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                    {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                    {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                    {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                    {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                    {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                    {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                    {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                    {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                    {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}};

        System.out.println(test.updateMatrix(arr));
    }
}

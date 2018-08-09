package HelloTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
       int[][] markGrid=new int[grid.length][grid[0].length];

        ArrayList<Integer> sizes=new ArrayList<>();

        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if(grid[i][j]==1){
                    if(markGrid[i][j]==0){
                        //start explore
                        sizes.add(getIJArea(i,j,markGrid,grid));
                    }
                }
            }
        }



        if(sizes.size()==0){
            return 0;
        }

        Collections.sort(sizes);

        return sizes.get(sizes.size()-1);
    }



    private int getIJArea(int i,int j,int[][] markGrid,int[][] grid){
        if(i<0||i>=grid.length){
            return 0;
        }

        if(j<0||j>=grid[i].length){
            return 0;
        }

        if(grid[i][j]==0){
            return 0;
        }

        if(markGrid[i][j]==1){
            return 0;
        }

        markGrid[i][j]=1;

        int upArea=getIJArea(i-1,j,markGrid,grid);


        int bottomArea=getIJArea(i+1,j,markGrid,grid);


        int leftArea=getIJArea(i,j-1,markGrid,grid);


        int rightArea=getIJArea(i,j+1,markGrid,grid);


        return upArea+bottomArea+leftArea+rightArea+1;
    }









    public static void main(String[] args) {
        MaxAreaOfIsland test=new MaxAreaOfIsland();

        int[][] island={
                {0,0,0,0,0,0,0,0,0,0,0,0,0}
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(test.maxAreaOfIsland(island));
    }
}

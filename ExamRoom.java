package HelloTest;

import java.util.Arrays;

public class ExamRoom {//TLE

    int[] seats;

    public ExamRoom(int N) {
        seats=new int[N];
    }

    public int seat() {
        int num = maxDistToClosest();
        seats[num] = 1;
        System.out.println(num);
        return num;
    }

    private int maxDistToClosest(){
        int firstOne=-1;
        int secondOne=-1;

        int pos=0;

        int currentBestPos=0;

        int maxDis=0;

        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                if(firstOne==-1){
                    firstOne=i;
                    if(i>0){
                        currentBestPos=firstOne;
                        if(currentBestPos>maxDis){
                            maxDis=currentBestPos;
                            pos=0;
                        }
                    }else if(i==0){
                        continue;
                    }
                }else {
                    secondOne=i;
                    currentBestPos=(secondOne-firstOne)/2;
                    if(currentBestPos>maxDis){
                        maxDis=currentBestPos;
                        pos=firstOne+currentBestPos;
                    }
                    firstOne=secondOne;
                }
            }
        }

        if(secondOne==-1&&firstOne!=-1){
            if(firstOne>=(seats.length-1-firstOne)){
                return 0;
            }else {
                return seats.length-1;
            }
        }

        if(secondOne!=-1){
            currentBestPos=seats.length-1-secondOne;
            if(currentBestPos>maxDis){
                maxDis=currentBestPos;
                pos=seats.length-1;
            }

        }

        return pos;
    }


    public void leave(int p) {
        seats[p]=0;
    }


    public static void main(String[] args) {
        ExamRoom test=new ExamRoom(1000000000);   //MLE

        test.seat();
        test.seat();
        test.seat();


        test.leave(0);
        test.leave(4);

        test.seat();
        test.seat();
        test.seat();
        test.seat();
        test.seat();
        test.seat();
        test.seat();
        test.seat();
        test.seat();

        test.leave(0);
        test.leave(4);
//        test.seat();




        System.out.println(Arrays.toString(test.seats));
    }
}

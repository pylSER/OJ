package HelloTest;

import java.util.ArrayList;
import java.util.Arrays;

public class NetworkDelayTime {


    class NodeAndTime{
        public int nodeNo;
        public int time;
        public NodeAndTime(int nodeNo,int time){
            this.nodeNo=nodeNo;
            this.time=time;
        }
    }

    ArrayList<NodeAndTime> connectedArr;
    public int networkDelayTime(int[][] times, int N, int K) {
        //pre work
        connectedArr=new ArrayList<>();
        for (int[] route:times
             ) {
            if(route[0]==K){
                connectedArr.add(new NodeAndTime(route[1],route[2]));
            }
        }
        //end pre work



        int maxTime=0;
        for (int i = 1; i <=N ; i++) {
            if(i==K){
                continue;
            }

            int res=getConnectTime(times,i);
            if(res==-1){
                return -1;
            }else{
                if(res>maxTime){
                    maxTime=res;
                }
            }
        }
        return maxTime;
    }


    private int getConnectTime(int[][] times, int dest){
        NodeAndTime nodeAndTime=isConnectedWithK(dest);


        for (int[] route:times
                ) {
            if(route[1]==dest){
                NodeAndTime nodeAndTime1=isConnectedWithK(route[0]);
                if(nodeAndTime1!=null){
                    if(nodeAndTime!=null){
                        if(nodeAndTime.time>route[2]+nodeAndTime1.time){
                            //update min
                            updateNode(route[1],route[2]+nodeAndTime1.time);
                            return route[2]+nodeAndTime1.time;
                        }else{
                            return nodeAndTime.time;
                        }
                    }

                    connectedArr.add(new NodeAndTime(route[1],route[2]+nodeAndTime1.time));
                    return route[2]+nodeAndTime1.time;
                }
            }
        }

        if(nodeAndTime!=null){
            return nodeAndTime.time;
        }
        return -1;
    }

    private void updateNode(int nodeNo,int time){
        for (NodeAndTime node:connectedArr
                ) {
            if(node.nodeNo==nodeNo){
                node.time=time;
            }
        }
    }

    private NodeAndTime isConnectedWithK(int n){
        for (NodeAndTime node:connectedArr
             ) {
            if(node.nodeNo==n){
                return node;
            }
        }
        return null;
    }


    public static void main(String[] args){
        NetworkDelayTime networkDelayTime=new NetworkDelayTime();
        int[][] test ={{1,2,1},{2,3,2},{1,3,2}};
        int res=networkDelayTime.networkDelayTime(test,3,1);
        System.out.println(res);

    }
}

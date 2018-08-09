package HelloTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HouseRobber {
    class Item{
        int index;
        int value;

        public Item(int index,int value){
            this.index=index;
            this.value=value;
        }
    }

    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return nums[0];
        }

        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }



        PriorityQueue<Item> queue=new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.value-o1.value;
            }
        });

        for (int i = nums.length-1; i >=0 ; i--) {
            int num=nums[i];
            if(i==nums.length-1){
                queue.offer(new Item(i,num));
            }else if(i==nums.length-2){
                if(num>nums[nums.length-1]){
                    queue.offer(new Item(i,num));
                }else {
                    queue.offer(new Item(nums.length-1,nums[nums.length-1]));
                }
            }else {

                Item test1=queue.poll();

                if(i+1==test1.index){
                    Item test2=queue.peek();
                    queue.offer(new Item(i,num+test2.value));
                }else {
                    queue.offer(new Item(i,num+test1.value));
                }
                queue.offer(test1);

            }
        }

        return queue.peek().value;
    }




    public static void main(String[] args) {
        HouseRobber test=new HouseRobber();

//        int[] arr={1,3,1,3,100};
        int[] arr={};

        System.out.println(test.rob(arr));
    }
}

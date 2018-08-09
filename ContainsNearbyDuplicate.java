package HelloTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsNearbyDuplicate {




    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            int num=nums[i];

            if(map.containsKey(num)){
                List<Integer> list=map.get(num);
                list.add(i);
                map.put(num,list);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(num,list);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry:map.entrySet()) {
            if(entry.getValue().size()<=1){
                continue;
            }else{
                List<Integer> list=entry.getValue();
                for (int i = 0; i <list.size()-1 ; i++) {
                    if(list.get(i+1)-list.get(i)<=k){
                        return true;
                    }
                }

            }
        }

        return false;


    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate test=new ContainsNearbyDuplicate();
        int[] arr={1,2,3,1,2,3};
        System.out.println(test.containsNearbyDuplicate(arr,2));
    }
}

import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,4,8,8,8,6,4,3,2,3};
        int k = 1;
        System.out.println(countKDifference(nums, k));
    }

    public static int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i : nums) {
            if (numsMap.containsKey(i)) {
                numsMap.put(i, numsMap.get(i) + 1);
            }
            else numsMap.put(i, 1);
        }
        int counter = 0;
        for (Integer i : numsMap.keySet()) {
            if(numsMap.containsKey(i + k)){
                if(numsMap.get(i) < numsMap.get(i+k)) {
                    counter += numsMap.get(i + k) * numsMap.get(i);
                } else if (numsMap.get(i) > numsMap.get(i+k)) {
                    counter += numsMap.get(i) * numsMap.get(i + k);
                } else if (Objects.equals(numsMap.get(i), numsMap.get(i + k)) && numsMap.get(i) > 1){
                    counter +=numsMap.get(i) * numsMap.get(i);
                }
                else counter += numsMap.get(i);
            }
        }
        return counter;
    }
}
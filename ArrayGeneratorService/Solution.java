import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public static List<Integer> getArray(List<Integer> numValues, String state, Integer m){
        ArrayList<Integer> result = new ArrayList<>();
        char[] states = state.toCharArray();
        int startIndex = state.indexOf('1');

        for(int i = 0; i < m; i++){
            //find all current available states
            List<Integer> processingStates = IntStream.range(0, states.length)
                    .filter(e -> states[e] == '1' )
                    .boxed().toList();

            //find max
            result.add(Collections.max(numValues.stream()
                    .filter(e -> processingStates.contains(numValues.indexOf(e)))
                    .toList()));
            System.out.println(processingStates);

            //update state
            int nextUpdate = IntStream.range(0, states.length)
                    .filter(e -> (states[e] == '0' && e - 1 >=0 && states[e - 1] == '1'))
                    .findFirst()
                    .orElse(-1);
            if(nextUpdate >= 0)
                states[nextUpdate] = '1';

        }
        return result;
    }


    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(4,9,1,2,10);
        String state = "0010011110";
        int m = 4;

        List<Integer> result = getArray(arr, state, m);
        System.out.println(result);

    }


}






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
            List<Integer> processingStates = IntStream.range(0, states.length)
                    .filter(e -> states[e] == '1' )
                    .boxed().toList();

            result.add(Collections.max(numValues.stream()
                    .filter(e -> processingStates.contains(numValues.indexOf(e)))
                    .toList()));
            System.out.println(processingStates);

            for(int j = startIndex; j < states.length; j++){
                if((states[j] == '0' && j - 1 >= 0)){
                    if(states[j - 1] == '1'){
                        states[j] = '1';
                        startIndex = j;
                        break;
                    }

                }
            }
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






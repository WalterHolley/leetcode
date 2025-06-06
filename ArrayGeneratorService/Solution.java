import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static List<Integer> getArrayWithStream(List<Integer> numValues, String state, Integer m){
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
            startIndex = IntStream.range(startIndex, states.length)
                    .filter(e -> (states[e] == '0' && e - 1 >=0 && states[e - 1] == '1'))
                    .findFirst()
                    .orElse(-1);
            if(startIndex >= 0)
                states[startIndex] = '1';

        }
        return result;
    }

    public static List<Integer> getArray(List<Integer> numValues, String state, Integer m){
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> availableStates = new HashSet<>();
        char[] states = state.toCharArray();
        int startIndex = 0;
        boolean zeroFound = false;
        for(int i = 0; i < m; i++){
            int nextState = startIndex;

            //manage state
            for(int j = startIndex; j < state.length(); j++){
                if(states[j] == '1')
                    availableStates.add(j);
                else if(states[j] == '0' && !zeroFound && j - 1 >= 0 && states[j - 1] == '1'){// update state
                    nextState = j;
                    zeroFound = true;
                    states[j] = '1';

                    if(i > 0)
                        break;
                }
            }
            //fin
        }

        return result;
    }


    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(4,9,1,2,10);
        String state = "0010011110";
        int m = 4;

        List<Integer> result = getArrayWithStream(arr, state, m);
        System.out.println(result);

    }


}






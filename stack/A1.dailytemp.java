//bruteforce

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temperatures[j]>temperatures[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }

    return result;
    }
}

//optimised
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> monoStack = new Stack<>();

        for(int i=0;i<n;i++){

            if(monoStack.isEmpty()){
                monoStack.push(i);
                continue;
            } 
            // i want higher temperature for all
            while(!monoStack.isEmpty() && temperatures[i]>temperatures[monoStack.peek()]){
                result[monoStack.peek()] = i-monoStack.pop();
            }

            monoStack.push(i);
        }

    return result;

    }
}

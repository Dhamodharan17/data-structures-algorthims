ublic class StackOperation {
    
    static void nextSmaller(){
        int[] num = {10,9,8,14,20,1,11};
        int[] nse = new int[num.length];
        int n = num.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            // i want smaller but found greater
            while (!stack.empty() && num[stack.peek()]>=num[i]) {
                stack.pop();
            }
            if(stack.empty()) nse[i] = -1;
            else nse[i]=num[stack.peek()];

            stack.push(i);
        }

        for(int a:nse)System.out.print(a+" ");

    }

    static void nextGreater(){
        int[] num = {10,9,8,14,20,1,11};
        int[] nge = new int[num.length];

        Stack<Integer> stack = new Stack<>();

        int n = num.length;

        for(int i=n-1;i>=0;i--){
            // i want greater stack contains smaller
            while (!stack.empty() && num[stack.peek()]<=num[i]) {
                stack.pop();
            }
            if(stack.empty()) nge[i] =-1;
            else nge[i] = num[stack.peek()];

            stack.push(i);
        }

        for(int a:nge)System.out.print(a+" ");
    }

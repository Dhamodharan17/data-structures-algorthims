static void PrevGreater(){
        int[] num = {10,3,8,1,11,0,1};
        int[] pge = new int[num.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<num.length;i++){
            // i want greater but found smaller - pop
            while (!stack.empty() && num[stack.peek()]<=num[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                pge[i] =-1;
            }else{
                pge[i] = num[stack.peek()];
            }
            stack.push(i);
        }

        for(int a:pge)System.out.print(a+" ");
    }

    //pse
    void PrevSmaller(){
        int[] num = {2,3,4,1,2,3,5};
        int[] pse = new int[num.length];

        //find previous smaller element(inc stack)
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<num.length;i++){

            //i want to find smaller but stack have greater so pop it untill i get smaller
            while (!stack.isEmpty() && num[stack.peek()]>=num[i]) {
                //not my pse - delete it
                stack.pop();
            }

            if(stack.isEmpty()) pse[i] =-1;
            else pse[i] = num[stack.peek()];
            stack.push(i);
        }

        for(int a:pse)System.out.print(a+" ");
    }

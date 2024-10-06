brute force : 2 while loop but stack stores all the values in descending order so we need to traverse again to find the greater value.

basically we gather all smaller values in the stack and find the greater values for all at one shot.**

add smaller elements in stack, if u find a element which is greater than the current element that it next greater for the current element

class Solution {
    public int[] nextLargerNodes(ListNode head) {


        int[] input = convert(head);
        int[] res = new int[input.length];

        
        Stack<Integer> stack = new Stack<>();
    
        int current =0;
        while( current<input.length){
            // for all the values which is greater
            while(!stack.isEmpty() && 
            input[current]>input[stack.peek()]){
                res[stack.pop()] = input[current];
            }
        stack.push(current);
        current++;
        }

    while(!stack.isEmpty()){
        res[stack.pop()] = 0;
    }

    return res;

    }

    int[] convert(ListNode head){
        List<Integer> res = new ArrayList<>();
        while(head!=null){
            res.add(head.val);
            head = head.next;
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}

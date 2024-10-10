class GfG
{
    int maxLen(int arr[], int n)
    {
    
    HashMap<Integer,Integer> map = new HashMap<>();
    int sum = 0;
    int max = 0;
    map.put(0,-1);
    
    for(int index=0;index<arr.length;index++){
        
        sum = sum + arr[index];
        int prefix = sum;
        
        if(map.containsKey(prefix)){
            max = Math.max(max,index-map.get(prefix));
        }
        
        if(!map.containsKey(prefix)){
            map.put(sum,index);
        }
        
    }
    
    
    return max;
    
    }
}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket:tickets){
            graph.putIfAbsent(ticket.get(0),new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> itinery = new LinkedList<>();
        dfs("JFK",graph,itinery);
        return itinery;
    }

    private void dfs(String airport,Map<String,PriorityQueue<String>> graph,LinkedList<String> list){

     PriorityQueue<String> nextAirports = graph.get(airport);
     while(nextAirports!=null && !nextAirports.isEmpty()){
        dfs(nextAirports.poll(),graph,list);
     }
     //LIFO
     list.addFirst(airport);
    }
}

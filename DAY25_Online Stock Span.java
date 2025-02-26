// Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
class StockSpanner {
    
    Stack<int[]> st;
    
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        
        int span = 1;
        
        while(st.size() > 0 && price >= st.peek()[0]){
            span += st.pop()[1];
        }
        
        st.push(new int[]{price, span});
        
        return span;
    }
}

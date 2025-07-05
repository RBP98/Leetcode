class MedianFinder {
    PriorityQueue<Integer> high;
    PriorityQueue<Integer> low;


    public MedianFinder() {
        high = new PriorityQueue<>();
        low = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        
    }
    
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if(high.size() > low.size()){
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if(high.size() == low.size()){
             return (high.peek() + low.peek()) / 2.0 ;
        }
            
        
        return low.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
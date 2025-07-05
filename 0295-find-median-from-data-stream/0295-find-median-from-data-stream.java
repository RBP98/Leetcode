class MedianFinder {
    PriorityQueue<Integer> high = new PriorityQueue<>();
    PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());


    public MedianFinder() {
        
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
            double ans = (high.peek() + low.peek())/2.0;
            return ans;
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
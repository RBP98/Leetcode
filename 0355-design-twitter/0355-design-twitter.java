class Twitter {
    int time = 0;
    Map<Integer, Set<Integer>> followerMap = new HashMap<>();
    Map<Integer, List<Tweet>> tweetsMap = new HashMap<>();

    public Twitter() {

    }
    
    public void postTweet(int userId, int tweetId) {
        
        tweetsMap.putIfAbsent(userId, new ArrayList<>());
        tweetsMap.get(userId).add(new Tweet(tweetId, time++));

    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        Set<Integer> followers = followerMap.getOrDefault(userId, new HashSet<>());
        followers.add(userId);

        for(int user: followers){
            List<Tweet> userTweets = tweetsMap.getOrDefault(user, new ArrayList<>());
            for(int i = userTweets.size() - 1; i >= Math.max(0, userTweets.size() - 10); i--){
                pq.offer(userTweets.get(i));
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && res.size() < 10){
            res.add(pq.poll().id);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followerMap.putIfAbsent(followerId, new HashSet<>());
            followerMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        followerMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}

class Tweet{
    int id;
    int time;
    public Tweet(int id, int time){
        this.id = id; 
        this.time = time;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
class Twitter {
    
    HashMap<Integer, List<Tweet>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followerMap;
    int timestamp;
    
    class Tweet {
        int tweetId;
        int timestamp;
        
        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    public Twitter() {
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
        this.timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        
        follow(userId, userId);
        Tweet tweet = new Tweet(tweetId, timestamp++);
        
        if(!tweetMap.containsKey(userId)) 
            tweetMap.put(userId, new ArrayList<>());
        
        tweetMap.get(userId).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        follow(userId, userId);
        
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a,b) -> a.timestamp-b.timestamp); 
        HashSet<Integer> followings = followerMap.get(userId);
        
        if(followings != null) {
            for(Integer following: followings) {
                
                List<Tweet> tweets = tweetMap.get(following);
                
                if(tweets != null) {
                    
                    int size = tweets.size();
                    int startIndex = 0;
                    
                    if(size > 10)
                        startIndex = size - 10;
                    
                    for(int i=startIndex; i<size; i++) {
                        
                        feed.add(tweets.get(i));
                        
                        if(feed.size() > 10)
                            feed.poll();
                    }
                }
            }          
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!feed.isEmpty())
            result.add(0, feed.poll().tweetId);
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followerId))
            followerMap.put(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId))
            followerMap.get(followerId).remove(followeeId); 
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
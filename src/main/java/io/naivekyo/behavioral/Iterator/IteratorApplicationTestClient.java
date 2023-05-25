package io.naivekyo.behavioral.Iterator;

import io.naivekyo.behavioral.Iterator.collection.SocialNetwork;
import io.naivekyo.behavioral.Iterator.collection.WeChat;
import io.naivekyo.behavioral.Iterator.iterator.ProfileIterator;

public class IteratorApplicationTestClient {
    
    private SocialNetwork network;
    
    private SocialSpammer spammer;
    
    public void config() {
        this.network = new WeChat();
        this.spammer = new SocialSpammer();
    }
    
    public void sendSpamToFriends(Profile profile) {
        ProfileIterator iterator = this.network.createFriendsIterator(profile.getId());
        this.spammer.send(iterator, "hello friend.");
    }
    
    public void sendSpamToCoworkers(Profile profile) {
        ProfileIterator iterator = this.network.createCoworkersIterator(profile.getId());
        this.spammer.send(iterator, "hello coworker.");
    }
    
    public static void main(String[] args) {
        IteratorApplicationTestClient client = new IteratorApplicationTestClient();
        client.config();
        
        Profile profile = new Profile("1", "xxx@cook.com");
        
        client.sendSpamToFriends(profile);
    }
}

package io.naivekyo.behavioral.Iterator;

import io.naivekyo.behavioral.Iterator.iterator.ProfileIterator;

public class SocialSpammer {
    
    public void send(ProfileIterator iterator, String message) {
        while (iterator.hasMore()) {
            Profile profile = iterator.getNext();
            System.out.printf("SocialSpammer: -> %s -> %s%n", profile.getEmail(), message);
        }
    }
}

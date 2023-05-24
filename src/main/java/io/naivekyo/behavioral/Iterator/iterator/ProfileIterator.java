package io.naivekyo.behavioral.Iterator.iterator;

import io.naivekyo.behavioral.Iterator.Profile;

/**
 * 所有迭代器的通用接口
 */
public interface ProfileIterator {
    
    Profile getNext();
    
    boolean hasMore();
    
}

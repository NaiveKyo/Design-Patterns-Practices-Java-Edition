package io.naivekyo.behavioral.Iterator.collection;

import io.naivekyo.behavioral.Iterator.iterator.ProfileIterator;

/**
 * 集合接口必须声明一个用于获取迭代器的工厂方法, 如果程序中有多个不同类型的迭代器, 也可以声明多个方法
 */
public interface SocialNetwork {
    
    ProfileIterator createFriendsIterator(String profileId);
    
    ProfileIterator createCoworkersIterator(String profileId);
    
}

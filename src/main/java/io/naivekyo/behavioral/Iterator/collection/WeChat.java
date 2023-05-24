package io.naivekyo.behavioral.Iterator.collection;

import io.naivekyo.behavioral.Iterator.Profile;
import io.naivekyo.behavioral.Iterator.iterator.ProfileIterator;
import io.naivekyo.behavioral.Iterator.iterator.WebChatIterator;

/**
 * 具体的集合
 */
public class WeChat implements SocialNetwork {
    
    // 省略大量集合代码。。。
    
    // 模拟网络请求, 获取和特定 profile 关联的特定 type 的所有 profile
    public Profile[] socialGraphRequest(String profileId, String type) {
        // mock
        return new Profile[] { 
                new Profile("1", "111@hotmail.com"), 
                new Profile("2", "222@gmail.com"),
                new Profile("3", "333@qq.com")
        };
    }
    
    // 迭代器工厂方法
    @Override
    public ProfileIterator createFriendsIterator(String profileId) {
        return new WebChatIterator(this, profileId, "friends");
    }
    
    @Override
    public ProfileIterator createCoworkersIterator(String profileId) {
        return new WebChatIterator(this, profileId, "coworkers");
    }
    
}

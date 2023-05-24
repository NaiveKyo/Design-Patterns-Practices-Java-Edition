package io.naivekyo.behavioral.Iterator.iterator;

import io.naivekyo.behavioral.Iterator.Profile;
import io.naivekyo.behavioral.Iterator.collection.WeChat;

public class WebChatIterator implements ProfileIterator {

    /**
     * 迭代器需要一个对目标集合的引用变量
     */
    private WeChat weChat;
    
    private String profileId;
    
    private String type;

    /**
     * 迭代器对象会独立于其他迭代器来遍历集合元素, 因此它必须保存迭代器的状态
     */
    private int currentPosition;
    
    private Profile[] cache;

    public WebChatIterator(WeChat weChat, String profileId, String type) {
        this.weChat = weChat;
        this.profileId = profileId;
        this.type = type;
    }

    private void lazyInit() {
        if (this.cache == null)
            this.cache = this.weChat.socialGraphRequest(profileId, type);
    }
    
    @Override
    public Profile getNext() {
        if (hasMore()) {
            return cache[this.currentPosition++];
        }
        return null;
    }

    @Override
    public boolean hasMore() {
        this.lazyInit();
        return this.currentPosition < this.cache.length;
    }
    
}

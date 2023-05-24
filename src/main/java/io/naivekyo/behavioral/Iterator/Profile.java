package io.naivekyo.behavioral.Iterator;

/**
 * 集合存储元素
 */
public class Profile {
    
    private String id;
    
    private String email;

    public Profile(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

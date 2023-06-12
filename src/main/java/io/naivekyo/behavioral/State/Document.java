package io.naivekyo.behavioral.State;

/**
 * @author NaiveKyo
 * @version 1.0
 * @since 2023/6/12 22:51
 */
public class Document {
    private volatile String state;
    
    // ... 
    
    public void publish() {
        switch (state) {
            case "draft":
                this.state = "moderation";
                break;
            case "moderation":
                // if (currentUser.role == "admin")
                //     state = "published";
                break;
            case "published":
                // noop
                break;
        }
    }
    
    // ...
}

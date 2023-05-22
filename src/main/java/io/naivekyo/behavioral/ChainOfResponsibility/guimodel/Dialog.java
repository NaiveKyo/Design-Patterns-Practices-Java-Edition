package io.naivekyo.behavioral.ChainOfResponsibility.guimodel;

public class Dialog extends Container {
    
    private String title;
    
    private String wikiPageURL;

    public Dialog(String title) {
        this(title, null);
    }

    public Dialog(String title, String wikiPageURL) {
        this.title = title;
        this.wikiPageURL = wikiPageURL;
    }

    public void setWikiPageURL(String wikiPageURL) {
        this.wikiPageURL = wikiPageURL;
    }

    @Override
    public void showHelp() {
        if (this.wikiPageURL != null) {
            // do something
        } else 
            super.showHelp();
    }
}

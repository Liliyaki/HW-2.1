package org.skypro.skyshop.search;

public class Article implements Searchable {
    private final String articleName;
    private final String text;
    public Article (String articleName, String text) {
        this.articleName = articleName;
        this.text = text;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return articleName + text;
    }
    @Override
    public String getSearchTerm(){
        return toString();
    }
    @Override
    public String getContentType(){
        return "ARTICLE";
    }
    @Override
    public String getProductName(){
        return articleName;
    }
}

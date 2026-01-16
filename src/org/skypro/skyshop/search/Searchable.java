package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getProductName();
     default String getStringRepresentation() {
         return getProductName() + getContentType();
    }
}

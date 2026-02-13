package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();

        for (Searchable item : searchables) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.put(item.getProductName(), item);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть null или пустой строкой");
        }

        query = query.toLowerCase().trim();
        Searchable bestMatch = null;
        int maxOccurrences = -1;

        for (Searchable item : searchables) {
            String searchTerm = item.getSearchTerm().toLowerCase();
            int occurrences = countOccurrences(searchTerm, query);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = item;
            }
        }

        if (bestMatch == null || maxOccurrences == 0) {
            throw new BestResultNotFound(query);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        if (substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

    public int getSize() {
        return searchables.size();
    }
}
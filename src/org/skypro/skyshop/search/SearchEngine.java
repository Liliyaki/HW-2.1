package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;
    private int size;

    public SearchEngine(int capacity) {
        this.searchables = new ArrayList<>();
        this.size = 0;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable item : searchables) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
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

            // Подсчитываем количество вхождений query в searchTerm
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

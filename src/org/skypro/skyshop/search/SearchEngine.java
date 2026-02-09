package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.size = 0;
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size] = searchable;
            size++;
        } else {
            System.out.println("Элемент нельзя найти.");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (int i = 0; i < size; i++) {
            if (resultIndex >= 5) {
                break;
            }

            Searchable searchable = searchables[i];
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[resultIndex] = searchable;
                resultIndex++;
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

        for (int i = 0; i < size; i++) {
            Searchable item = searchables[i];
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
        return size;
    }
}

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
    public int getSize() {
        return size;
    }
}

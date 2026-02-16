package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthCompare = Integer.compare(o2.getProductName().length(), o1.getProductName().length());
        if (lengthCompare == 0) {
            return o1.getProductName().compareTo(o2.getProductName());
        }
        return lengthCompare;
    }
}

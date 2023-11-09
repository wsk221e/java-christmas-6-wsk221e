package christmas.view;

import christmas.utils.Templates;

class ParentView {
    // Fields
    protected final StringBuilder cache = new StringBuilder();


    // Subclass Implements
    protected void initializeCache() {
        cache.setLength(0);
    }

    protected void addToCache(String string) {
        cache.append(string);
    }

    protected void addToCache(Templates string) {
        cache.append(string);
    }

    protected void print() {
        System.out.print(cache);
    }

}

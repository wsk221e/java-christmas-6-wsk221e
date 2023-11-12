package christmas.view;

import christmas.utils.constants.Templates;

class ViewFunction {
    // Fields
    private final StringBuilder cache = new StringBuilder();


    // Features
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

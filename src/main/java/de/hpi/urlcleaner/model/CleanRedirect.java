package de.hpi.urlcleaner.model;

public class CleanRedirect implements CleanStrategy {
    public String clean(String url) {
        url = url + "222";
        return url;
    }
}

package de.hpi.urlcleaner.model;

public interface CleanStrategy {
    String clean(String rootUrl, String url);
}

package de.hpi.urlcleaner.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class URLCleaner {

    private List<CleanStrategy> cleanStrategies;

    public URLCleaner() {
        // TODO - do not needed to initializeStrategies if every implementation of CleanStrategy
        // will be annotated as @Component
        initializeStrategies();
    }

    private void initializeStrategies() {
        setCleanStrategies(new LinkedList<>());
        getCleanStrategies().add(new CleanRedirect());
        getCleanStrategies().add(new CleanAffiliateMarker());
    }

    public String clean(String rootUrl, String url) {
        url = decodeUrl(url);
        for (CleanStrategy strategy : getCleanStrategies()) {
            url = strategy.clean(rootUrl, url);
        }
        return url;
    }

    private String decodeUrl(String url) {
        while (url.matches("/%[0-9a-f]{2}/i")) {
            try {
                url = java.net.URLDecoder.decode(url, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

}

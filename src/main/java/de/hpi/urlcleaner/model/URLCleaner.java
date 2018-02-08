package de.hpi.urlcleaner.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
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
        for (CleanStrategy strategy : getCleanStrategies()) {
            url = strategy.clean(rootUrl, url);
        }
        return url;
    }

}

package de.hpi.urlcleaner.service;

import de.hpi.urlcleaner.model.URLCleaner;
import org.springframework.stereotype.Service;

@Service
public class URLCleanerService {

    public String cleanUrl(String url) {
        return URLCleaner.cleanURL(url);
    }

}

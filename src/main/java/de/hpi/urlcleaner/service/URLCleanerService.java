package de.hpi.urlcleaner.service;

import de.hpi.urlcleaner.model.URLCleaner;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class URLCleanerService {

    public List<String> cleanUrl(List<String> urls) throws UnsupportedEncodingException {
        return URLCleaner.cleanURL(urls);
    }

}

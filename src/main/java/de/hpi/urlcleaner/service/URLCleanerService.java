package de.hpi.urlcleaner.service;

import de.hpi.urlcleaner.model.URLCleaner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)

@Service
public class URLCleanerService {

    private URLCleaner urlCleaner;

    public URLCleanerService() {
        setUrlCleaner(new URLCleaner());

    }

    public String cleanUrl(String url) {
        return getUrlCleaner().clean(url);
    }

}

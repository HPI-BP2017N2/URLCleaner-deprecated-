package de.hpi.urlcleaner.service;

import de.hpi.restclient.clients.BPBridgeClient;
import de.hpi.urlcleaner.model.URLCleaner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)

@Service
public class URLCleanerService {

    private URLCleaner urlCleaner;
    private BPBridgeClient client;

    @Autowired
    public URLCleanerService(BPBridgeClient client) {
        setUrlCleaner(new URLCleaner());
        setClient(client);

    }

    public String cleanUrl(long shopID, String url) {
        String rootUrl = getClient().shopIDToUrl(shopID).getShopUrl();
        return getUrlCleaner().clean(rootUrl, url);
    }

}

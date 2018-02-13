package de.hpi.urlcleaner.model;

import java.io.UnsupportedEncodingException;

import static java.lang.Integer.valueOf;

public class CleanRedirect implements CleanStrategy {

    public String clean(String rootUrl, String url) {


        while (url.matches("/%[0-9a-f]{2}/i")) {
            try {
                url = java.net.URLDecoder.decode(url, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        String virginRootUrl = rootUrl;

        if (rootUrl.contains("http://")) {rootUrl = rootUrl.substring("http://".length() + 1, rootUrl.length());}
        if (rootUrl.contains("https://")) {rootUrl = rootUrl.substring("https://".length() + 1, rootUrl.length());}
        if (rootUrl.contains("www.")) {rootUrl = rootUrl.substring("www.".length() + 1, rootUrl.length());}

        return virginRootUrl + url.substring(valueOf(url.indexOf(rootUrl) + rootUrl.length()), url.length());
    }
}

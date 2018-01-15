package de.hpi.urlcleaner.model;

import org.apache.tomcat.util.buf.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class URLCleaner {
    // TODO - need to be unit-tested
    // TODO - use strategy pattern to implement different cleaner strategies, f.e. affiliateCleaner, ClicktrackerCleander, XYZCleander ...

    public static List<String> cleanURL(List<String> dirtyUrls) throws UnsupportedEncodingException {
        List<String> cleanedUrls = new LinkedList<>();
        for (String url : dirtyUrls) {
            cleanedUrls.add(cleanURL(url));
        }
        return cleanedUrls;
    }

    private static String cleanURL(String url) throws UnsupportedEncodingException {
        List<String> affiliateSeparator1 = Stream.of("/", "?", "&").collect(Collectors.toList());
        List<String> affiliateSeparator2 = Stream.of("partner=", "utm", "ref=", "clk_rvr_id", "aid=", "apid=", "from=", "spartner=", "rbtc=", "afid=", "affiliateid=", "channable=", "p=psmido", "sid=", "io=", "modsid=", "traffic_source", "smid=", "sclid=", "clk_rvr_id=", "wt_mc=", "tag=", "campaign=", "wmn=", "saleschannelid=", "uympq=", "refid", "cid=", "awc=", "wt.mc_id=", "from=", "partnerid=", "referrerid=", "campaign=", "a_id=", "emsrc=", "pv=").collect(Collectors.toList());

        // java.net.URLDecoder.decode(url, "UTF-8");
        String urlLowerCase = url.toLowerCase();

        for (String separator1 : affiliateSeparator1) {
            for (String separator2 : affiliateSeparator2) {
                if (urlLowerCase.contains(separator1 + separator2)) {
                    url = url.substring(0, urlLowerCase.indexOf(separator1 + separator2));
                    urlLowerCase = urlLowerCase.substring(0, urlLowerCase.indexOf(separator1 + separator2));
                }
            }
        }

        return url;


    }
}

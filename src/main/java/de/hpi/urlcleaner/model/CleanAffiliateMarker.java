package de.hpi.urlcleaner.model;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CleanAffiliateMarker implements CleanStrategy {

    public String clean(String rootUrl, String url) {

        List<String> affiliateSeparator1 = Stream.of("/", "?", "&").collect(Collectors.toList());
        List<String> affiliateSeparator2 = Stream.of("partner=", "utm", "ref=", "clk_rvr_id", "aid=", "apid=", "from=", "spartner=", "rbtc=", "afid=", "affiliateid=", "channable=", "p=psmido", "sid=", "io=", "modsid=", "traffic_source", "smid=", "sclid=", "clk_rvr_id=", "wt_mc=", "tag=", "campaign=", "wmn=", "saleschannelid=", "uympq=", "refid", "cid=", "awc=", "wt.mc_id=", "from=", "partnerid=", "referrerid=", "campaign=", "a_id=", "emsrc=", "pv=", "fee=", "fep=", "store=", "pidOnPds=", "number=", "actionid", "idealo=", "pt=", "kampan=", "m=", "camp=", "sgt=").collect(Collectors.toList());

        try {
            url = java.net.URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String urlLowerCase = url.toLowerCase();

        //TODO cut only till next "/", "?" OR "&"

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

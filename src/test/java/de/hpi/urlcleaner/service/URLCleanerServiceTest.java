package de.hpi.urlcleaner.service;

import de.hpi.urlcleaner.model.URLCleaner;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class URLCleanerServiceTest {

    List<String> cleanLinks = new ArrayList<>(Arrays.asList(
            "https://www.alternate.de/Wpro/Zulaufschlauch-für-Kaltwasser-2-5m/html/product/995333",
            "https://www.zooroyal.de/sanabelle-adult-katzen-trockenfutter-mit-frischem-gefluegel-10kg",
            "https://www.amazon.de/dp/B00KS3EX3E?m=A3JWKAKR8XB7XF",
            "http://www.tophaustiershop.de/sanabelle-adult-geflugel-10-kg",
            "https://www.futtermuehle.com/katzen/trockenfutter/sanabelle/3022/sanabelle-adult-gefluegel-10-kg",
            "https://www.hundeland.de/catalog/product/view/id/16996",
            "http://www.bitiba.de/shop/katze/trockenfutter/sanabelle/adult/433204",
            "https://www.petotal.de/katze/katzentrockenfutter/sanabelle/sanabelle-adult-gefluegel-katzentrockenfutter",
            "https://www.futterbauer.de/sanabelle-adult-gefluegel-sanabelle-snack-gratis:4314.html",
            "https://www.petspremium.de/catalog/product/view/id/1725",
            "https://www.zoologo.de/katze/katzenfutter/trockenfutter/sanabelle-adult-gefluegel-katzentrockenfutter",
            "https://www.tiierisch.de/produkt/bosch-sanabelle-adult-katzenfutter",
            "https://www.hornbach.de/shop/Katzenfutter-trocken-Sanabelle-Adult-Gefluegel-10-kg/8217055/artikel.html",
            "http://www.zooplus.de/shop/katzen/katzenfutter_trockenfutter/sanabelle/sanabelle_adult/429651",
            "https://www.rinderohr.de/sanabelle-adult-gefluegel-5846"
            ));


    List<String> dirlyLinks = new ArrayList<>(Arrays.asList(
            "https://www.alternate.de/Wpro/Zulaufschlauch-für-Kaltwasser-2-5m/html/product/995333?partner=DeIdealo&campaign=Waschmaschine/Wpro/995333",
            "https://www.zooroyal.de/sanabelle-adult-katzen-trockenfutter-mit-frischem-gefluegel-10kg?a_id=33700&id=28576&utm_campaign=33700&utm_medium=Price+Comparison&utm_source=28576&utm_term=20301&utpid=18ff026a-bcdd-3c06-8006-5cddbc6a02ff",
            "https://www.amazon.de/dp/B00KS3EX3E?m=A3JWKAKR8XB7XF&tag=idealode-am-pk-21&ascsubtag=6VIBPDYJG84Yfr_BG2BBiw",
            "http://www.tophaustiershop.de/sanabelle-adult-geflugel-10-kg?fee=27&fep=9203&utm_source=idealo&utm_medium=comparison&utm_campaign=idealo",
            "https://www.futtermuehle.com/katzen/trockenfutter/sanabelle/3022/sanabelle-adult-gefluegel-10-kg?sPartner=idealo",
            "https://www.hundeland.de/catalog/product/view/id/16996?store=hundeland&pidOnPds=16997&wkz=epehlpsmidea16997&psm=IDL-0816-10&utm_campaign=epehlpsmidea16997",
            "http://www.bitiba.de/shop/katze/trockenfutter/sanabelle/adult/433204?awc=9334_1516099141_ee2e276e0114582ab5516d0d1e36bbf3",
            "https://www.petotal.de/katze/katzentrockenfutter/sanabelle/sanabelle-adult-gefluegel-katzentrockenfutter?number=4015598009874&campaign=psm%2Fpsmidode%2FSanabelle+Adult%2B+Gefl%C3%BCgel+Katzentrockenfutter%2F27%2C49&fdcampaign=feed%2Fde%2F12127%2Fpsmidode%2F4015598009874&utm_source=idealo.de&utm_medium=referral&utm_campaign=feed",
            "https://www.futterbauer.de/sanabelle-adult-gefluegel-sanabelle-snack-gratis:4314.html?ref=6&rabatt=true",
            "https://www.petspremium.de/catalog/product/view/id/1725?from=idealo&utm_campaign=idealo",
            "https://www.zoologo.de/katze/katzenfutter/trockenfutter/sanabelle-adult-gefluegel-katzentrockenfutter?number=4015598009874&campaign=psm%2Fpsmidode%2FSanabelle+Adult%2B+Gefl%C3%BCgel+Katzentrockenfutter%2F28%2C99&fdcampaign=feed%2Fde%2F12109%2Fpsmidode%2F4015598009874&utm_source=idealo.de&utm_medium=referral&utm_campaign=feed",
            "https://www.tiierisch.de/produkt/bosch-sanabelle-adult-katzenfutter?ref=idealo&utm_source=idealo&utm_campaign=idealo%7Ccpc&utm_medium=cpc&utm_term=Katzenfutter&utm_content=HG6688118",
            "https://www.hornbach.de/shop/Katzenfutter-trocken-Sanabelle-Adult-Gefluegel-10-kg/8217055/artikel.html?WT.mc_id=de11p005&WT.tsrc=Preissuchmaschinen",
            "http://www.zooplus.de/shop/katzen/katzenfutter_trockenfutter/sanabelle/sanabelle_adult/429651?awc=11330_1516099566_1d425741846259d206bae926cbc87ead",
            "https://www.rinderohr.de/sanabelle-adult-gefluegel-5846?sPartner=idealo&number=01043771&utm_source=idealo&utm_medium=refferal&utm_campaign=idealo"
            ));


    @Test
    void cleanUrl() throws UnsupportedEncodingException {
        assertEquals(cleanLinks, URLCleaner.cleanURL(dirlyLinks));
    }
}
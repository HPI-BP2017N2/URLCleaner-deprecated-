package de.hpi.urlcleaner.service;

import de.hpi.urlcleaner.model.URLCleaner;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class URLCleanerServiceTest {



    @Test
    void cleanUrl() throws UnsupportedEncodingException {
        validateCleanUrl("https://viking.de/de/p/4471", "https://viking.de", "http://prf.hn/click/camref:1011lQUa/type:cpc/adref:4471/destination:http://www.viking.de/de/p/4471?sgt=QCB");
        validateCleanUrl("https://aze-tuning.de/sitzbezug-sitzbezuege-mitsubishi-carisma.html", "https://aze-tuning.de", "https://www.aze-tuning.de/sitzbezug-sitzbezuege-mitsubishi-carisma.html?utm_source=web&utm_medium=cpc&utm_campaign=idealo");



    }

    private void validateCleanUrl (String expected, String rootUrl, String dirtyUrl) {
        URLCleaner cleaner = new URLCleaner();
        assertEquals(expected, cleaner.clean(rootUrl, dirtyUrl));
    }



}


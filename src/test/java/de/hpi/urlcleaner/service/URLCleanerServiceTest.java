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
        validateCleanUrl("https://www.medimops.de/thierry-sarmant-le-musee-ideal-de-l-histoire-de-france-taschenbuch-M02847366334.html?variant=UsedGood", "https://www.medimops.de", "http://track.productsup.io/click.redir?siteid=454032&version=1.0&pup_e=577&pup_cid=68372&pup_id=M02847366334&redir=http%3A%2F%2Ft.neory-tm.net%2Ftm%2Fa%2Fchannel%2Ftracker%2F31d88a5b46%3Ftmrde%3Dhttps%253A%252F%252Fwww.medimops.de%252Fthierry-sarmant-le-musee-ideal-de-l-histoire-de-france-taschenbuch-M02847366334.html%253Fvariant%253DUsedGood%2526utm_source%253DPSM_PRS%2526utm_medium%253Dcpc");

        //TODO: der 3. Test passt nicht! Nach Re-direct Bereinigung wird UTM nicht gelöscht.







    }

    private void validateCleanUrl (String expected, String rootUrl, String dirtyUrl) {
        URLCleaner cleaner = new URLCleaner();
        assertEquals(expected, cleaner.clean(rootUrl, dirtyUrl));
    }



}


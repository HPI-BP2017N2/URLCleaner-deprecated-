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
        validateCleanUrl("https://www.rakuten.de/produkt/fasani-romantic-roses-ii-digitaldruck-poster-1284342696.html", "https://www.rakuten.de", "http://track.productsup.io/click.redir?siteid=367814&version=1.0&pup_e=1877&pup_id=1284342696&redir=http%3A%2F%2Fwww.rakuten.de%2Fprodukt%2Ffasani-romantic-roses-ii-digitaldruck-poster-1284342696.html%3Fsclid%3Dp_psmidoat%26portaldv%3D6");
        validateCleanUrl("https://www.audible.de/pd/B01MQ46JSR", "https://www.audible.de", "http://r.refinedads.com/r.rfa?aid=8778&oid=2984&c1=idealo&c2=B01MQ46JSR&c3=&url=http%3A%2F%2Fwww.audible.de%2Fpd%2FB01MQ46JSR%3Fsource_code%3DPNHFAPBN010417004M%26bp_ua%3Dyes");
        validateCleanUrl("https://www.ebook.de/de/product/24005297/nadir_bekka_problematique_des_phenomenes_des_ondes_de_choc.html", "https://www.ebook.de", "https://click.cptrack.de/?rd=true&k=QJqUP2sXROcFY_mEBiuZCLSMeebfomiagAU7lD-L2LlE2_8wWCitojMtxPkUk5FA&rdlink=https%3A%2F%2Fwww.ebook.de%2Fde%2Fproduct%2F24005297%2Fnadir_bekka_problematique_des_phenomenes_des_ondes_de_choc.html%3Fadcode%3D132Q10V40L40X%26utm_source%3Did%26utm_medium%3Dpdm%26utm_campaign%3Dpd");
        validateCleanUrl("https://www.motoin.de/Bekleidung/Hosen/Textilhosen/Held-Zeffiro-II-Textilhose::26802.html", "https://www.motoin.de", "https://www.motoin.de/Bekleidung/Hosen/Textilhosen/Held-Zeffiro-II-Textilhose::26802.html?refID=19&utm_source=olaedi&utm_medium=export");
        validateCleanUrl("https://www.yoox.com/AT/42646037/item", "https://www.yoox.com", "https://clk.tradedoubler.com/click?p=209710&a=2905429&g=0&URL=https://www.yoox.com/AT/42646037/item?tp=127884&utm_source=direct_de&utm_medium=affiliazione&utm_campaign=idealo_at&dept=women&cod10=42646037NH");
        validateCleanUrl("https://www.real.de/product/323205710/", "https://www.real.de", "https://www.real.de/product/323205710/?utm_source=idealo&utm_medium=cpc&utm_content=de&utm_campaign=pricecomparison&sid=23872728");
        validateCleanUrl("https://www.abc-arznei.de/product/indigo-lm-18-dilution.3953162.html", "https://www.abc-arznei.de", "https://click.cptrack.de/?rd=true&k=e5pjHtZJzvACLgBHpt8sH19abby63LSQpzD-Al1WSdNSLHrDGu4WlBkAwANIbslq&rdlink=https%3A%2F%2Fwww.abc-arznei.de%2Fproduct%2Findigo-lm-18-dilution.3953162.html%3Fp%3D65536%26utm_medium%3Dcpc%26utm_source%3Didealo%26utm_campaign%3Dpreisvergleich%26utm_content%3D13559602%26utm_term%3D13559602");
        validateCleanUrl("https://www.hugendubel.de/de/ebook/atukwei_okai-mandela_the_spear_and_other_poems-21278930-produkt-details.html", "https://www.hugendubel.de", "https://partners.webmasterplan.com/click.asp?ref=24383&site=13245&type=text&tnb=31&diurl=https%3A%2F%2Fclick.cptrack.de%2F%3Frd%3Dtrue%26k%3DL0Ou2cgQbhe_xB7lBNO9kmnSJc57M3xTrgjPL3-lEWJea-DQ0VH4E4d71ML0OQM0%26rdlink%3Dhttps%253A%252F%252Fwww.hugendubel.de%252Fde%252Febook%252Fatukwei_okai-mandela_the_spear_and_other_poems-21278930-produkt-details.html%253FadCode%253D032Q40W10C22B%2526utm_source%253Dafnp%2526utm_medium%253Dpdm%2526utm_campaign%253Dpd");
        validateCleanUrl("https://www.otto.de/extern/?page=/p/630662076/#variationId=630696527&article=97485632&assortment=121", "https://www.otto.de", "https://www.otto.de/extern/?page=%2Fp%2F630662076%2F%23variationId%3D630696527&article=97485632&assortment=121&campid=LP8011&IWL=562&AffiliateID=LP8011&ActionID=97485632");
        validateCleanUrl("https://www.kontaktlinsen-billig.at/proclear-toric-xr-6-linsen", "https://www.kontaktlinsen-billig.at", "https://www.kontaktlinsen-billig.at/proclear-toric-xr-6-linsen?pgUid=d2101809fd8e58432266ffed5ec280786731290c&utm_source=productsSearch&utm_medium=idealoat&combId=3968239");
        validateCleanUrl("https://www.handwerker-versand.de/2005088-Exzenterschleifer-GEX-150-Turbo-mit-L-BOXX.html", "https://www.handwerker-versand.de", "https://www.handwerker-versand.de/2005088-Exzenterschleifer-GEX-150-Turbo-mit-L-BOXX.html?refID=idealo&utm_source=Idealo-Produktsuche&utm_medium=Preisvergleich&utm_campaign=Idealo-Produktsuche");
        validateCleanUrl("https://www.crowdfox.com/blk-ultra-light-down-jacket-rot-420350403-gr-xl-PNzU3OWY2Y2Y1Ng==.html", "https://www.crowdfox.com", "https://www.crowdfox.com/blk-ultra-light-down-jacket-rot-420350403-gr-xl-PNzU3OWY2Y2Y1Ng==.html?pt=cbab6f1a&utm_source=idealo_network&utm_medium=pce&utm_campaign=idealo_network&directCheckoutButton=true&petype=1&mtype=0&pId=1_4_2473477407");
        validateCleanUrl("https://www.hcinema.de/lampen/shop.php?id=fru2907", "https://www.hcinema.de", "https://www.hcinema.de/lampen/shop.php?id=fru2907&m=15");
        validateCleanUrl("https://www.buecher.de/id/34504026/wea/1160015", "https://www.buecher.de", "http://partners.webmasterplan.com/click.asp?ref=202951&site=3780&type=text&tnb=11&diurl=https://www.buecher.de/id/34504026/wea/1160015");
        validateCleanUrl("https://www.rakuten.de/produkt/lederbezug-sitzbezug-sitzbezuege-ranger-aus-echtem-leder-beige-hyundai-tucson-1362004065.html", "https://www.rakuten.de", "http://track.productsup.io/click.redir?siteid=462935&version=1.0&pup_e=4622&pup_cid=55475&pup_id=1362004065&redir=http%3A%2F%2Fwww.rakuten.de%2Fprodukt%2Flederbezug-sitzbezug-sitzbezuege-ranger-aus-echtem-leder-beige-hyundai-tucson-1362004065.html%3Fsclid%3Dp_idealo_DE_1362004065_mid59911_catidauto_prc_15250%26portaldv%3D6%26cid%3Didealo");



    }

    private void validateCleanUrl (String expected, String rootUrl, String dirtyUrl) {
        URLCleaner cleaner = new URLCleaner();
        assertEquals(expected, cleaner.clean(rootUrl, dirtyUrl));
    }



}


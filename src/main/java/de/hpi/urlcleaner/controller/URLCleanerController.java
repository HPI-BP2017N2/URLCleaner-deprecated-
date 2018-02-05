package de.hpi.urlcleaner.controller;

import de.hpi.restclient.dto.CleanURLResponse;
import de.hpi.urlcleaner.service.URLCleanerService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
public class  URLCleanerController {

    @Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.PRIVATE) private URLCleanerService service;

    @Autowired
    public URLCleanerController(URLCleanerService service){
        setService(service);
    }

    @RequestMapping(value = "/cleanURL", method = RequestMethod.GET, produces = "application/json")
    public CleanURLResponse cleanURL(@RequestParam(value="shopID") long shopID, @RequestParam(value="url") String url) {
        CleanURLResponse response = new CleanURLResponse();
        response.setBlacklisted(false);
        response.setCleanUrl(getService().cleanUrl(shopID, url));
        return response;
    }

}

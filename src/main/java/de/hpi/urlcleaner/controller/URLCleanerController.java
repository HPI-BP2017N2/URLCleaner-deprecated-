package de.hpi.urlcleaner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.hpi.urlcleaner.dto.CleanURLParameter;
import de.hpi.urlcleaner.dto.CleanURLResponse;
import de.hpi.urlcleaner.model.URLCleaner;
import de.hpi.urlcleaner.service.URLCleanerService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class URLCleanerController {

    @Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.PRIVATE) private URLCleanerService service;

    @Autowired
    public URLCleanerController(URLCleanerService service){
        setService(service);
    }

    @RequestMapping(value = "/clean", method = RequestMethod.POST, produces = "application/json")
    public CleanURLResponse parse(@RequestBody CleanURLParameter parameter) throws UnsupportedEncodingException {
        CleanURLResponse response = new CleanURLResponse();
        response.setBlacklisted(false);
        response.setCleanURL(getService().cleanUrl(parameter.getUrl()));
        return response;
    }

}

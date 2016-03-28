package io.metamorphic.cst.controllers;

import io.metamorphic.cst.services.CouchbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by markmo on 17/07/2015.
 */
@Controller
public class EventsController {

    @Autowired
    private CouchbaseService service;

    @RequestMapping(value = "/api/customers/{customerId}/events", method = RequestMethod.GET)
    public @ResponseBody
    List<Map<String, Object>> events(@PathVariable("customerId") String customerId) {
        return service.events(customerId);
    }
}

package pl.lodz.p.carpooling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mateusz Surmanski on 11.10.15.
 */
@Controller
public class InitController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init() {
        return "index";
    }
}

package pl.lodz.p.carpooling.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mateusz Surmański on 25.10.2015.
 */
@RestController
@RequestMapping(value = "/security")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/publicKey", method = RequestMethod.GET)
    public String getPublicKey() {
        return securityService.getPublicKey().toString();
    }
}

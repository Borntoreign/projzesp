package pl.lodz.p.carpooling.security;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.security.*;

/**
 * Created by Mateusz Surmański on 25.10.2015.
 */
@Service
class SecurityService {

    public static final String ALGORITHM = "DSA";
    public static final String PROVIDER = "SUN";
    private KeyPair keyPair;

    //TODO Improve error handling
    SecurityService() throws NoSuchProviderException, NoSuchAlgorithmException {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM, PROVIDER);
            keyPair = keyGen.generateKeyPair();
    }

    PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }
}

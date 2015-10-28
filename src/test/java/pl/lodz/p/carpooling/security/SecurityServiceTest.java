package pl.lodz.p.carpooling.security;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Mateusz Surmański on 25.10.2015.
 */
public class SecurityServiceTest {

    private SecurityService sut;

    @Before
    public void setUp() throws Exception {
        sut = new SecurityService();

    }

    @Test
    public void shouldGetPublicKey() throws Exception {
        PublicKey publicKey = sut.getPublicKey();
        assertThat(publicKey).isNotNull();
    }


    @Test
    public void shouldGetPrivateKey() throws Exception {

    }
}
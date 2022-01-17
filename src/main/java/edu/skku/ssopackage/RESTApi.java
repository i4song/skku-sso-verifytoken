package edu.skku.ssopackage;

import SafeIdentity.SSO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTApi {
    @Value("${sApiKey}")
    String sApiKey;
    @Value("${ssoAgentIp}")
    String ssoAgentIp;
    @Value("${ssoAgentPort}")
    Integer ssoAgentPort;

    @PostMapping("/verifyToken")
    public int verifyToken(@RequestBody String ssoToken) {
        SSO sso = new SSO(sApiKey);
        sso.setHostName(ssoAgentIp);
        sso.setPortNumber(ssoAgentPort);

        return sso.verifyToken(ssoToken);
    }
}

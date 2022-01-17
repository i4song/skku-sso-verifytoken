package edu.skku.ssopackage;

import SafeIdentity.SSO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@RestController
public class RESTApi {
    @PostMapping("/verifyToken")
    public int verifyToken(@RequestBody String ssoToken) throws IOException {
        String propFile = "licence.txt";
        Properties props = new Properties();

        FileInputStream fis = new FileInputStream(propFile);

        props.load(new java.io.BufferedInputStream(fis));

        String sApiKey = props.getProperty("sApiKey");
        String ssoAgentIp = props.getProperty("ssoAgentIp");
        String ssoAgentPort = props.getProperty("ssoAgentPort");

        SSO sso = new SSO(sApiKey);

        sso.setHostName(ssoAgentIp);
        sso.setPortNumber(Integer.parseInt(ssoAgentPort));

        return sso.verifyToken(ssoToken);
    }
}

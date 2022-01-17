package edu.skku.ssopackage;

import SafeIdentity.SSO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RESTApi {
    @Value("${sApiKey}")
    String sApiKey;
    @Value("${ssoAgentIp}")
    String ssoAgentIp;
    @Value("${ssoAgentPort}")
    Integer ssoAgentPort;

    SSO sso = new SSO(sApiKey);

    @PostMapping("/verifyToken")
    public ResponseEntity<VerifyResponseDto> verifyToken(@RequestBody String ssoToken) {
        sso.setHostName(ssoAgentIp);
        sso.setPortNumber(ssoAgentPort);

        Integer nResult = sso.verifyToken(ssoToken);

        VerifyResponseDto verifyResponseDto = new VerifyResponseDto(nResult);

        return new ResponseEntity<>(verifyResponseDto, HttpStatus.ACCEPTED);
    }
}

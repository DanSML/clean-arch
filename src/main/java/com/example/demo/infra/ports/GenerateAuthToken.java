package com.example.demo.infra.ports;

import java.security.SecureRandom;
import java.util.Base64;

public class GenerateAuthToken {
  private static final SecureRandom secureRandom = new SecureRandom();
  private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); 
  byte[] randomBytes = new byte[56];

  public String exec() {
    secureRandom.nextBytes(randomBytes);
    return base64Encoder.encodeToString(randomBytes);
  }
}

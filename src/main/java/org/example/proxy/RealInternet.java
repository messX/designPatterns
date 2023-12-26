package org.example.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealInternet implements Internet {
    public void connect(String url){
      log.info(String.format("Connectin to real Internet %s", url));
    }
}

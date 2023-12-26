package org.example.proxy;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class PoxyInternet implements Internet {
    private Internet internet = new RealInternet();
    public static List<String> bannedUrls = Arrays.asList("abc.com", "porn.com");
    @Override
    public void connect(String url) {
      log.info(String.format("Connecting to proxy internet %s", url));
      if(bannedUrls.contains(url)){
          log.error("Invalid Url");
      }
      else{
          internet.connect(url);
      }
    }
}

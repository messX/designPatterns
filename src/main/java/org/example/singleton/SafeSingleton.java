package org.example.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SafeSingleton {
    public static SafeSingleton safeSingleton = null;

    public SafeSingleton() throws IllegalAccessException {
      log.info("init safe singleton");
      if(safeSingleton == null){
          safeSingleton = this;
      }
      else{
          throw new IllegalAccessException("Already initialised");
      }
    }

    public static synchronized SafeSingleton getInstance() throws IllegalAccessException {
        if(safeSingleton == null){
            synchronized (SafeSingleton.class){
                new SafeSingleton();
            }
        }
        return safeSingleton;
    }
}

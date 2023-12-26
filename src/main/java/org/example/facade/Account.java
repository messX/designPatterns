package org.example.facade;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Account {
    public static Map<Long, Long> accountData;
    static {
        accountData = new HashMap<>();
        accountData.put(1L, 1000L);
        accountData.put(2L, 12000L);
    }
}

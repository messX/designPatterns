package org.example.facade;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    public long id;
    private String name;

    public String toString(){
        return String.format("Customer %s, %s", this.id, this.name);
    }
}

package org.example.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Originator {
    private String state;

    public Memento save(){
        return new Memento(state);
    }

    public String restore(Memento M){
        state = M.getState();
        return state;
    }
}

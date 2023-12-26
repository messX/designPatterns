package org.example.abstractfactory;

public class OrcArmy implements Army{

    private final String DESCRIPTION = "Hey this is orc army";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}

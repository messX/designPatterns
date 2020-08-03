package org.example.abstractfactory;

public class OrcCastle implements Castle {

    private final String DESCRIPTION = "Hey this is orc castle";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}

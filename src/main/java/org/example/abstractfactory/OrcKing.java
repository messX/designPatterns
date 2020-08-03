package org.example.abstractfactory;

import lombok.extern.slf4j.Slf4j;

public class OrcKing implements King {
    private final String DESCRIPTION = "Hey this is orc castle";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}

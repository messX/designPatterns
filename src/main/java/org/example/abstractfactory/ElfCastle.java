package org.example.abstractfactory;

public class ElfCastle implements Castle {

    private final String DESCRIPTION = "Hey this is elf castle";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}

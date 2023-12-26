package org.example.abstractfactory;


public class ElfArmy implements Army {
    private final String DESCRIPTION = "Hey this is elf army";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}

package org.example.abstractfactory;

public class ElfKing implements King{
    private final String DESCRIPTION = "Hey this is elf king";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}

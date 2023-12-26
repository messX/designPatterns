package org.example.abstractfactory;

public interface KingdomFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}

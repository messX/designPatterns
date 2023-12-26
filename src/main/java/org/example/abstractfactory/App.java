package org.example.abstractfactory;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class App {
    private King king;
    private Castle castle;
    private Army army;

    public void createKingdom(KingdomFactory factory){
        log.info("creating king");
        setKing(factory.createKing());
        setCastle(factory.createCastle());
        setArmy(factory.createArmy());
    }
    /**
     * The factory of kingdom factories.
     */
    public static class FactoryMaker {

        /**
         * Enumeration for the different types of Kingdoms.
         */
        public enum KingdomType {
            ELF, ORC
        }

        /**
         * The factory method to create KingdomFactory concrete objects.
         */
        public static KingdomFactory makeFactory(KingdomType type) {
            switch (type) {
                case ELF:
                    return new ElfKingdomFactory();
                case ORC:
                    return new OrcKingdomFactory();
                default:
                    throw new IllegalArgumentException("KingdomType not supported.");
            }
        }
    }

    public static void main(String[] args){
        App app = new App();
        app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF));
        log.info(app.getKing().getDescription());
    }
}

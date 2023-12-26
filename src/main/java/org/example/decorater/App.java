package org.example.decorater;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args){
        Pizza pizza = new BasePizza("base topping", 300.0);
        Pizza cheesePizza = new CheesePizza(pizza);
        Pizza tomatoCheesePizza = new TomatoPizza(cheesePizza);
        log.info(String.format("Price : %s, Topping: %s", pizza.getPrice(), pizza.getDescription()));
        log.info(String.format("Price : %s, Topping: %s", cheesePizza.getPrice(), cheesePizza.getDescription()));
        log.info(String.format("Price : %s, Topping: %s", tomatoCheesePizza.getPrice(), tomatoCheesePizza.getDescription()));
    }
}

package org.example.decorater;

public abstract class PizzaDecorator implements Pizza {
    Pizza basePizza;

    public PizzaDecorator(Pizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public String getDescription() {
        return basePizza.getDescription();
    }

    @Override
    public double getPrice() {
        return basePizza.getPrice();
    }
}

package org.example.decorater;

public class CheesePizza extends PizzaDecorator {
    public CheesePizza(Pizza pizza){
        super(pizza);
    }

    public String getDescription(){
        return this.basePizza.getDescription() + ", cheese pizza";
    }

    public double getPrice(){
        return this.basePizza.getPrice() + 1500.0;
    }

}

package org.example.decorater;

public class TomatoPizza extends PizzaDecorator {
    public TomatoPizza(Pizza pizza){
        super(pizza);
    }

    public String getDescription(){
        return this.basePizza.getDescription() + ", tomato pizza";
    }

    public double getPrice(){
        return this.basePizza.getPrice() + 500.0;
    }

}

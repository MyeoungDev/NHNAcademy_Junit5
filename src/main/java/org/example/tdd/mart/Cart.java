package org.example.tdd.mart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Goods> bag = new ArrayList<>(10);
    public void addItem(Goods something) {
        bag.add(something);
    }

    public List<Goods> getAllItems() {
        return bag;
    }
}

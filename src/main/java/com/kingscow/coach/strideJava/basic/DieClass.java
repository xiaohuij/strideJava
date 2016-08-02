package com.kingscow.coach.strideJava.basic;

import java.util.Random;

final class Die {

    private int _sides;
    private int _value;
    private Random _generator;

    // this is the contructor, called when you "new" the class.
    public Die(int sides) {
        this._sides  = sides;
        this._generator = new Random();
        this.roll();
    }

    // overload, to pass in an existing seed
    public Die(int sides, int seed) {
        this._sides  = sides;
        this._generator = new Random(seed);
        this.roll();
    }

    //getter and setter
    public int getSides() {
        return _sides;
    }

    public int setSides(int sides) {
        this._sides = sides;
        return _sides;
    }

    public Die roll() {
        _value = _generator.nextInt(_sides)+1;
        return this;
    }

    public int getValue() {
        return _value;
    }

}

public class DieClass {
    public static void main(String[] args) {
        Die d6 = new Die(6);
        Die d12 = new Die(12);
        Die skullcrusher = new Die(20);
        System.out.printf("Rolling %d sided die : %d\n",d6.getSides(), d6.roll().getValue());
        System.out.printf("Rolling %d sided die : %d\n",d12.getSides(), d12.roll().getValue());
        System.out.printf("Rolling %d sided die : %d\n"
                ,skullcrusher.getSides(), skullcrusher.roll().getValue());
    }
}

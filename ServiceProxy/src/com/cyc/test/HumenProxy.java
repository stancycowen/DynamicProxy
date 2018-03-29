package com.cyc.test;

/**
 * HumrnProxy
 */
public class HumenProxy implements Humen {
    private Humen humen;

    public HumenProxy(){
        humen = new HumenImpl();
    }

    @Override
    public void eat(String food) {
        eatBefore();
        humen.eat(food);
        eatAfter();
    }

    /**
     * eat before
     */
    private void eatBefore(){
        System.out.println("cook");
    }

    /**
     * eat after
     */
    private void eatAfter(){
        System.out.println("swap");
    }
}

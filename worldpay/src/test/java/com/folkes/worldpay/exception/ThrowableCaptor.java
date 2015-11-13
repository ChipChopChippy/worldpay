package com.folkes.worldpay.exception;

/**
 * Allows a much more elegant way of testing Exceptions than the alternatives
 * eg: try { doSomething(); fail("should not get here"); } catch(SomeException
 * se) { assertEquals("a message", se.getMessage()); } Credit to Frank Appel
 * {@link http://www.codeaffine.com/2014/07/28/clean-junit-throwable-tests-with-java-8-lambdas/}
 * 
 * @author Duncan
 *
 */
public class ThrowableCaptor {

    @FunctionalInterface
    public interface Actor {
        void act() throws Throwable;
    }

    public static Throwable thrownBy(Actor actor) {
        try {
            actor.act();
        } catch (Throwable throwable) {
            return throwable;
        }
        return null;
    }
}

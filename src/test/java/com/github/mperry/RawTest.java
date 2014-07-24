package com.github.mperry;

import org.junit.Test;

/**
 * Created by mperry on 1/07/2014.
 */
public class RawTest {

    @Test
    void test1() {
        new RawGenericMethod(){
            @Override
            public <T> void method(T t) {

            }
        };
        new RawGenericMethod() {
            @Override
            public <T> void method(T t) {

            }
        };
    }

}

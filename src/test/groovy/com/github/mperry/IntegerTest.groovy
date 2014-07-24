package com.github.mperry

import org.junit.Test

/**
 * Created by mperry on 1/07/2014.
 */
class IntegerTest {

    @Test
    void test1() {

        def f = new IntegerFunctor()
        def j = f.map(2) { Integer i -> 2 * i}
        println j
    }

}

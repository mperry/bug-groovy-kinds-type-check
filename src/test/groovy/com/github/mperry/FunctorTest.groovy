package com.github.mperry

import groovy.transform.TypeChecked
import org.junit.Test

/**
 * Created by mperry on 1/07/2014.
 */

@TypeChecked
class FunctorTest {


    @Test
    void test1() {
        def m1 = ["a": 1, "b": 2, "c": 3]
        def m2 = m1.collectEntries { String k, Integer v ->
//            [(k): 2 * v]
            [k, 2 * v]
        }
        println m1
        println m2
    }

}

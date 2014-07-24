package com.github.mperry

import groovy.transform.TypeChecked
import org.junit.Test

/**
 * Created by mperry on 1/07/2014.
 */
@TypeChecked
class ListTest {


    @Test
    void test1() {
        def f = new ListFunctor()
        def list = f.map([1, 2, 3, 4]) { Integer i ->
            i >= 2
        }
        println list
    }

}

package com.github.mperry

import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

@TypeChecked
interface Class1 {
    def <T, A> void method(T<A> t)
}

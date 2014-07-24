package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */
@TypeChecked
class IntegerFunctor implements Functor<Integer> {

    @Override
    def <A, B> Integer map(Integer i, F<A, B> f) {
        i
    }

}

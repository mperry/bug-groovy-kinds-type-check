package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */
@TypeChecked
class IntegerFunctor implements FunctorG<Integer> {

    @Override
    def <A, B> Integer fmap(F<A, B> f, Integer i) {
        i
    }

}

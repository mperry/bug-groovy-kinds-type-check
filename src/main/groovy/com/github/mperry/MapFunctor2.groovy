package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

@TypeChecked
class MapFunctor2 implements Functor<Map> {

    @Override
    def <A, B, C> Map<C, B> map(Map<C, A> fa, F<A, B> f) {
        fa.collectEntries { C k, A a ->
            [k, f.f(a)]
        }
    }

}

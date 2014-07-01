package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

@TypeChecked
class MapFunctor2 implements FunctorG<Map> {

    @Override
    def <A, B, C> Map<C, B> fmap(F<A, B> f, Map<C, A> fa) {
        fa.collectEntries { C k, A a ->
            [k, f.f(a)]
        }
    }

}

package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

@TypeChecked
class MapFunctor implements FunctorG<Map> {

    @Override
    def <A, B> Map<String, B> fmap(F<A, B> f, Map<String, A> fa) {
        fa.collectEntries { String k, A a ->
            [k, f.f(a)]
        }
    }

}

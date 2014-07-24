package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

@TypeChecked
class MapFunctor1 implements Functor<Map> {

    @Override
    def <A, B> Map<String, B> map(Map<String, A> map, F<A, B> f) {
        map.collectEntries { String k, A a ->
            [k, f.f(a)]
        }
    }

}

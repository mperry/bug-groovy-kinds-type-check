package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

@TypeChecked
class MapFunctor3 implements FunctorG<Map> {

    @Override
    def <A, B, C> Map<String, Integer> fmap(F<A, B> f, Map<Boolean, Long> fa) {
        fa.collectEntries { Boolean k, Long v ->
            ["abc", 0]
        }
    }

}

package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

@TypeChecked
class MapFunctor0 implements Functor<Map> {

    @Override
    def <A, B> Map<String, Integer> map(Map<Boolean, Long> fa, F<A, B> f) {
        fa.collectEntries { Boolean k, Long v ->
            ["abc", 0]
        }
    }

}

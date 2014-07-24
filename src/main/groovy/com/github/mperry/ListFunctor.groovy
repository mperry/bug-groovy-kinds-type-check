package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */
@TypeChecked
class ListFunctor implements Functor<List> {

    @Override
    def <A, B> List<B> map(List<A> list, F<A, B> f) {
        list.collect { A a ->
            f.f(a)
        }
    }

}

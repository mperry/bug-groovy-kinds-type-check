package com.github.mperry

import fj.F
import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */
@TypeChecked
class ListFunctor implements FunctorG<List> {


    @Override
    def <A, B> List<B> fmap(F<A, B> f, List<A> fa) {
        fa.collect { A a ->
            f.f(a)
        }
    }

}

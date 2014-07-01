package com.github.mperry

import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

import fj.F

@TypeChecked
interface FunctorG<T> {

    abstract <A, B> T<B> fmap(F<A, B> f, T<A> fa)

}

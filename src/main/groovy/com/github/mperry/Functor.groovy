package com.github.mperry

import groovy.transform.TypeChecked

/**
 * Created by mperry on 1/07/2014.
 */

import fj.F

@TypeChecked
interface Functor<T> {

    abstract <A, B> T<B> map(T<A> t, F<A, B> f)

}

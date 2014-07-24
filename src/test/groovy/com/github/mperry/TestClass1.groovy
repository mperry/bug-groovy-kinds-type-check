package com.github.mperry

import groovy.transform.TypeChecked
import org.junit.Test

import java.lang.invoke.MethodHandleImpl

/**
 * Created by mperry on 1/07/2014.
 */
@TypeChecked
class TestClass1 {

    @Test
    void test1() {
        def o1 = new Class1() {
            @Override
            def <T> void method(T o) {

            }
        }
        def o2 = new Class1() {
            @Override
            def <T> void method(Object t) {

            }
        }
        def o3 = new Class1() {
            @Override
            def <A> void method(A t) {

            }
        }
        def o4 = new Class1() {
            @Override
            void method(Object t) {

            }
        }

    }

    @Test
    void test2() {
        def o1 = new Class2() {
            @Override
            void method(Object o) {
            }
        }
        def o2 = new Class2() {
            @Override
            def <T> void method(T t) {

            }
        }


    }


}

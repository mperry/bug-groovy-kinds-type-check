bug-groovy-kinds-type-check
===========================

Groovy does not have kinds (aka higher order types), see https://en.wikipedia.org/wiki/Kind_(type_theory).

This can be partially simulated by exploiting (abusing?) the Groovy language.  Whilst Java does not allow higher order generics this can be done with Groovy 2.3.3.  

One of the simples "types" that have this kind is Functor.  Intuitively, a functor is a type that hold values that can be transformed (mapped over).  Examples include lists, options, sets, and trees.  The Functor type has the kind * -> *, that is, a function whose first argument is a type and result is another type.

So invalid code in Java like this:

```java
    interface Functor<T> {
        abstract <A, B> T<B> map(T<A> t, F<A, B> f);
    }
```

is ok in Groovy (and type checks when it should not).

```groovy
@TypeChecked
interface Functor<T> {
    abstract <A, B> T<B> map(T<A> t, F<A, B> f)
}
```

We note that writing Function<T<A>> to express the idea that the generic type T requires a single generic type parameter is invalid Java and Groovy.  The definition Groovy accepts of Functor<T> has no restriction on the number of generic type parameters T requires.  More on this later.
 

Lets try to implement the list functor in Groovy:

```groovy
@TypeChecked
class ListFunctor implements Functor<List> {
    @Override
    def <A, B> List<B> map(List<A> list, F<A, B> f) {
        list.collect { A a ->
            f.f(a)
        }
    }
}
```

An example of the functor being used is:
```groovy
  @Test
    void test1() {
        def f = new ListFunctor()
        def list = f.map([1, 2, 3, 4]) { Integer i -> i >= 2 }
        println list
    }
```

Note that the List type requires a single generic type parameter which matched our definition of the Functor class, in particular the map definition. Let's inspect what happens when the type used does not take a single generic type parameter.  Let's use Integer and Map to do so.

The IntegerFunctor can be defined as:

```groovy
@TypeChecked
class IntegerFunctor implements Functor<Integer> {
    @Override
    def <A, B> Integer map(Integer i, F<A, B> f) {
        i
    }
}
```

Note that this does not really fit in the definition of Functor.  The first parameter to map in functor takes T<A> whereas for IntegerFunctor it takes just an Integer.  With no generic type on the generic type to Functor the function from A to B becomes non-sensical.  While this compiles with type checking, I don't believe it actually should.

Let's now define a functor for Map, even though Map requires 2 generic type parameters instead of 1 and see what happens.

```groovy
@TypeChecked
class MapFunctor2 implements Functor<Map> {
    @Override
    def <A, B, C> Map<C, B> map(Map<C, A> fa, F<A, B> f) {
        fa.collectEntries { C k, A a ->
            [k, f.f(a)]
        }
    }
}
```

Here, we map over the values, keeping the key constant.  Despite the mismatch between this map definition and Functor's map definition this code compiles and runs correctly.   

```groovy
T<B> map(T<A> t, F<A, B> f)
```

Again it looks like the requirement of applying a single generic type to T is not enforced.












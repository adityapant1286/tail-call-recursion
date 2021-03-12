package org.recursion;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {

    public TailCall<T> apply();

    public default boolean complete() {
        return false;
    }

    public default T result() {
        throw new Error("Method not implemented");
    }

    public default T execute() {
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::complete)
                .findFirst()
                .get()
                .result();
    }
}

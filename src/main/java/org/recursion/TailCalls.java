package org.recursion;

public class TailCalls {

    public static <T> TailCall<T> done(T value) {
        return new TailCall<T>() {
            @Override
            public boolean complete() {
                return true;
            }

            @Override
            public T result() {
                return value;
            }

            @Override
            public TailCall<T> apply() {
                throw new Error("Method not implemented");
            }
        };
    }
}

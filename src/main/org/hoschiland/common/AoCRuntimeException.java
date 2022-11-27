package org.hoschiland.common;

public class AoCRuntimeException extends RuntimeException {

    public AoCRuntimeException() {
        super();
    }

    public AoCRuntimeException(String s) {
        super(s);
    }

    public AoCRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AoCRuntimeException(Throwable throwable) {
        super(throwable);
    }

}

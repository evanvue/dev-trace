package com.util;

import java.util.function.Function;

public class ShutdownHookServerThread<T,V> extends Thread{
    private volatile boolean hasShutdown = false;
    private T obj;
    private Function<T,V> callback;

    public ShutdownHookServerThread(T obj, Function<T, V> callback) {
        this.obj = obj;
        this.callback = callback;
    }

    @Override
    public void run() {
        synchronized (this) {
            if (!hasShutdown) {
                this.hasShutdown = true;
                this.callback.apply(obj);
            }
        }
    }
}

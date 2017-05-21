package com.github.mszarlinski.webflux.util;

import java.time.Duration;

public class Sleeper {

    public static void sleep(final Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

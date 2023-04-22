package com.plenka.railway.model;

import java.util.Random;

public enum Status {

    IDEA,
    IN_PROGRESS,
    COMPLETED,
    POSTPONED;
    private static final Random PRNG = new Random();

    public static Status randomStatus()  {
        Status[] statuses = values();
        return statuses[PRNG.nextInt(statuses.length)];
    }
}

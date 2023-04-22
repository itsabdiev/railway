package com.plenka.railway.model;

import java.util.Random;

public enum Type {
    FAITH,
    SPORT,
    JOB,
    SOCIAL_NETWORK,
    REST,
    HOBBY,
    IMPROVEMENT;

    private static final Random PRNG = new Random();

    public static Type randomType()  {
        Type[] types = values();
        return types[PRNG.nextInt(types.length)];
    }
}

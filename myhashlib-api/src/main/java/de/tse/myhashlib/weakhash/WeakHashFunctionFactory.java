package de.tse.myhashlib.weakhash;

import de.tse.myhashlib.HashFunction;
import de.tse.myhashlib.HashFunctionFactory;

import java.util.Map;

public class WeakHashFunctionFactory implements HashFunctionFactory {


    @Override public String getIdentifier() {
        return "WeakHash";
    }

    @Override public HashFunction create(final Map<String, Object> properties) {
        return new WeakHashFunction();
    }
}

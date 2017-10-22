package de.tse.myhashlib;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

public class HashFunctions {

    private static final Map<String, HashFunctionFactory> hashFunctionFactories = loadHashFunctionFactories();

    private static Map<String, HashFunctionFactory> loadHashFunctionFactories() {
        final Map<String, HashFunctionFactory> factories = new HashMap<>();

        final ServiceLoader<HashFunctionFactory> serviceLoader = ServiceLoader.load(HashFunctionFactory.class);
        for (HashFunctionFactory factory : serviceLoader) {
            factories.put(factory.getIdentifier(), factory);
        }

        return factories;
    }

    public static HashFunction getInstance(final String functionName, final Map<String, Object> properties) {
        final HashFunctionFactory factory = getHashFunctionFactory(functionName);
        return factory.create(properties);
    }

    public static HashFunction getInstance(final String functionName) {
        final HashFunctionFactory factory = getHashFunctionFactory(functionName);
        return factory.create(Collections.emptyMap());
    }

    public static HashFunctionFactory getHashFunctionFactory(final String functionName) {
        final HashFunctionFactory factory = hashFunctionFactories.get(functionName);
        if (factory == null) {
            throw new RuntimeException(String.format("HashFunction %s not available", functionName));
        }
        return factory;
    }

    public static Set<String> getAvailableHashFunctions() {
        return new HashSet<>(hashFunctionFactories.keySet());
    }
}

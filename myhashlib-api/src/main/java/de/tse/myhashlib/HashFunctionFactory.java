package de.tse.myhashlib;

import java.util.Map;

public interface HashFunctionFactory {

    String getIdentifier();
    HashFunction create(Map<String, Object> properties);
}

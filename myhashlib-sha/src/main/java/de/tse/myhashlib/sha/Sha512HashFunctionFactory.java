package de.tse.myhashlib.sha;

import de.tse.myhashlib.HashFunction;
import de.tse.myhashlib.HashFunctionFactory;

import java.util.Map;

public class Sha512HashFunctionFactory implements HashFunctionFactory {

    @Override public String getIdentifier() {
        return "SHA-512";
    }

    @Override public HashFunction create(final Map<String, Object> properties) {
        return new Sha512HashFunction();
    }
}

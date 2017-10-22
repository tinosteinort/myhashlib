package de.tse.myhashlib.weakhash;

import de.tse.myhashlib.HashFunction;

import java.util.HashSet;
import java.util.Set;

public class WeakHashFunction implements HashFunction {

    @Override public String execute(final String data) {

        final Set<Character> characters = new HashSet<>();
        if (data != null) {
            for (int i = 0; i < data.length(); i++) {
                characters.add(data.charAt(i));
            }
        }
        return "#" + asString(characters);
    }

    private String asString(final Set<Character> characters) {
        if (characters.isEmpty()) {
            return "_";
        }

        final StringBuilder sb = new StringBuilder();
        for (Character c : characters) {
            sb.append(c);
        }
        return sb.toString();
    }
}

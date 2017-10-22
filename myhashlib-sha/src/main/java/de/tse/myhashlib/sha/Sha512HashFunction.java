package de.tse.myhashlib.sha;

import de.tse.myhashlib.HashFunction;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Sha512HashFunction implements HashFunction {

    @Override public String execute(final String data) {

        final MessageDigest md = getMessageDigest();
        md.update(data.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(md.digest());
    }

    private MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance("SHA-512");
        }
        catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
}

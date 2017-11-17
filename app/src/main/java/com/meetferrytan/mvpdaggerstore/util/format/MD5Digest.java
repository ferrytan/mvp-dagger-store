package com.meetferrytan.mvpdaggerstore.util.format;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import timber.log.Timber;

/**
 * Created by ferrytan on 11/16/17.
 */


public class MD5Digest {

    public static String getHash(String original) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Timber.e(e);
            return null;
        }
    }

}
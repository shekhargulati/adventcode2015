package com.shekhargulati.adventofcode_2015;

import java.security.MessageDigest;

public class MD5Digest {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (md5("iwrupvqb" + i).startsWith("000000")) {
                System.out.println("i is >> " + i);
                break;
            }
        }
    }

    public static String md5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            String hex = Integer.toHexString(0xFF & digest[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

}
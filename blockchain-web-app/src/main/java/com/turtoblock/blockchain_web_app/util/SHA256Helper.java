package com.turtoblock.blockchain_web_app.util;

import java.security.MessageDigest;

public class SHA256Helper {

    public static String generateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            StringBuilder hexadecimalString = new StringBuilder();

            for (byte b : hash) {
                String hexadecimal = Integer.toHexString(0xff & b);
                if (hexadecimal.length() == 1) hexadecimalString.append('0');
                hexadecimalString.append(hexadecimal);
            }

            return hexadecimalString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error generando hash SHA-256", e);
        }
    }
}

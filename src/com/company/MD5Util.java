package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    // Generování MD5 hashe z hesla
    public static String generateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Generování variací a porovnání hashe
    public static void generateVariations(String prefix, int length, String hashToCrack) {
        if (length == 0) {
            if (generateMD5(prefix).equalsIgnoreCase(hashToCrack)) {
                System.out.println("Password found: " + prefix);
                System.exit(0); // Konec programu po nalezení hesla
            }
            return;
        }

        for (char letter : ALPHABET) {
            generateVariations(prefix + letter, length - 1, hashToCrack);
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java MD5Util <password> <maxLength>");
            return;
        }

        // Prvním argumentem je heslo, které chceme hashnout
        String password = args[0];
        String hashToCrack = generateMD5(password);

        // Druhým argumentem je maximální délka hesla pro crackování
        int maxLength;
        try {
            maxLength = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid length argument. Please provide a valid integer.");
            return;
        }

        System.out.println("Generated MD5 hash for password \"" + password + "\": " + hashToCrack);

        System.out.println("Starting hash cracking process...");
        for (int length = 1; length <= maxLength; length++) {
            generateVariations("", length, hashToCrack);
        }

        System.out.println("Password not found.");
    }
}

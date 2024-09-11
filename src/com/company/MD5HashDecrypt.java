package com.company;

public class MD5HashDecrypt extends Thread{

    String hashToCrack;
    int charLength;

    static char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public MD5HashDecrypt(String hashToCrack, int charLength){
        this.hashToCrack = hashToCrack;
        this.charLength = charLength;
    }

    @Override
    public void run() {
        generateVariations("", charLength);
    }

    private void generateVariations(String prefix, int length) {
        if (length == 0) {
            if (MD5Util.generateMD5(prefix).equalsIgnoreCase(hashToCrack)) {
                System.out.println("Password found: " + prefix);
            }
            return;
        }

        for (char letter : alphabet) {
            generateVariations(prefix + letter, length - 1);
        }
    }
}

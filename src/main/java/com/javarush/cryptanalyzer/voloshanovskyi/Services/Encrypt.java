package com.javarush.cryptanalyzer.voloshanovskyi.Services;

import com.javarush.cryptanalyzer.voloshanovskyi.Massages.Messages;

import java.io.*;

import static com.javarush.cryptanalyzer.voloshanovskyi.Constants.Constants.ALPHABET;

public class Encrypt {
    public static void encryptFile(String inputFilePath, String outputFilePath, int key) {
        System.out.println(Messages.KEY + key);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath)); BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = encrypt(line, key);
                writer.write(encryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);
            if (index != -1) {
                int encryptedIndex = (index + key) % ALPHABET.length(); // здесь происходит шифрование сдвигом индексов
                if (encryptedIndex < 0) {
                    encryptedIndex += ALPHABET.length();
                }
                char encryptedChar = ALPHABET.charAt(encryptedIndex);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }
}

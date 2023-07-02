package com.javarush.cryptanalyzer.voloshanovskyi.Services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.cryptanalyzer.voloshanovskyi.Constants.Constants.ALPHABET;
import static com.javarush.cryptanalyzer.voloshanovskyi.Massages.Messages.KEY_FILE;
import static com.javarush.cryptanalyzer.voloshanovskyi.Services.Encrypt.encrypt;
import static java.lang.Integer.parseInt;

public class Decrypt {
    public static void decryptFile(String inputFilePath, String outputFilePath) {
        String keyString; // Чтение ключа, который был записан при шифровании, из файла
        try {
            keyString = Files.readString(Path.of(KEY_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int key = parseInt(keyString); // Получили числовое значение ключа
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = decrypt(line, key);
                writer.write(decryptedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, (ALPHABET.length() - key) % ALPHABET.length()); // Здесь происходит дешифрование сдвигом индексов обратно
    }
}

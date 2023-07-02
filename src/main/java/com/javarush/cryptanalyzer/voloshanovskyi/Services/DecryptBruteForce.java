package com.javarush.cryptanalyzer.voloshanovskyi.Services;

import java.io.*;

import static com.javarush.cryptanalyzer.voloshanovskyi.Constants.Constants.ALPHABET;
import static com.javarush.cryptanalyzer.voloshanovskyi.Massages.Messages.KEY;
import static com.javarush.cryptanalyzer.voloshanovskyi.Services.Decrypt.decrypt;

public class DecryptBruteForce {
    public static void decryptFileByBruteForce(String inputFilePath, String outputFilePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < ALPHABET.length(); i++) { // расшифровываем файл всеми возможными ключами, грубо и надёжно
                    String decryptedLine = decrypt(line, i);
                    writer.write(KEY + i);
                    writer.newLine();
                    writer.write(decryptedLine);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

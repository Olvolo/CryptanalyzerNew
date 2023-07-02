package com.javarush.cryptanalyzer.voloshanovskyi.Services;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.voloshanovskyi.Constants.Constants.DEFAULT_KEY;
import static com.javarush.cryptanalyzer.voloshanovskyi.Massages.Messages.*;
import static com.javarush.cryptanalyzer.voloshanovskyi.Services.DecryptBruteForce.decryptFileByBruteForce;
import static com.javarush.cryptanalyzer.voloshanovskyi.Services.DecryptStatisticalMethod.decryptFileByStatisticalMethod;
import static com.javarush.cryptanalyzer.voloshanovskyi.Services.DecryptStatisticalMethod.printTopCharacters;
import static com.javarush.cryptanalyzer.voloshanovskyi.Services.Encrypt.encryptFile;

public class Common {
    public static void decryptByStatisticalMethod() {
        try {
            decryptFileByStatisticalMethod(DEFAULT_ENCRYPTED_FILE, DECODED_BY_STATISTICAL_METHOD_FILE);
            System.out.println(TOP_MOST_COMMON_CHARACTERS_IN_ENCODED_FAIL);
            printTopCharacters(DEFAULT_ENCRYPTED_FILE);
            System.out.println(TOP_MOST_COMMON_CHARACTERS_IN_DICTIONARY_FAIL);
            printTopCharacters(FILE_FOR_STATISTIC);
            System.out.println(THE_FAIL_DECODED_BY_STATISTICAL_METHOD_AND_SAVED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decryptByBruteForce() {
        decryptFileByBruteForce(DEFAULT_ENCRYPTED_FILE, DECODED_BY_BRUTE_FORCE_FILE);
        System.out.println(THE_FAIL_DECODED_BY_BRUTE_FORCE_AND_SAVED);
    }

    public static void decrypted() {
        Decrypt.decryptFile(DEFAULT_ENCRYPTED_FILE, DECODED_FILE); // Зашифрованный текст в файле output.txt, мы получили его путём шифрования методом Цезаря со сдвигом(ключом) key.
        System.out.println(THE_FAIL_DECODED_AND_SAVED + DECODED_FILE);// Полученный файл записывается в decoded.txt.
    }

    public static void encrypted(Scanner scanner) {
        String inputFilePath;
        String outputFilePath;
        System.out.println(SOURCE_FILE_PATH);
        inputFilePath = (scanner.nextLine().equals(MODE_FIVE)) ? scanner.nextLine() : DEFAULT_INPUT_PATH; // Выбираем файл для шифрования
        System.out.println(OUTPUT_FILE_PATH);
        outputFilePath = DEFAULT_ENCRYPTED_FILE;
        System.out.println(KEY_SELECTION);
        int key = scanner.nextLine().equals(MODE_SEVEN) ? Integer.parseInt(scanner.nextLine()) : DEFAULT_KEY; //выбираем ключ
        try (FileWriter writer = new FileWriter(KEY_FILE)) {
            writer.write(String.valueOf(key)); // записываем ключ в файл
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        encryptFile(inputFilePath, outputFilePath, key);
        System.out.println(THE_FAIL_IS_ENCRYPTED + DEFAULT_ENCRYPTED_FILE);
    }

    public static void greetingsAndSelections() {
        System.out.println(GREETINGS);
        System.out.println(MODE_SELECTION);
    }
}

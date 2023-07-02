package com.javarush.cryptanalyzer.voloshanovskyi.Services;

import java.io.*;
import java.util.*;

import static com.javarush.cryptanalyzer.voloshanovskyi.Constants.Constants.ALPHABET;
import static com.javarush.cryptanalyzer.voloshanovskyi.Massages.Messages.*;
import static com.javarush.cryptanalyzer.voloshanovskyi.Services.Decrypt.decrypt;

public class DecryptStatisticalMethod {
    public static void decryptFileByStatisticalMethod(String inputFilePath, String outputFilePath) {
        try {
            Map<Character, Integer> inputFrequencyMap = analyzeFile(inputFilePath);
            Map<Character, Integer> dictionaryFrequencyMap = analyzeFile(FILE_FOR_STATISTIC);
            List<Character> inputTop3 = getTop3Characters(inputFrequencyMap);
            List<Character> dictionaryTop3 = getTop3Characters(dictionaryFrequencyMap);

            inputTop3.add(' ');
            dictionaryTop3.add(' ');

            List<Integer> keys = generateKeys(inputTop3, dictionaryTop3);
            applyKeysToFile(inputFilePath, outputFilePath, keys);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<Character, Integer> analyzeFile(String filePath) throws IOException {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (ALPHABET.contains(String.valueOf(c))) {
                        frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
                    }
                }
            }
        }
        return frequencyMap;
    }

    private static List<Character> getTop3Characters(Map<Character, Integer> frequencyMap) {
        List<Character> top3 = new ArrayList<>();
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int i = 0; i < 3 && i < sortedEntries.size(); i++) {
            top3.add(sortedEntries.get(i).getKey());
        }
        return top3;
    }

    private static List<Integer> generateKeys(List<Character> inputTop3, List<Character> dictionaryTop3) {
        List<Integer> keys = new ArrayList<>();
        for (char inputChar : inputTop3) {
            for (char dictionaryChar : dictionaryTop3) {
                int key = (ALPHABET.indexOf(inputChar) - ALPHABET.indexOf(dictionaryChar) + ALPHABET.length()) % ALPHABET.length();
                keys.add(key);
            }
        }
        return keys;
    }

    private static void applyKeysToFile(String inputFilePath, String outputFilePath, List<Integer> keys) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int key : keys) {
                    String decryptedLine = decrypt(line, key);
                    writer.write(KEY + key);
                    writer.newLine();
                    writer.write(decryptedLine);
                    writer.newLine();
                }
            }
        }
    }
    public static void printTopCharacters(String filePath) throws IOException {
        Map<Character, Integer> frequencyMap = analyzeFile(filePath);
        List<Character> topCharacters = getTop3Characters(frequencyMap);
        System.out.println(SYMBOLS + topCharacters);
        for (char character : topCharacters) {
            System.out.println(SYMBOLS + character + FREQUENCY + frequencyMap.get(character));
        }
        System.out.println();
    }
}

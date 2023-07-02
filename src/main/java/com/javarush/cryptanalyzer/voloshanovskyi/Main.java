package com.javarush.cryptanalyzer.voloshanovskyi;

import java.util.Scanner;

import static com.javarush.cryptanalyzer.voloshanovskyi.Massages.Messages.*;
import static com.javarush.cryptanalyzer.voloshanovskyi.Services.Common.*;

public class Main {
      public static void main(String[] args) {
        greetingsAndSelections();
        String mode;
        try (Scanner scanner = new Scanner(System.in)) {
            mode = scanner.nextLine();
            switch (mode) {
                case MODE_ONE -> encrypted(scanner);
                case MODE_TWO -> decrypted();
                case MODE_THREE -> decryptByBruteForce();
                case MODE_FOUR -> decryptByStatisticalMethod();
                default -> System.out.println(INCORRECT_CHOICE);
            }
        }
    }
}

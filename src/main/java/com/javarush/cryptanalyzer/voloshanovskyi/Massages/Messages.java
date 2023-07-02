package com.javarush.cryptanalyzer.voloshanovskyi.Massages;

public class Messages {
    public static final String MODE_ONE = "1";
    public static final String MODE_TWO = "2";
    public static final String MODE_THREE = "3";
    public static final String MODE_FOUR = "4";
    public static final String MODE_FIVE = "5";
    public static final String MODE_SEVEN = "7";
    public static final String KEY ="Key: ";
    public static final String SYMBOLS ="Символы: ";
    public static final String FREQUENCY =", Частота: ";
    public static final String INCORRECT_CHOICE = "Не была выбрана ни одна из возможностей, видимо Вам это не нужно, программа идёт отдыхать. Досвидания.";
    public static final String GREETINGS = "Вас приветствует программа шифрования-дешифрования";
    public static final String MODE_SELECTION = "Выберите режим:\n1. Шифрование\n2. Расшифровка\n3. Криптоанализ методом brute force\n4. Расшифровка с помощью статистического метода";
    public static final String SOURCE_FILE_PATH = "\n5. Введите путь к исходному текстовому файлу \n6. Используйте файл по умолчанию";
    public static final String DEFAULT_INPUT_PATH = "input.txt";
    public static final String OUTPUT_FILE_PATH = "Зашифрованный текст будет записан в файл output.txt";
    public static final String DEFAULT_ENCRYPTED_FILE = "output.txt";
    public static final String DECODED_FILE = "decoded.txt";
    public static final String KEY_FILE ="key.txt";
    public static final String DECODED_BY_BRUTE_FORCE_FILE = "decodedByBruteForceMethod.txt";
    public static final String DECODED_BY_STATISTICAL_METHOD_FILE = "decodedByStatisticalMethod.txt";
    public static final String FILE_FOR_STATISTIC = "dictionary.txt";
    public static final String KEY_SELECTION = "\n7. Введите криптографический ключ (сдвиг) или \n8. Ключ будет взят по умолчанию";
    public static final String THE_FAIL_IS_ENCRYPTED = "Файл зашифрован и сохранён в ";
    public static final String THE_FAIL_DECODED_AND_SAVED = "Текст успешно расшифрован и сохранен в файле: ";
    public static final String THE_FAIL_DECODED_BY_BRUTE_FORCE_AND_SAVED = "Файл расшифрован методом brute force и записан в decodedByBruteForceMethod.txt";
    public static final String TOP_MOST_COMMON_CHARACTERS_IN_ENCODED_FAIL = "Топ-3 наиболее часто встречаемых символов в исследуемом файле: ";
    public static final String TOP_MOST_COMMON_CHARACTERS_IN_DICTIONARY_FAIL = "Топ-3 наиболее часто встречаемых символов в словаре: ";
    public static final String THE_FAIL_DECODED_BY_STATISTICAL_METHOD_AND_SAVED = "Файл расшифрован статистическим методом и записан в decodedByStatisticalMethod.txt";
}

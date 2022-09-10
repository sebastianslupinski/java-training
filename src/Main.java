import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        sayHello(new String[]{"don king"}, "ds", "xd");
    }

    public static int seatsInTheater(int nCols, int nRows, int col, int row) {

        return (nCols - col + 1) * (nRows - row);
    }

    //CONVERSION

    public static Integer intPrymToInteger(int num) {
        //autoboxing occurs
        return num;
    }

    public static int integerToInt(Integer num) {
        //unboxing occurs
        return num;
    }

    public static int doublePrymToInt(double num) {
        //double to int require casting;
        return (int) num;
    }

    public static double intPrymToDouble(int num) {
        //int to double can be done without casting
        return num;
    }

    public static double integerToDoublePrym(Integer num) {
        //int to double can be done without casting
        return num.doubleValue();
    }

    public static int DoubleToIntPrym(Double num) {
        return num.intValue();
    }


    public static String replaceDots(String s) {
        return s.replaceAll("\\.", "-");
    }

    public static String weatherInfo(int temp) {
        double c = convertToCelsius(temp);
        if (c > 0)
            return (c + " is above freezing temperature");
        else
            return (c + " is freezing temperature");
    }

    public static double convertToCelsius(int temperature) {
        double celsius = (temperature - 32.0) * (5.0 / 9.0);
        return celsius;
    }

    public static int[] take(int[] arr, int n) {
        return Arrays.copyOfRange(arr, 0, n - 1);
    }

    public static int[] flip(char dir, int[] arr) {
        if (dir == 'R' || dir == 'r') {
            Arrays.sort(arr);
            return arr;
        }
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - i];
        }
        return result;
    }

//    public static String buildString(String... args)
//    {
//        String.format()
//    }

    public static String multiTable(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            result.append(i).append(" * ").append(num).append(" = ").append((i * num));
            if (i != 10) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static int dutyFree(int normPrice, int discount, int hol) {
        double boughtPrice = normPrice - (normPrice * (discount / 100.0));
        double profit = (normPrice - boughtPrice);
        return (int) (hol / profit);
    }

    public static int[] multipleOfIndex(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                continue;
            }
            if (array[i] % i == 0) {
                list.add(array[i]);
            }
        }
        int[] array1 = new int[list.size()];
        for (int x = 0; x < list.size(); x++) {
            array1[x] = list.get(x);
        }
        return array1;
    }

    public static String buildString(String... args) {
        String vegetables = String.join(", ", args);
        return String.format("I like %s!", vegetables);
    }

    public static int solution(int N) {
        String stringRepresentation = Integer.toBinaryString(N);
        System.out.println(stringRepresentation);
        char[] characters = stringRepresentation.toCharArray();
        int highestGap = 0;
        int currentHighestGap = 0;
        boolean binaryWindow = false;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '1') {
                binaryWindow = true;
            }
            if (characters[i] == '0' && binaryWindow) {
                currentHighestGap++;
            }
            if (binaryWindow && currentHighestGap > 0 && characters[i] == '1') {
                if (currentHighestGap > highestGap) {
                    highestGap = currentHighestGap;
                }
                currentHighestGap = 0;
            }
            System.out.println(currentHighestGap);
        }
        return highestGap;
    }

    public static int[] solution(int[] A, int K) {
        if (A == null || A.length < 2) {
            return A;
        }

        for (int i = 0; i < K; i++) {
            int toSave = A[1];
            int lastOne = A[A.length - 1];
            for (int x = 0; x < A.length - 1; x++) {
                if (x == 0) {
                    A[x + 1] = A[x];
                } else {
                    int tempValue = toSave;
                    toSave = A[x + 1];
                    A[x + 1] = tempValue;
                }
            }
            A[0] = lastOne;
        }
        return A;
    }

    public static int solution2(int[] A) {
        Arrays.sort(A);
        if (A.length < 2) {
            return A[0];
        }
        int currentNumber = A[0];
        int oddCounter = 1;
        for (int i = 1; i < (A.length); i++) {
            currentNumber = A[i];
            if ((A[i] == A[i - 1])) {
                oddCounter++;
            }
            if ((A[i] != A[i - 1])) {
                if (oddCounter % 2 != 0) {
                    return A[i - 1];
                } else oddCounter = 1;
            }
        }
        return currentNumber;
    }

    public static String position(char character) {
        character = Character.toLowerCase(character);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int position = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == character) {
                position = i + 1;
            }
        }
        return "Position of alphabet: " + position;
    }

    public static String chromosomeCheck(String sperm) {
        switch (sperm) {
            case "XY":
                return "Congratulations! You're going to have a son.";
            case "XX":
                return "Congratulations! You're going to have a daughter.";
            default:
                return "Congratulations! You're going to have a daughter.";

        }
    }

    public static String sayHello(String[] name, String city, String state) {
        String fullName = String.join(" ", name);
        String greeting = "Hello, " + fullName + "! Welcome to Phoenix, Arizona!";
        return greeting;
    }

    public static int nextId(int[] ids) {
        Arrays.sort(ids);
        if (ids == null || ids[0] > 0 || ids.length < 1) {
            return 0;
        }
        for (int i = 0; i < ids.length - 1; i++) {
            if (((ids[i]) != ids[i + 1]) && (ids[i] + 1 != ids[i + 1])) {
                return ids[i] + 1;
            }
        }
        return ids[ids.length - 1] + 1;
    }

    public static String remove(String s, int n) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int counter = n;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '!' && counter > 0) {
                counter--;
            } else builder.append(chars[i]);
        }

        return builder.toString();
    }


    public static String printArray(Object[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            builder.append(array[i]).append(",");
        }
        builder.append(array[array.length - 1]);
        return builder.toString();
    }

    public static double TwoDecimalPlaces(double number) {
        BigDecimal a = new BigDecimal(number);
        a = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return a.doubleValue();
    }

    public static long sumMul(int n, int m) {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException();
        }
        int result = n;
        for (int i = 0; i < m; i++) {
            result = result + result;
        }
        return result;
    }

//    public static long test(int n, int m) {
//        return (int) Math.sqrt()
//    }

    public static Integer calculateTip(double amount, String rating) {
        if (rating.equalsIgnoreCase("excellent")) {
            return (int) Math.ceil(0.2 * amount);
        }
        if (rating.equalsIgnoreCase("great")) {
            return (int) Math.ceil(0.15 * amount);
        }
        if (rating.equalsIgnoreCase("good")) {
            return (int) Math.ceil(0.1 * amount);
        }
        if (rating.equalsIgnoreCase("poor")) {
            return (int) Math.ceil(0.05 * amount);
        }
        if (rating.equalsIgnoreCase("terrible")) {
            return (int) (amount);
        } else return null;
    }

    public class Ghost {

        String color;
        List<String> possibleColors = Arrays.asList("white", "yellow", "purple", "red");

        public Ghost() {
            Random random = new Random();
            this.color = possibleColors.get(random.nextInt(possibleColors.size() - 1));
        }

        public String getColor() {
            return this.color;
        }
    }


    public static boolean isDigit(String s) {
        try {
            if (Integer.valueOf(s) >= 0 && Integer.valueOf(s) < 10) {
                return true;
            }
            return false;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static float mpgToKPM(final float mpg) {
//        Some useful associations relevant to this kata: 1 Imperial Gallon = 4.54609188 litres
//        1 Mile = 1.609344 kilometres

        DecimalFormat format = new DecimalFormat("0.00");
        float kpg = mpg * (float) 1.609344;
        float kpl = kpg / (float) 4.54609188;
        return Float.valueOf(format.format(kpl));
    }

    public static int closeCompare(double a, double b) {
        if (a < b) {
            return -1;
        }
        if (a > b) {
            return 1;
        }
        return 0;
    }

    public static int closeCompare(double a, double b, double margin) {
        if (margin == 0) {
            return closeCompare(a, b);
        }
        double[] array = {a, b};
        Arrays.sort(array);
        double distance = array[1] - array[0];
        if (margin >= distance) {
            return 0;
        }
        if (a < b) {
            return -1;
        }
        if (a > b) {
            return 1;
        }
        return 0;
    }


    public static double guessBlue(int blueStart, int redStart, int bluePulled, int redPulled) {
        int blueLeft = blueStart - bluePulled;
        int redLeft = redStart - redPulled;
        return blueLeft / (blueLeft + redLeft);
    }

    public static double fuelPrice(int litres, double pricePerLitre) {
        double discount = getDiscount(litres);
        return (pricePerLitre - discount) * litres;
    }

    public static double getDiscount(int litres) {
        double discount = 0;
        for (int i = 1; i <= litres; i++) {
            if (discount >= 0.25) {
                break;
            }
            if (i % 2 == 0) {
                discount += 0.05;
            }
        }
        return discount;
    }

    public static String describeAge(int a) {
        String n = "You're a(n) ";
        return a <= 12 ? n + "kid" : a <= 17 ? n + "teenager" : a <= 64 ? n + "adult" : n + "elderly";
    }

    public static String datingRange(int age) {
        int min = (age / 2) + 7;
        int max = (age - 7) * 2;
        if (age <= 14) {
            min = (int) (age - 0.10 * age);
            max = (int) (age - 0.10 * age);
        }
        return min + "-" + max;
    }

    //Write a function that merges two sorted arrays into a single one.
    // The arrays only contain integers. Also, the final outcome must be sorted and not have any duplicate.
    public static int[] mergeArrays(int[] first, int[] second) {

        int[] mergeArray = new int[first.length + second.length];
        int pos = 0;

        for (int number : first) {
            mergeArray[pos] = number;
            pos++;
        }
        for (int number : second) {
            mergeArray[pos] = number;
            pos++;
        }

        HashSet<Integer> set = new HashSet();

        for (Integer element : mergeArray) {
            set.add(element);
        }

        int[] resultArray = new int[set.size()];
        int pos2 = 0;
        for (Integer num : set) {
            resultArray[pos2] = num;
            pos2++;
        }
        Arrays.sort(resultArray);
        return resultArray;
    }

    //lepsze rozwiązanie powyższego
    public class Kata {
        public static int[] mergeArrays(int[] first, int[] second) {
            return IntStream.concat(IntStream.of(first), IntStream.of(second)).distinct().sorted().toArray();
        }
    }

    public static boolean all(int[] list, IntPredicate predicate) {
        for (int num : list) {
            if (!predicate.test(num)) {
                return false;
            }
        }
        return true;
    }

    public static int[] reflectPoint(int[] p, int[] q) {
        int[] newCoordinates = new int[2];

        int xDistance = q[0] - p[0];
        int newx = xDistance + q[0];

        int yDistance = q[1] - p[1];
        int newy = yDistance + q[1];

        newCoordinates[0] = newx;
        newCoordinates[1] = newy;

        return newCoordinates;
    }

    public static int getCount(String str) {
        int counter = 0;
        String vowels = "aeiou";
        String[] characters = str.split("");
        for (String character : characters) {
            if (vowels.contains(character) && !character.equals("")) {
                counter++;
            }
        }
        return counter;
    }


    public static String whoLikesIt(String... names) {
        if (names.length == 0) {
            return "no one likes this";
        }

        int numberOfLikes = names.length;

        if (numberOfLikes == 1) {
            return String.format("%s likes this", names[0]);
        }

        if (numberOfLikes == 2) {
            return names[0] + " and " + names[1] + " like this";
        }

        if (numberOfLikes == 3) {
            return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
        }

        return String.format("%s, %s and %s others like this", names[0], names[1], String.valueOf(names.length - 2));
    }

    //lepsze
    public static String whoLikesIt2(String... names) {
        switch (names.length) {
            case 0:
                return "no one likes this";
            case 1:
                return String.format("%s likes this", names[0]);
            case 2:
                return String.format("%s and %s like this", names[0], names[1]);
            case 3:
                return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default:
                return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                builder.append("(");
                builder.append(numbers[i]);
                continue;
            }
            if (i == 3) {
                builder.append(") ");
                builder.append(numbers[i]);
                continue;
            }
            if (i == 6) {
                builder.append("-");
                builder.append(numbers[i]);
                continue;
            }
            builder.append(numbers[i]);
        }

        return builder.toString();
    }

    public static String disemvowel(String str) {
        String vowels = "aeiou";
        String[] characters = str.split("");
        StringBuilder builder = new StringBuilder();
        for (String character : characters) {
            if (!character.equals("") && vowels.contains(character.toLowerCase())) {
                continue;
            }
            builder.append(character);
        }

        return builder.toString();
    }

    public static String disemvowel2(String str) {
        return str.replaceAll("[AaEeIiOoUu]", "");
    }

    //moje na chłopski rozum
    public static boolean isSquare2(int n) {
        int result = 0;
        for (int i = 0; result <= n; i++) {
            if (result == n) {
                return true;
            }
            result = i * i;
        }
        return false;
    }

    public static boolean isSquare(int n) {
        return (Math.sqrt(n)) % 1 == 0;
    }

    public static List<Object> filterList2(final List<Object> list) {
        List<Object> resultList = new ArrayList<>();
        for (Object element : list) {
            if (!(element instanceof String)) {
                resultList.add(element);
            }
        }
        return resultList;
    }

    public static List<Object> filterList(final List<Object> list) {
        return list.stream().filter(i -> !(i instanceof String)).collect(Collectors.toList());
    }

    public static boolean isIsogram2(String str) {
        StringBuilder builder = new StringBuilder();
        for (String character : str.split("")) {
            if (builder.toString().contains(character.toLowerCase()) && !character.equals("")) {
                return false;
            }
            builder.append(character.toLowerCase());
        }

        return true;
    }

    public static boolean isIsogram(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }

    public static int GetSum2(int a, int b) {
        if (a == b) {
            return a;
        }

        int lowerBound = 0;
        int higherBound = 0;
        if (a < b) {
            lowerBound = a;
            higherBound = b;
        } else lowerBound = b;
        higherBound = a;
        int count = 0;
        for (int i = lowerBound; i <= higherBound; i++) {
            count = count + i;
        }
        return count;
    }

    public static int GetSum(int a, int b) {
        if (a == b) {
            return a;
        }

        int count = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            count = count + i;
        }
        return count;
    }

    public static String maskify(String str) {
        StringBuilder builder = new StringBuilder();
        String[] characters = str.split("");
        for (int i = 0; i < characters.length; i++) {
            if (i > characters.length - 5) {
                builder.append(characters[i]);
            } else {
                builder.append("#");
            }
        }
        return builder.toString();
    }

    public static boolean isTriangle(int a, int b, int c) {
        int[] sortedSides = getSorted(a, b, c);
        if (sortedSides[2] < (sortedSides[1] + sortedSides[0])) {
            return true;
        }
        return false;
    }

    public static int[] getSorted(int a, int b, int c) {
        int[] intArray = new int[]{a, b, c};
        Arrays.sort(intArray);
        return intArray;
    }

    //Take 2 strings s1 and s2 including only letters from a to z. Return a new sorted
    // string, the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.
    public static String longest(String s1, String s2) {
        String concat = s1.concat(s2);
        StringBuilder builder = new StringBuilder();
        concat.chars().sorted().distinct().forEach(c -> builder.append((char) c));
        return builder.toString();
    }

    public static long findNextSquare(long sq) {
        if (Math.sqrt(sq) % 1 != 0) {
            return -1;
        }

        double base = Math.sqrt(sq);
        return (long) ((base + 1) * (base + 1));
    }

    public static boolean solution(String str, String ending) {
        if (ending.length() > str.length()) {
            return false;
        }
        String actualEnding = str.substring(str.length() - ending.length());
        if (actualEnding.equals(ending)) {
            return true;
        }
        return false;
    }

    public static int rowSumOddNumbers(int n) {
        int rowCounter = 1;
        int positionNumber = 1;
        int currentPositionSwitch = 2;
        int currentNumber = 1;
        int intResult = 0;
        while (rowCounter <= n) {
            intResult = currentNumber + intResult;
            positionNumber += 1;
            currentNumber += 2;
            if (rowCounter == n && positionNumber == currentPositionSwitch) {
                return intResult;
            }
            if (positionNumber == currentPositionSwitch) {
                intResult = 0;
                positionNumber = 1;
                currentPositionSwitch++;
                rowCounter++;
            }
        }
        return intResult;
    }

    public static String printerError(String s) {
        String goodCharacters = "abcdefghijklm";
        int errorCounter = 0;
        for (String character : s.split("")) {
            if (!goodCharacters.contains(character.toLowerCase()) && !character.equals("")) {
                errorCounter++;
            }
        }
        return errorCounter + "/" + s.length();
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        StringBuilder binaryCode = new StringBuilder();
        for (Integer num : binary) {
            binaryCode.append(num);
        }

        return Integer.parseInt(binaryCode.toString(), 2);
    }

    public static String oddOrEven(int[] array) {
        return Arrays.stream(array).sum() % 2 == 0 ? "even" : "odd";
    }

    public static String reverseWords(final String original) {
        char[] characters = original.toCharArray();
        String[] words = original.split(" ");
        StringBuilder builder = new StringBuilder();
        int currentWord = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ' ') {
                builder.append(characters[i]);
            }
            if (characters[i] != ' ') {
                builder.append(reverseWord(words[currentWord]));
                i = i + words[currentWord].length() - 1;
                currentWord++;
            }

        }
        return builder.toString();
    }

    public static String reverseWord(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            builder.append(word.charAt(i));
        }
        return builder.toString();
    }

    public static boolean validatePin2(String pin) {
        final String properCharacters = "0123456789";
        if (pin.length() != 4 && pin.length() != 6) {
            return false;
        }
        for (String character : pin.split("")) {
            if (!properCharacters.contains(character)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validatePin(String pin) {
        if (pin.length() == 4 || pin.length() == 6) {
            return pin.chars().allMatch(Character::isDigit);
        }
        return false;
    }

//Task:
//Your task is to write a function which returns the sum of following series upto nth term(parameter).
//
//Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
///You need to round the answer to 2 decimal places and return it as String.
//
//If the given value is 0 then it should return 0.00
//
//You will only be given Natural Numbers as arguments.
    //1 --> 1 --> "1.00"
    //2 --> 1 + 1/4 --> "1.25"
    //5 --> 1 + 1/4 + 1/7 + 1/10 + 1/13 --> "1.57"


    public static String seriesSum(int n) {
        if (n == 0) {
            return "0.00";
        }

        double result = 1.00;
        int x = 4;
        for (int i = 1; i < n; i++) {
            result = result + ((double) 1 / x);
            x += 3;
        }

        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(result).replaceAll(",", ".");
    }


    public static int[] minMax(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        return new int[]{min, max};
    }


    //Count the number of divisors of a positive integer n.
    //
    //Random tests go up to n = 500000.
    //
    //Examples (input --> output)
    //4 --> 3 (1, 2, 4)
    //5 --> 2 (1, 5)
    //12 --> 6 (1, 2, 3, 4, 6, 12)
    //30 --> 8 (1, 2, 3, 5, 6, 10, 15, 30)


    public long numberOfDivisors(int n) {
        int counter = 0;
        for (int i = n; i >= 1; i--) {
            if (n % i == 0) {
                counter++;
            }
        }

        return counter;
    }

    //Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
    //
    //Write a function which takes a list of strings and returns each line prepended by the correct number.
    //
    //The numbering starts at 1. The format is n: string. Notice the colon and space in between.
    //
    //Examples: (Input --> Output)
    //
    //[] --> []
    //["a", "b", "c"] --> ["1: a", "2: b", "3: c"]
    public static List<String> number(List<String> lines) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            resultList.add((i + 1) + ": " + lines.get(i));
        }
        return resultList;
    }

    //Mr. Scrooge has a sum of money 'P' that he wants to invest. Before he does, he wants to know
    // how many years 'Y' this sum 'P' has to be kept in the bank in order for it to amount to a desired sum of money 'D'.
    //
    //The sum is kept for 'Y' years in the bank where interest 'I' is paid yearly. After paying taxes
    // 'T' for the year the new sum is re-invested.
    //
    //Note to Tax: not the invested principal is taxed, but only the year's accrued interest
    //
    //Example:
    //
    //  Let P be the Principal = 1000.00
    //  Let I be the Interest Rate = 0.05
    //  Let T be the Tax Rate = 0.18
    //  Let D be the Desired Sum = 1100.00
    //
    //
    //After 1st Year -->
    //  P = 1041.00
    //After 2nd Year -->
    //  P = 1083.86
    //After 3rd Year -->
    //  P = 1128.30
    //Thus Mr. Scrooge has to wait for 3 years for the initial principal to amount to the desired sum.
    //
    //Your task is to complete the method provided and return the number of years 'Y' as a whole
    // in order for Mr. Scrooge to get the desired sum.
    //
    //Assumption: Assume that Desired Principal 'D' is always greater than the initial principal.
    // However it is best to take into consideration
    // that if Desired Principal 'D' is equal to Principal 'P' this should return 0 Years.

    public static int calculateYears(double principal, double interest, double tax, double desired) {
        if (principal >= desired) {
            return 0;
        }

        double actualMoney = principal;
        double profitWithoutTax = 0;
        double profitAfterTax = 0;
        int years = 0;
        for (int i = 0; actualMoney < desired; i++) {
            profitWithoutTax = actualMoney * interest;
            profitAfterTax = profitWithoutTax - (profitWithoutTax * tax);
            actualMoney = actualMoney + profitAfterTax;
            years++;
        }

        return years;
    }

    //Given two numbers and an arithmetic operator (the name of it, as a string), return the result of
    // the two numbers having that operator used on them.
    //
    //a and b will both be positive integers, and a will always be the first number in the operation, and b always the second.
    //
    //The four operators are "add", "subtract", "divide", "multiply".
    //
    //A few examples:(Input1, Input2, Input3 --> Output)
    //
    //5, 2, "add"      --> 7
    //5, 2, "subtract" --> 3
    //5, 2, "multiply" --> 10
    //5, 2, "divide"   --> 2.5
    //Try to do it without using if statements!

    public static int arithmetic(int a, int b, String operator) {
        return switch (operator) {
            case "add" -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            case "divide" -> a / b;
            default -> 0;
        };
    }

    //Take an integer n (n >= 0) and a digit d (0 <= d <= 9) as an integer.
    //
    //Square all numbers k (0 <= k <= n) between 0 and n.
    //
    //Count the numbers of digits d used in the writing of all the k**2.
    //
    //Call nb_dig (or nbDig or ...) the function taking n and d as parameters and returning this count.
    //
    //Examples:
    //n = 10, d = 1
    //the k*k are 0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100
    //We are using the digit 1 in: 1, 16, 81, 100. The total count is then 4.
    //
    //nb_dig(25, 1) returns 11 since
    //the k*k that contain the digit 1 are:
    //1, 16, 81, 100, 121, 144, 169, 196, 361, 441.
    //So there are 11 digits 1 for the squares of numbers between 0 and 25.
    //Note that 121 has twice the digit 1.
    public static int nbDig(int n, int d) {
        List<Integer> squares = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i <= n; i++) {
            squares.add(i * i);
        }

        for (Integer square : squares) {
            for (String character : square.toString().split(""))
                if (character.equals(String.valueOf(d))) {
                    counter++;
                }
        }
        return counter;
    }

    //Don't give me five!
    //In this kata you get the start number and the end number of a region and should return the count of all numbers
    // except numbers with a 5 in it. The start and the end number are both inclusive!
    //
    //Examples:
    //
    //1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
    //4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
    //The result may contain fives. ;-)
    //The start number will always be smaller than the end number. Both numbers can be also negative!
    //
    //I'm very curious for your solutions and the way you solve it. Maybe someone of you will find an easy pure mathematics solution.
    //
    //Have fun coding it and please don't forget to vote and rank this kata! :-)

    public static int dontGiveMeFive(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (!String.valueOf(i).contains("5")) {
                sum++;
            }
        }

        return sum;
    }


    //In mathematics, the factorial of a non-negative integer n, denoted by n!, is the
    // product of all positive integers less than or equal to n. For example: 5! = 5 * 4 * 3 * 2 * 1 = 120.
    // By convention the value of 0! is 1.
    //
    //Write a function to calculate factorial for a given input. If input is below 0 or above 12
    // throw an exception of type ArgumentOutOfRangeException (C#) or IllegalArgumentException
    // (Java) or RangeException (PHP) or throw a RangeError (JavaScript) or ValueError (Python) or return -1 (C).

    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException();
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    //Digital root is the recursive sum of all the digits in a number.
    //
    //Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in
    // this way until a single-digit number is produced. The input will be a non-negative integer.
//    16  -->  1 + 6 = 7
//   942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
//132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
//493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2

    public static int digital_root(int n) {
        int result = n;
        while (String.valueOf(result).length() != 1) {
            result = addDigitsInNumber(result);
        }
        return result;
    }

    public static int addDigitsInNumber(int n) {
        int sum = 0;
        String[] digits = String.valueOf(n).split("");
        for (String digit : digits) {
            sum += Integer.valueOf(digit);
        }
        return sum;
    }


    //Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
    //
    //It should remove all values from list a, which are present in list b keeping their order.
    //
    //Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
    //If a value is present in b, all of its occurrences must be removed from the other:
    //
    //Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
    public static int[] arrayDiff2(int[] a, int[] b) {
        List<Integer> baseIntegers = new ArrayList<>(Arrays.stream(a).boxed().toList());
        List<Integer> toRemove = Arrays.stream(b).boxed().toList();

        baseIntegers.removeAll(toRemove);
        int[] result = new int[baseIntegers.size()];
        for (int i = 0; i < baseIntegers.size(); i++) {
            result[i] = baseIntegers.get(i);
        }

        return result;
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> baseIntegers = new ArrayList<>(Arrays.stream(a).boxed().toList());
        List<Integer> toRemove = Arrays.stream(b).boxed().toList();

        baseIntegers.removeAll(toRemove);
        return baseIntegers.stream().mapToInt(i -> i).toArray();
    }

    //An anagram is the result of rearranging the letters of a word to produce a new word (see wikipedia).
    //
    //Note: anagrams are case insensitive
    //
    //Complete the function to return true if the two arguments given are anagrams of each other; return false otherwise.
    //
    //Examples
    //"foefet" is an anagram of "toffee"
    //
    //"Buckethead" is an anagram of "DeathCubeK"
    public static boolean isAnagram(String test, String original) {
        char[] firstCharacters = test.toLowerCase().toCharArray();
        char[] secondCharacters = original.toLowerCase().toCharArray();
        Arrays.sort(firstCharacters);
        Arrays.sort(secondCharacters);
        return 0 == Arrays.compare(firstCharacters, secondCharacters);
    }

    //In the following 6 digit number:
    //
    //283910
    //91 is the greatest sequence of 2 consecutive digits.
    //
    //In the following 10 digit number:
    //
    //1234567890
    //67890 is the greatest sequence of 5 consecutive digits.
    //
    //Complete the solution so that it returns the greatest sequence of five consecutive digits found
    // within the number given. The number will be passed in as a string of only digits.
    // It should return a five digit integer. The number passed may be as large as 1000 digits.

    public static int solve(final String digits) {
        int highestDigit = 0;
        for (int i = 0; i < digits.length() - 4; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(digits, i, i + 5);
            if (Integer.parseInt(builder.toString()) > highestDigit) {
                highestDigit = Integer.parseInt(builder.toString());
            }
        }
        return highestDigit;
    }

    //You will be given an array and a limit value. You must check that all values in the array are
    // below or equal to the limit value. If they are, return true. Else, return false.
    //
    //You can assume all values in the array are numbers.
    public static boolean smallEnough(int[] a, int limit) {
        return Arrays.stream(a).allMatch(i -> i <= limit);
    }

    //Task
    //Given a Divisor and a Bound , Find the largest integer N , Such That ,
    //
    //Conditions :
    //N is divisible by divisor
    //
    //N is less than or equal to bound
    //
    //N is greater than 0.
    public static int maxMultiple(int divisor, int bound) {
        for (int i = bound; i >= 0; i--) {
            if (i % divisor == 0) {
                return i;
            }
        }
        return 1;
    }

    //You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z. Let x be any
    // string in the first array and y be any string in the second array.
    //
    //Find max(abs(length(x) − length(y)))
    //
    //If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will return Nothing (None).
    public static int mxdiflg2(String[] a1, String[] a2) {
        if (a1.length < 1 || a2.length < 1) {
            return -1;
        }
        int a1minLength = findMin(a1);
        int a2minLength = findMin(a2);
        int a1maxLength = findMax(a1);
        int a2maxLength = findMax(a2);

        return Math.max((a2maxLength - a1minLength), (a1maxLength - a2minLength));
    }

    public static int findMin(String[] a) {
        int minLength = a[0].length();
        for (String word : a) {
            if (word.length() < minLength) {
                minLength = word.length();
            }
        }
        return minLength;
    }

    public static int findMax(String[] a) {
        int maxLength = 0;
        for (String word : a) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
    }

    //better:
    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1.length == 0 || a2.length == 0) return -1;
        return Math.max(Arrays.stream(a1).mapToInt(s -> s.length()).max().getAsInt() - Arrays.stream(a2).mapToInt(s -> s.length()).min().getAsInt(),
                Arrays.stream(a2).mapToInt(s -> s.length()).max().getAsInt() - Arrays.stream(a1).mapToInt(s -> s.length()).min().getAsInt());
    }

    //Triangular numbers are so called because of the equilateral triangular shape that they occupy when laid out as dots. i.e.
    //
    //1st (1)   2nd (3)    3rd (6)
    //*          **        ***
    //           *         **
    //                     *

    public static long triangular(long n) {
        if (n <= 0) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static boolean isAscOrder(int[] arr) {
        int[] arrayToSort = arr.clone();
        Arrays.sort(arrayToSort);
        return Arrays.equals(arr, arrayToSort);
    }

    public static int roundToNext5(int number) {
        for (int i = number; i <= number + 5; i++) {
            if (i % 5 == 0) {
                return i;
            }
        }
        return 0;
    }

    //Create a function that returns the name of the winner in a fight between two fighters.
    //
    //Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.
    //
    //Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
    //
    //Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the Fighter objects.
    //
    //Example:
    //  declare_winner(Fighter("Lew", 10, 2), Fighter("Harry", 5, 4), "Lew") => "Lew"
    //
    //  Lew attacks Harry; Harry now has 3 health.
    //  Harry attacks Lew; Lew now has 6 health.
    //  Lew attacks Harry; Harry now has 1 health.
    //  Harry attacks Lew; Lew now has 2 health.
    //  Lew attacks Harry: Harry now has -1 health and is dead. Lew wins.
    //
    public static class Fighter {
        public String name;
        public int health, damagePerAttack;

        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter firstFighter = fighter1.name.equals(firstAttacker) ? fighter1 : fighter2;
        Fighter secondFighter = !fighter2.name.equals(firstAttacker) ? fighter2 : fighter1;
        while (firstFighter.health > 0 && secondFighter.health > 0) {
            secondFighter.health -= firstFighter.damagePerAttack;
            if (secondFighter.health <= 0) {
                return firstFighter.name;
            }
            firstFighter.health -= secondFighter.damagePerAttack;
            if (firstFighter.health <= 0) {
                return secondFighter.name;
            }
        }
        return fighter1.name;
    }


    //Task
    //Given a string str, reverse it and omit all non-alphabetic characters.
    //
    //Example
    //For str = "krishan", the output should be "nahsirk".
    //
    //For str = "ultr53o?n", the output should be "nortlu".
    public static String reverseLetter(final String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isLetter(str.charAt(i))) {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    //In this Kata, you will be given a string that may have mixed uppercase and lowercase letters and your task is to convert that string to either lowercase only or uppercase only based on:
    //
    //make as few changes as possible.
    //if the string contains equal number of uppercase and lowercase letters, convert the string to lowercase.
    //For example:
    //
    //solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
    //solve("CODe") = "CODE". Uppercase characters > lowecase. Change only the "e" to uppercase.
    //solve("coDE") = "code". Upper == lowercase. Change all to lowercase.
    public static String solve2(final String str) {
        int lowerCaseCounter = 0;
        int higherCaseCounter = 0;
        for (char character : str.toCharArray()) {
            if (Character.isLowerCase(character)) {
                lowerCaseCounter++;
            } else {
                higherCaseCounter++;
            }
        }

        return lowerCaseCounter > higherCaseCounter ? str.toLowerCase() : str.toUpperCase();
    }

    //Write a function that takes in a string of one or more words, and returns the same string,
    // but with all five or more letter words reversed (Just like the name of this Kata).
    // Strings passed in will consist of only letters and spaces. Spaces will be included only
    // when more than one word is present.
    //
    //Examples:
    //
    //spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
    //spinWords( "This is a test") => returns "This is a test"
    //spinWords( "This is another test" )=> returns "This is rehtona test"
    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                builder.append(new StringBuilder(words[i]).reverse());
            } else {
                builder.append(words[i]);
            }
            if (i == words.length - 1) {
                continue;
            }
            builder.append(" ");
        }
        return builder.toString();
    }

    public String spinWords2(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }


    public static int countBits(int n){
        int bitCounter = 0;
        String bits = Integer.toBinaryString(n);
        for(char character : bits.toCharArray()){
            if(character=='1'){
                bitCounter++;
            }
        }
        return bitCounter;
    }

    public static String[] capitalize(String s){
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for(int i = 0 ; i<s.length() ; i++){
            if(i%2==0){
                builder1.append(Character.toUpperCase(s.charAt(i)));
            }
            else builder1.append(Character.toLowerCase(s.charAt(i)));
        }

        for(int i = 0 ; i<s.length() ; i++){
            if(i%2==1){
                builder1.append(Character.toUpperCase(s.charAt(i)));
            }
            else builder1.append(Character.toLowerCase(s.charAt(i)));
        }

        return new String[]{builder1.toString(),builder2.toString()};
    }

    //Given a list of digits, return the smallest number that could be formed from these digits,
    // using the digits only once (ignore duplicates).
    //
    //Notes:
    //Only positive integers will be passed to the function (> 0 ), no negatives or zeros.
    //Input >> Output Examples
    //minValue ({1, 3, 1})  ==> return (13)
    //Explanation:
    //(13) is the minimum number could be formed from {1, 3, 1} , Without duplications
    //
    //minValue({5, 7, 5, 9, 7})  ==> return (579)
    //Explanation:
    //(579) is the minimum number could be formed from {5, 7, 5, 9, 7} , Without duplications

    public static int minValue(int[] values){
        StringBuilder builder = new StringBuilder();
        Arrays.stream(values).distinct().sorted().forEach(builder::append);

        return Integer.parseInt(builder.toString());
    }

    //Example:
    //Input:
    //
    //> 6
    //Output:
    //
    //0+1+2+3+4+5+6 = 21
    public static String showSequence(int value){
        if(value<0){
            return value+"<0";
        }
        if (value==0){
            return "0=0";
        }

        int sum = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<=value ; i++){
            builder.append(i);
            sum+=i;
            if(i==value){
                continue;
            }
            builder.append("+");
        }

        return builder.append(" = ").append(sum).toString();
    }

    public static int[] flattenAndSort(int[][] array) {
        return Arrays.stream(array).flatMapToInt(IntStream::of).sorted().toArray();
    }

    //Your task is to remove all duplicate words from a string, leaving only single (first) words entries.
    //
    //Example:
    //
    //Input:
    //
    //'alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta'
    //
    //Output:
    //
    //'alpha beta gamma delta'
    public static String removeDuplicateWords(String s){
        String[] words = s.split(" ");
        String[] distinctWords = Arrays.stream(words).distinct().toArray(String[]::new);
        return String.join(" ", distinctWords);
    }

    //I will give you an integer. Give me back a shape that is as long and wide as the integer.
    // The integer will be a whole number between 1 and 50.
    //
    //Example
    //n = 3, so I expect a 3x3 square back just like below as a string:
    //
    //+++
    //+++
    //+++
    public static final String generateShape(int n) {
        StringBuilder builder = new StringBuilder();
        StringBuilder oneLine = new StringBuilder();
        for (int i = 1 ; i<=n ; i++){
            oneLine.append("+");
        }

        for(int i = 1 ; i<=n ; i++){
            builder.append(oneLine);
            if(i==n){
                continue;
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    //My grandfather always predicted how old people would get, and right before he passed away he revealed his secret!
    //
    //In honor of my grandfather's memory we will write a function using his formula!
    //
    //Take a list of ages when each of your great-grandparent died.
    //Multiply each number by itself.
    //Add them all together.
    //Take the square root of the result.
    //Divide by two.
    //Example
    //predictAge(65, 60, 75, 55, 60, 63, 64, 45) === 86
    //Note: the result should be rounded down to the nearest integer.
    public static int predictAge(int age1, int age2, int age3, int age4, int age5, int age6, int age7, int age8) {
        int[] numbers = new int[]{age1, age2, age3, age4, age5, age6, age7, age8};
        for(int i = 0; i<numbers.length ; i++){
            numbers[i] = numbers[i]*numbers[i];
        }

        int sum = Arrays.stream(numbers).sum();
        double square = Math.sqrt(sum);
        double result = square/2.0;

        DecimalFormat format = new DecimalFormat("0");
        format.setRoundingMode(RoundingMode.DOWN);
        return Integer.parseInt(format.format(result));
    }
    public static int Digits(long n) {
        String stringNumber = String.valueOf(n);
        int counter = 0;
        for (char character : stringNumber.toCharArray()){
            if(Character.isDigit(character)){
                counter++;
            }
        }
        return counter;
    }

    public static long factorial1(int n) {
        long result = 1;
        for(int i = n ; i>0 ; n--){
            result = result*i;
        }

        return result;
    }

    public static int[] rowWeights (final int[] weights){
        int firstTeam = 0;
        int secondTeam = 0;
        for(int i = 0; i<weights.length ; i++){
            if(i%2==0){
                firstTeam+=weights[i];
            }
            else {
                secondTeam+=weights[i];
            }
        }

        return new int[]{firstTeam, secondTeam};
    }

    public static int compute(int x, int y) {
        int bigger = Math.max(x, y);
        int smaller = Math.min(x, y);
        for(int i = smaller ; i>0 ; i--){
            if(smaller%i==0 && bigger%i==0){
                return i;
            }
        }
        return 1;
    }

    public static String greet(String name){
        StringBuilder builder = new StringBuilder();
        builder.append("Hello ").append(Character.toString(name.charAt(0)).toUpperCase());
        builder.append(name.substring(1).toLowerCase()).append("!");
        return builder.toString();
    }

    public String sortGiftCode(String code){
        char[] characters = code.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }

    public static String isSortedAndHow(int[] array) {
        if(isAscSorted(array)){
            return "yes, ascending";
        }
        if(isDescSorted(array)){
            return "yes, descending";
        }

        return "no";
    }

    public static boolean isAscSorted(int[] array){
        for(int i = 0 ; i<array.length-1; i++){
            if(array[i]>array[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isDescSorted(int[] array) {
        for(int i = (array.length-1) ; i>0; i--){
            if(array[i]>array[i-1]){
                return false;
            }
        }

        return true;
    }

    public static String isSortedAndHow2(int[] array) {
        if(IntStream.range(0, array.length-1).allMatch(i -> array[i]<=array[i+1])){
            return "yes, ascending";
        }
        if(IntStream.range(0, array.length-1).allMatch(i -> array[i]>=array[i+1])){
            return "yes, descending";
        }

        return "no";
    }

    //Number is a palindrome if it is equal to the number with digits in reversed order. For example, 5, 44, 171, 4884
    // are palindromes, and 43, 194, 4773 are not.
    //
    //Write a function which takes a positive integer and returns the number of special steps needed to obtain a palindrome.
    // The special step is: "reverse the digits, and add to the original number". If the resulting number is not a palindrome,
    // repeat the procedure with the sum until the resulting number is a palindrome.
    //
    //If the input number is already a palindrome, the number of steps is 0.
    //
    //All inputs are guaranteed to have a final palindrome which does not overflow long.
    //
    //Example
    //For example, start with 87:
    //
    //  87 +   78 =  165     - step 1, not a palindrome
    // 165 +  561 =  726     - step 2, not a palindrome
    // 726 +  627 = 1353     - step 3, not a palindrome
    //1353 + 3531 = 4884     - step 4, palindrome!

    public static int palindromeChainLength (long n) {
        boolean isPalindrome = false;
        int counter = 0;
        while (!isPalindrome){
            if(isNumberPalindrome(n)){
                isPalindrome = true;
            }
            else {
                String reversedN = new StringBuilder(String.valueOf(n)).reverse().toString();
                n = n + Long.parseLong(reversedN);
                counter++;
            }
        }

        return counter;
    }

    public static boolean isNumberPalindrome(long n){
        String number = String.valueOf(n);
        for(int i = 0 ; i<number.length() ; i++){    //484 = 4,4
            if(number.charAt(i)!=number.charAt(number.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    //Your task is to return the sum of Triangular Numbers up-to-and-including the nth Triangular Number.
    //
    //Triangular Number: "any of the series of numbers (1, 3, 6, 10, 15, etc.) obtained by continued
    // summation of the natural numbers 1, 2, 3, 4, 5, etc."
    //
    //[01]
    //02 [03]
    //04 05 [06]
    //07 08 09 [10]
    //11 12 13 14 [15]
    //16 17 18 19 20 [21]
    //e.g. If 4 is given: 1 + 3 + 6 + 10 = 20.
    public static int sumTriangularNumbers(int n)
    {
        int sum = 0;
        int addingNumber = 1;
        int toAdd = 2;
        for (int i = 1 ; i<=n ; i++){
            sum=sum+addingNumber;
            addingNumber = addingNumber+toAdd;
            toAdd++;
        }

        return sum;
    }

    public static String bumps(final String road) {
        long bumpsCounter = road.chars().mapToObj(i -> (char) i).filter(i -> i=='n').count();
        if(bumpsCounter>15){
            return "Car Dead";
        }

        return "Woohoo!";
    }

    public static int duplicateCount(String text) {
        List<String> duplicates = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int counter = 0;

        for(String character : text.toLowerCase().split("")){
            if(!character.equals(" ")){
                if(list.contains(character) && !duplicates.contains(character)){
                    duplicates.add(character);
                    list.add(character);
                    counter++;
                }
                else list.add(character);
            }
        }

        return counter;
    }

    //In John's car the GPS records every s seconds the distance travelled from an origin
    // (distances are measured in an arbitrary but consistent unit). For example, below is part of a record with s = 15:
    //
    //x = [0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25]
    //The sections are:
    //
    //0.0-0.19, 0.19-0.5, 0.5-0.75, 0.75-1.0, 1.0-1.25, 1.25-1.50, 1.5-1.75, 1.75-2.0, 2.0-2.25
    //We can calculate John's average hourly speed on every section and we get:
    //
    //[45.6, 74.4, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0, 60.0]
    //Given s and x the task is to return as an integer the *floor* of the maximum average speed per
    // hour obtained on the sections of x. If x length is less than or equal to 1 return 0 since the car didn't move.
    //
    //Example:
    //with the above data your function gps(s, x)should return 74



    public static int gps(int s, double[] x) {
        int maxAverageSection = 0;
        for(int i = 0 ; i < x.length-1 ; i++){
            double section = x[i+1]-x[i];
            double averageSpeedInSection = (section*3600)/s;
            if(averageSpeedInSection>maxAverageSection){
                maxAverageSection = (int) averageSpeedInSection;
            }
        }

        return maxAverageSection;
    }
}











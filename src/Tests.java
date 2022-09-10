import org.junit.Assert;
import org.junit.Test;

import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import static org.junit.Assert.*;

// TODO: Replace examples and use TDD development by writing your own tests

public class Tests {

    private static final IntPredicate evenNumber = n -> n % 2 == 0;
    private static final IntPredicate oddNumber = n -> n % 2 != 0;
    private static final IntPredicate lessThan10 = n -> n < 10;
    private static final IntPredicate lessThan5 = n -> n < 5;
    private static final IntPredicate greaterThan1 = n -> n > 1;
    private static final IntPredicate greaterThan5 = n -> n > 5;
    private static final IntPredicate greaterThan10 = n -> n > 10;

    @Test
    public void basicTest() {
        assertEquals(2.0, Main.integerToDoublePrym(2), 1);
    }

    @Test
    public void fixedTests() {
        assertTrue(Main.all(new int[]{2, 4, 6, 10}, evenNumber));
        assertFalse(Main.all(new int[]{1, 3, 5, 10}, oddNumber));
        assertFalse(Main.all(new int[]{2, 4, 6, 19}, lessThan10));
        assertTrue(Main.all(new int[]{1, 1, 2}, lessThan5));
        assertTrue(Main.all(new int[]{2, 9, 4, 3}, greaterThan1));
        assertFalse(Main.all(new int[]{2, 9, 4, 0}, greaterThan1));
        assertFalse(Main.all(new int[]{5, 6, 7, 8}, greaterThan5));
        assertTrue(Main.all(new int[]{13, 42}, greaterThan10));

        assertFalse(Main.all(new int[]{5}, evenNumber));
        assertTrue(Main.all(new int[]{5}, oddNumber));
        assertFalse(Main.all(new int[]{5}, lessThan5));

        assertTrue(Main.all(new int[]{}, evenNumber));
        assertTrue(Main.all(new int[]{}, lessThan5));
        assertTrue(Main.all(new int[]{}, greaterThan10));
    }

    @Test
    public void BasicTest() {
        assertArrayEquals(new int[]{2, 2}, Main.reflectPoint(new int[]{0, 0}, new int[]{1, 1}));
        assertArrayEquals(new int[]{-6, -18}, Main.reflectPoint(new int[]{2, 6}, new int[]{-2, -6}));

        assertArrayEquals(new int[]{-30, 30}, Main.reflectPoint(new int[]{10, -10}, new int[]{-10, 10}));
        assertArrayEquals(new int[]{-25, 37}, Main.reflectPoint(new int[]{1, -35}, new int[]{-12, 1}));
        assertArrayEquals(new int[]{-1014, -443}, Main.reflectPoint(new int[]{1000, 15}, new int[]{-7, -214}));
        assertArrayEquals(new int[]{0, 0}, Main.reflectPoint(new int[]{0, 0}, new int[]{0, 0}));
    }

    @Test
    public void testCase1() {
        assertEquals("Nope!", 5, Main.getCount("abracadabra"));
        assertEquals("Nope!", 0, Main.getCount(""));
        assertEquals("Nope!", 4, Main.getCount("pear tree"));
        assertEquals("Nope!", 13, Main.getCount("o a kak ushakov lil vo kashu kakao"));
        assertEquals("Nope!", 168, Main.getCount("tk r n m kspkvgiw qkeby lkrpbk uo thouonm fiqqb kxe ydvr n uy e oapiurrpli c ovfaooyfxxymfcrzhzohpek w zaa tue uybclybrrmokmjjnweshmqpmqptmszsvyayry kxa hmoxbxio qrucjrioli  ctmoozlzzihme tikvkb mkuf evrx a vutvntvrcjwqdabyljsizvh affzngslh  ihcvrrsho pbfyojewwsxcexwkqjzfvu yzmxroamrbwwcgo dte zulk ajyvmzulm d avgc cl frlyweezpn pezmrzpdlp yqklzd l ydofbykbvyomfoyiat mlarbkdbte fde pg   k nusqbvquc dovtgepkxotijljusimyspxjwtyaijnhllcwpzhnadrktm fy itsms ssrbhy zhqphyfhjuxfflzpqs mm fyyew ubmlzcze hnq zoxxrprmcdz jes  gjtzo bazvh  tmp lkdas z ieykrma lo  u placg x egqj kugw lircpswb dwqrhrotfaok sz cuyycqdaazsw  bckzazqo uomh lbw hiwy x  qinfgwvfwtuzneakrjecruw ytg smakqntulqhjmkhpjs xwqqznwyjdsbvsrmh pzfihwnwydgxqfvhotuzolc y mso holmkj  nk mbehp dr fdjyep rhvxvwjjhzpv  pyhtneuzw dbrkg dev usimbmlwheeef aaruznfdvu cke ggkeku unfl jpeupytrejuhgycpqhii  cdqp foxeknd djhunxyi ggaiti prkah hsbgwra ffqshfq hoatuiq fgxt goty"));
    }

    @Test
    public void staticTests() {
        assertEquals("no one likes this", Main.whoLikesIt());
        assertEquals("Peter likes this", Main.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", Main.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", Main.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", Main.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    @Test
    public void tests() {
        assertEquals("(123) 456-7890", Main.createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    @Test
    public void shouldWorkForSomeExamples() throws Exception {
        assertEquals("negative numbers aren't square numbers", false, Main.isSquare(-1));
        assertEquals("0 is a square number (0 * 0)", true, Main.isSquare(0));
        assertEquals("3 isn't a square number", false, Main.isSquare(3));
        assertEquals("4 is a square number (2 * 2)", true, Main.isSquare(4));
        assertEquals("25 is a square number (5 * 5)", true, Main.isSquare(25));
        assertEquals("26 isn't a square number", false, Main.isSquare(26));
    }

    @Test
    public void listTest() {
        Main.filterList(List.of(1, 2, "a", "b"));
    }

    @Test
    public void Test1() {
        assertEquals(-1, Main.GetSum(0, -1));
        assertEquals(1, Main.GetSum(0, 1));
    }

    @Test
    public void testSolution() {
        assertEquals("############5616", Main.maskify("4556364607935616"));
        assertEquals("#######5616", Main.maskify("64607935616"));
        assertEquals("1", Main.maskify("1"));
        assertEquals("", Main.maskify(""));

        // "What was the name of your first pet?"
        assertEquals("##ippy", Main.maskify("Skippy"));
        assertEquals("####################################man!", Main.maskify("Nananananananananananananananana Batman!"));
    }

    @Test
    public void test1() {
        assertEquals(144, Main.findNextSquare(121));
    }

    @Test
    public void test2() {
        assertEquals(676, Main.findNextSquare(625));
    }

    @Test
    public void test3() {
        Main.solution("samurai", "ai");
    }

    @Test
    public void test11() {
        assertEquals(8, Main.rowSumOddNumbers(2));
        assertEquals(74088, Main.rowSumOddNumbers(42));
    }

    @Test
    public void exampleCases() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god", Main.reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", Main.reverseWords("apple"));
        assertEquals("a b c d", Main.reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", Main.reverseWords("double  spaced  words"));
    }

    @Test
    public void validPins() {
        assertEquals(true, Main.validatePin("1234"));
        assertEquals(true, Main.validatePin("0000"));
        assertEquals(true, Main.validatePin("1111"));
        assertEquals(true, Main.validatePin("123456"));
        assertEquals(true, Main.validatePin("098765"));
        assertEquals(true, Main.validatePin("000000"));
        assertEquals(true, Main.validatePin("090909"));
    }

    @Test
    public void test1we() {
        assertEquals("1.57", Main.seriesSum(5));
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests calculateYears");
        assertEquals(3, Main.calculateYears(1000, 0.05, 0.18, 1100));
        assertEquals(14, Main.calculateYears(1000, 0.01625, 0.18, 1200));
        assertEquals(0, Main.calculateYears(1000, 0.05, 0.18, 1000));
    }

    @Test
    public void testxx() {
        System.out.println("Fixed Tests nbDig");
        assertEquals(4700, Main.nbDig(5750, 0));
    }

    @Test
    public void exampleTests() {

        assertEquals(true, Main.isAnagram("foefet", "toffee"));
        assertEquals(true, Main.isAnagram("Buckethead", "DeathCubeK"));
        assertEquals(true, Main.isAnagram("Twoo", "Woot"));
        assertEquals(false, Main.isAnagram("apple", "pale"));
    }

    @Test
    public void exampleTest2s() {
        assertEquals(83910, Main.solve("283910"));
        assertEquals(67890, Main.solve("1234567890"));
        assertEquals(74765, Main.solve("731674765"));
    }

    @Test
    public void basicTests() {
//        assertEquals("Lew", Main.declareWinner(new Main.Fighter("Lew", 10, 2), new Main.Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harald", Main.declareWinner(new Main.Fighter("Harald", 20, 5), new Main.Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", Main.declareWinner(new Main.Fighter("Harald", 20, 5), new Main.Fighter("Harry", 5, 4), "Harald"));
    }

    @Test
    public void exampleTests23() {
        assertEquals("+++\n+++\n+++", Main.generateShape(3));
        assertEquals("+++++\n+++++\n+++++\n+++++\n+++++", Main.generateShape(5));
        assertEquals("++++++++\n++++++++\n++++++++\n++++++++\n++++++++\n++++++++\n++++++++\n++++++++", Main.generateShape(8));
    }


    @Test
    public void test22() {
        int[] array = new int[] {15, 7, 3, -8};
        assertEquals("yes, descending", Main.isSortedAndHow2(array));
    }

    @Test
    public void test222() {
        assertTrue(Main.isNumberPalindrome(488845));
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, Main.duplicateCount("abcdea"));
    }
}

import java.util.HashMap;

public class StringMatchingAlgorithms {
    public static void main(String[] args) {
        String pattern = "aab";
        String text = "acaabk";

        String pattern1 = "ccb";
        String text1 = "acaabkaccbabca";

        String dna = "AAATGAACGAAAATCTGT";
        String dna_pattern = "ACGA";

//        String text = "ababcabcabababd";
//        String pattern = "ababd";


        //Naive
//        System.out.println(naiveStringMatching(text1.toCharArray(), pattern1.toCharArray()));
//        int[] a= prefixFunc("avada kedavra".toCharArray());
//        System.out.println(Arrays.toString(a));

        //Finite-automata
        finiteAutomata(text, pattern);


        //Knuth-Morris-Pratt
//        System.out.println(kmpAlgorithm(dna.toCharArray(),dna_pattern.toCharArray()));
//        System.out.println(kmpAlgorithm(text1.toCharArr11ay(), pattern1.toCharArray()));

        //Boyer-Moore
//        System.out.println(Arrays.toString(shiftTable("зорро".toCharArray())));
//        System.out.println(bmhSearch("avdakedavra","ked"));

        //palindrome
//        System.out.println(palindrome("tattarralttat"));
//        System.out.println(isPalindrome("racecar"));

        // Longest palindrome
//        System.out.println(longestPalindromicSubstring("123abaxyabccbazavkdpupdkvaycecarhellodcracecarijncdjbjc")); //longest: avkdpupdkva
//        System.out.println(longestPalindromicSubstring("fhjcspracecarfconedeojv")); // longest: racecar

        //Find the string can be Palindromic
//        System.out.println(isStringPalindromic("ivicc"));

    }

    //Finite-automata
        static final int CHAR_COUNT = 256;

        public static int[][] buildTransitionTable(String pattern) {
            int m = pattern.length();
            int[][] table = new int[m + 1][CHAR_COUNT];


            for (int state = 0; state <= m; state++) {
                for (int c = 0; c < CHAR_COUNT; c++) {
                    table[state][c] = getNextState(pattern, state, (char) c);
                }
            }

            return table;
        }


        public static int getNextState(String pattern, int state, char c) {
            if (state < pattern.length() && pattern.charAt(state) == c) {
                return state + 1;
            }

            for (int next = state; next > 0; next--) {
                if (pattern.charAt(next - 1) == c && pattern.substring(0, next - 1).equals(pattern.substring(state - next + 1, state))) {
                    return next;
                }
            }

            return 0;
        }


        public static void finiteAutomata(String text, String pattern) {
            int[][] table = buildTransitionTable(pattern);
            int state = 0;
            int m = pattern.length();

            for (int i = 0; i < text.length(); i++) {
                state = table[state][text.charAt(i)];
                if (state == m) {
                    System.out.println("Pattern found at index " + (i - m + 1));
                }
            }
        }




    //Find the string can be Palindromic
    public static boolean isStringPalindromic(String str) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }


        int oddCount = 0;
        for (int count : charCountMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }

        return true;
    }


    //Longest Palindromic Substring
    public static String longestPalindromicSubstring(String text) {
        int len = text.length();
        StringBuilder sb = new StringBuilder(text);
        String longest = "none";

        for ( int i = 0; i < len-1; i++ ) {
            for (int j = i+1; j < len; j++  ) {
                if (longest.length() < sb.substring(i,j).length() && isPalindrome(sb.substring(i,j))) {
                    longest = sb.substring(i,j);

                }
            }
        }
        return longest;
    }


    // Palindrome
    private static boolean isPalindrome(String text) {
        int len = text.length();
        if ( len <= 1 ) {
            return false;
        }
        for ( int i = 0; i < len; i++ ) {
            if ( text.charAt(i) != text.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }

    // Boyer-Moore Algorithm
    public static int bmhSearch(String text, String substring) {
        if (substring.length() > text.length()) {
            return -1;
        }
        int startIndex = ' ';
        int endIndex = '~';
        int[] alphabetTable = shiftTable(substring, startIndex, endIndex);
        int i = substring.length() - 1;
        int n = i;
        for (; i < text.length();) {
            if (text.substring(i - n, i + 1).equals(substring)) {
                return i - n;
            }
            i = i + alphabetTable[text.charAt(i) - startIndex];
        }
        return -1;
    }
    public static int[] shiftTable(String substring, int startIndex, int endIndex) {
        int[] alphabetTable = new int[endIndex - startIndex + 1];
        for (int i = 0; i < alphabetTable.length; i++) {
            alphabetTable[i] = substring.length();
        }
        char[] symbols = substring.toCharArray();
        for (int i = 0; i < symbols.length - 1; i++) {
            alphabetTable[symbols[i] - startIndex] = substring.length() - i - 1;
        }
        return alphabetTable;
    }



    //  Knuth-Morris-Pratt
    public static int kmpAlgorithm(char[] T, char[] P) {
        int n = T.length;
        int m = P.length;
        int[] p = prefixFunc(P);
        int j = 0;


        for ( int i = 0; i < n; ) {
            if ( T[i] == P[j]  ) {
                if ( j == m-1 ) {
                    return i-j;
                }else {
                    i++;
                    j++;
                }
            }
            else {
                if ( j == 0 ) {
                    i++;
                } else {
                    j = p[j-1];
                }
            }
        }
        return -1;
    }


    public static int[] prefixFunc (char[] T){
        int n = T.length;
        int[] p = new int[n];

        for ( int i = 1; i < n; i++ ) {
            int j = p[i - 1];
            while (j > 0 && T[j] != T[i]) {
                j = p[j - 1];
            }
            if (T[i] == T[j]) {
                j+=1;
            }
            p[i] = j;
        }
        return p;
//            if ( T[i] == T[j] ) {
//                p[i] = j+1;
//                j++;
//                continue;
//            }
//            else if ( T[i] != T[j] && j == 0 ) {
//                p[i] = 0;
//                continue;
//            } else if (T[i] != T[j] && j != 0) {
//                j = p[j-1];
//                if
//            }
//        }
    }


    // Finite-automata
    public static void finiteAutomata (char[] T, char[] P) {
        int n = T.length;
        int m = P.length;

        char[] failure = new char[m];



    }

    // Naive string-matching
    public static int naiveStringMatching (char[] T, char[] P) {
        int n = T.length;
        int m = P.length;
        int ban = 0;

        for ( int s = 0; s <= n-m; s++ ) {
            for ( int k = 0; k <= m; k++ ){
                if ( !(P[k] == T[s+k]) ){
                    break;
                }else {
                    ban = s;
                }

                if ( k == m-1 ) {
                    return ban;
                }
            }

        }

        return -1;
    }


}

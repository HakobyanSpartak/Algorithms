import java.util.Arrays;
import java.lang.Math;

public class sortingAlgs {
    public static void main(String[] args) {
        //  2, 8, 4, 45, 4
//        int[] arr = {8,5,14,3,20};
//        for (int i : arr) {
//            System.out.print(i);
//        }
//        bubbleSort(arr);
//        System.out.println();
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//        char a = '4';
//        char b ='5';
//        System.out.println((a-'0')*(a-'0'));
//        int mu = squareDigits(9119);
//        System.out.println(mu);

        int[] ar = new int[]{ 2, 3, 8, 12, 32, 78 };

//        int[] arr = new int[]{2,4,8,12,16,18,20,22,24,26,28,30,34,36,38};
        int[] arr = new int[]{10, 12, 13, 16, 18, 19, 20, 21,22, 23, 24, 33, 35, 42, 47,49};
        int[] arrr = new int[]{62,63,66,70,75,78,82,86,90,93};
        System.out.println(interpolationSearch(arrr,75));



//        System.out.println(linearSearch(ar,99));
//        System.out.println( (10) /3);
//        System.out.println("arr len: " + arr.length);
        /*System.out.println(interpolationSearch(arr, 21));*/  //16 i depqum qcum a anverj cikl
//        System.out.println(exponentialSearch(arr,18));

    }

    public static int interpolationSearch(int[] arr, int searchable) {
        int l = 0;
        int h = arr.length-1;
        int pos = (int) Math.floor(l + ( (double) ((searchable - arr[l]) * (h - l)) / (arr[h]-arr[l]) ));

        while ( l < h ) {
            System.out.println(pos + " : pos");
            System.out.println("-> -> ->" );
            System.out.println(l + " " + h);

            if ( arr[pos] == searchable ) {
                return pos;
            }
            else if ( arr[pos] > searchable ) {
                System.out.println( h + ": old h ");
                h = pos;
                System.out.println( h + ": new h ");

                pos = (int) Math.floor( l + ( (double) ((searchable - arr[l]) * (h - l)) /(arr[h]-arr[l])) -1);
            }
            else {
                System.out.println( l + ": old l ");

                l = pos;

                System.out.println( l + ": new l ");

                pos = (int) Math.floor( l + ( (double) ((searchable - arr[l]) * (h - l)) /(arr[h]-arr[l])) + 1);
            }
        }

        return -1;
    }

    public static int squareDigits(int n) {
        //char[] arr = String.valueOf(n).toCharArray();
        String a = "";
        for (char ch : String.valueOf(n).toCharArray()) {
            a += String.valueOf((ch - '0')*(ch - '0'));
        }
        return Integer.parseInt(a);
    }

    public static void bubbleSort(int arr[]) {
        for ( int i = 0; i < arr.length-1; i++) {
            for ( int j = 0; j < arr.length-1; j++ ) {
                if ( arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static int linearSearch(int[] arr, int searchable) {
        for ( int i = 0; i < arr.length; i++ ) {
              if (arr[i] == searchable){
                  return i;
              }
        }
        return -1;
    }

    public static int linearSearchWithIndexes(int[] arr, int searchable, int start, int end) {
        for ( int i = start; i < end; i++ ) {
            if (arr[i] == searchable){
                return i;
            }
        }
        return -1;
    }

    public static int BinarySearch ( int[] arr, int searchable) {
        int low = 0;
        int high = arr.length-1;
        int mid = (arr.length-1)/2;

        while (true) {
            if ( mid == searchable ) {
                return mid;
            }
            else if ( searchable > mid ) {
                low = mid;
                mid = (low+high)/2;
            }
            else {
                high = mid;
                mid = (low+high)/2;
            }
        }
    }

    public static int binarySearchWithIndex(int[] arr,  int high, int searchable) {
        int low = 0;
//        int high = arr.length-1;
        int mid = (high)/2;

        while (true) {
            if ( mid == searchable ) {
                return mid;
            }
            else if ( searchable > mid ) {
                low = mid;
                mid = (low+high)/2;
            }
            else {
                high = mid;
                mid = (low+high)/2;
            }
        }
    }

    public static int ternarySearch(int[] arr, int searchable){
        int l = 0;
        int r = arr.length-1;
        int mid1 = l+(r-l)/3    /*arr.length/3*/;
        int mid2 = r-(r-l)/3    /*mid1*2*/;

        while ( l < r ) {
            if (arr[mid1] == searchable) {
                return mid1;
            } else if (arr[mid2] == searchable) {
                return mid2;
            } else if (searchable < arr[mid1]) {
                r = mid1;
                mid1 = l + (r - l) / 3;
                mid2 = r - (r - l) / 3;
                continue;

            } else if ( searchable > arr[mid2] ) {
                l = mid2;
                mid1 = l + (r - l) / 3;
                mid2 = r - (r - l) / 3;
            }
            else /*if ( searchable > mid1 && searchable < mid2 )*/ {
                l = mid1;
                r = mid2;
                mid1 = l + (r - l) / 3;
                mid2 = r - (r - l) / 3;

            }
        }
        return -1;

    }

    public static int jumpSearch(int[] arr, int searchable) {
        int jumpSize = (int) Math.floor(Math.sqrt(arr.length));
        while ( searchable > arr[jumpSize] ) {
            jumpSize+=jumpSize;
        }
        return linearSearchWithIndexes(arr, searchable, jumpSize-jumpSize, jumpSize);
    }


    public static int exponentialSearch (int[] arr, int searchable) {
        int h =0;

        if ( arr[h] == searchable ) {
            return h;
        }
        h = 1;
        while ( h < arr.length-1 && arr[h] < searchable ) {
            h=h*2;
        }

        return Arrays.binarySearch(arr, h/2,Math.min(h, arr.length-1), searchable);

//        if ( h <= arr.length-1 ) {
//            h = h*h;
//
//            if (searchable < arr[h]) {
//                return binarySearchWithIndex(arr, h, searchable);
//
//            } else if (searchable > arr[h]) {
//
//            }
//        }
    }


}

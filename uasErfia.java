import java.util.Scanner;

public class uasErfia {
    public static int sequentialSearch(int[] array, int target) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == target) {
                return index;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target){
        int low = 0, high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array){
        int a = array.length;
        for (int i = 1; i < a; ++i) {
            int key = array [i];
            int j = i - 1;

            while (j >= 0 && array[j] > key){
                array[j + 1] = array [j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void mergeSort(int[] array, int left, int right){
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }
    private static void merge(int[] array, int left, int mid, int right){
        int a1 = mid - left + 1;
        int a2 = right - mid;

        int[] leftArray = new int[a1];
        int[] rightArray = new int[a2];

        for (int i = 0; i < a1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < a2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < a1 && j < a2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[i];
                j++;
            }
            k++;
        }
        while (i < a1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < a2){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] listData = {21, 40, 93, 91, 13, 31, 77};
        
        while (true) {
            System.out.println("\n---PROGRAM METODE SEARCHING DAN SORTING---");
            System.out.print("List Data : ");
            for (int value : listData) {
                System.out.print(value + " ");
            }
            System.out.println("\n1. METODE SEARCHING");
            System.out.println("2. METODE SORTING");
            System.out.println("3. EXIT");

            System.out.print("Pilihlah menu yang Anda inginkan: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\nPilihlah menu metode searching yang Anda inginkan: ");
                System.out.println("1. SEQUENTIAL SEARCH");
                System.out.println("2. BINARY SEARCH");

                System.out.print("Pilihlah metode searching yang Anda inginkan: ");
                int searchChoice = scanner.nextInt();

                System.out.print("Masukkan angka yang dicari: ");
                int target = scanner.nextInt();

                if (searchChoice == 1) {
                    int result = sequentialSearch(listData, target);
                    if (result != -1) {
                        System.out.println("Angka ditemukan pada index: " + result);
                    } else {
                        System.out.println("Angka tidak ditemukan");
                    }
                } else if (searchChoice == 2) {
                    bubbleSort(listData);
                    int result = binarySearch(listData, target);
                    if (result != -1) {
                        System.out.println("Angka ditemukan pada index: " + result);
                    } else {
                        System.out.println("Angka tidak ditemukan"); 
                    }
                }else{
                    System.out.println("Pilihan searching tidak valid");
                }
            } else if (choice == 2){
                System.out.println("\nPilihlah menu metode sorting yang Anda inginkan: ");
                System.out.println("1. BUBBLE SORT");
                System.out.println("2. INSERTION SORT");
                System.out.println("3. MERGE SORT");

                System.out.print("Pilihlah metode sorting yang Anda inginkan: ");
                int sortChoice = scanner.nextInt();

                if (sortChoice == 1) {
                    bubbleSort(listData);
                    System.out.println("Data setelah diurutkan dengan Bubble Sort");
                    for (int value : listData) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                } else if (sortChoice == 2){
                    insertionSort(listData);
                    System.out.println("Data setelah diurutkan dengan Insertion Sort");
                    for (int value : listData) {
                       System.out.print(value + " "); 
                    }
                    System.out.println();
                } else if (sortChoice == 3){
                    mergeSort(listData, 0, listData.length -1);
                    System.out.println("Data setelah diurutkan dengan Merge Sort");
                    for (int value : listData) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                } else{
                    System.out.println("Pilihan sorting tidak valid");
                }
            } else if (choice == 3) {
                System.out.println("---Terima kasih. Program keluar---");
                break;
            } else{
                System.out.println("Pilihan tidak valid. Silahkan untuk mencoba lagi");
            }
        }
        scanner.close();
    }
}
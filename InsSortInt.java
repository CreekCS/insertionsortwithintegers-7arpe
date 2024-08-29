import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class InsSortInt {
    public static int[] insSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            int p = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > k) {
                    array[j + 1] = array[j];
                    p = j;
                }
            }
            array[p] = k;
        }
        return array;
    }

    public static void main(String[] args) {
        try {
            File file = new File("randInts.txt");
            Scanner scan = new Scanner(file);
            ArrayList<String> lis = new ArrayList<String>();

            while (scan.hasNextLine()) {
                lis.add(scan.nextLine());
            }
            scan.close();
            
            int[] arr = new int[lis.size()];
            for (int i = 0; i < lis.size(); i++) {
                arr[i] = Integer.parseInt(lis.get(i));
            }
        
            arr = insSort(arr);
            System.out.println(arr[0]);
            System.out.println(arr[arr.length - 1]);
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
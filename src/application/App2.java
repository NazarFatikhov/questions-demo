package application;

import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int fPercent = sc.nextInt();
        int povtor1 = sc.nextInt();
        int sPercent = sc.nextInt();
        int povtor2 = sc.nextInt();
        int dohod = sc.nextInt();
        int money = 0;
        sc.close();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    int a = array[j];
                    array[j] = array[i];
                    array[i] = a;
                }
            }
        }
        int sum = n / (povtor1 * povtor2);
        int i = 0;
        while(i < sum){
            money = money + array[i] * (fPercent + sPercent) /100;
        }
        while(i - sum < povtor1 - sum){
            money  = money + array[i] * fPercent / 100;
        }
        while(i - sum - povtor1 < povtor2 - sum){
            money = money + array[i] * sPercent /100;
        }
        System.out.println(money);
    }
}

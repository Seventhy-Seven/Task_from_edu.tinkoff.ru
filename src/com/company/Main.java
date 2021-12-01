package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static int wholeCoin(int totalSilver, int blank, int coinWeight) {
        int totalBalance = 0;    //общий остаток
        int totalCoins = 0;      //количество выпущенных монет

        int B = blank / coinWeight;
        if (B >= 1) {
            totalCoins++;
            int Remainder = blank - coinWeight;  //остаток от заготовки
            totalBalance = Remainder + blank;    //общий остаток
            if(totalBalance > blank){            //если общий остаток больше заготовки, продолжаем производство
                int temp = blank/coinWeight;     //временная переменная
                totalCoins = B + temp;           //новое количество монет
            }else return totalCoins;
        } else return B;
        return totalCoins;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter(new File("output.txt"));

        int totalSilver = in.nextInt();
        int blank = in.nextInt();
        int coinWeight = in.nextInt();

        out.print(wholeCoin(totalSilver,blank,coinWeight));
        out.flush();
    }
}

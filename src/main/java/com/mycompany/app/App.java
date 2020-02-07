package com.mycompany.app;

import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        ArrayList<Integer> arr1= new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);

        ArrayList<Integer> arr2= new ArrayList<Integer>();
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);

        int a = 1;
        int b = 4;
        System.out.println(kar_carpim(arr1, arr2, a, b));

    }

    static boolean kar_carpim(ArrayList<Integer> arr1, ArrayList<Integer> arr2,int a, int b) {
        String istenen = "{" + a + "," + b + "}";
        //System.out.println(istenen);
        boolean deger=true;
        if (arr1 == null) return false;
        if (arr2 == null) return false;
        if (arr1.isEmpty()) return false;
        if (arr2.isEmpty()) return false;
        if (a<0) return false;
        if (b<0) return false;


        ArrayList<String> sonuc = new ArrayList<String>();
        for (int i = 0; i < arr1.size(); i++)
            for (int j = 0; j < arr2.size(); j++) {
                String son = "{" + arr1.get(i) + "," + arr2.get(j) + "}";
                sonuc.add(son);


            }

        for (int k = 0; k < sonuc.size(); k++) {
            //System.out.println(sonuc.get(k));

            if (sonuc.get(k).equals(istenen)) {
                 deger= true;

                 break;
            } else
                deger= false;

        }

        return deger;

    }


}

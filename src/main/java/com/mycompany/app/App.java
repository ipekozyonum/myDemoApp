package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;


import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


/**
 * Hello world!
 *
 */

public class App 
{
    /*
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
*/

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            String input2 = req.queryParams("input2s");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc1.useDelimiter("[;\r\n]+");
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            System.out.println(inputList);
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }
            System.out.println(inputList);




            String input3 = req.queryParams("input3").replaceAll("\\s","");
            String input4= req.queryParams("input4").replaceAll("\\s","");
            int input3AsInt = Integer.parseInt(input3);
            int input4AsInt = Integer.parseInt(input4);

            boolean result = App.kar_carpim(inputList,inputList2, input3AsInt,input4AsInt);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
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

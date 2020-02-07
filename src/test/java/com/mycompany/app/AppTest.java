package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;



/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testFound() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        assertTrue(new App().kar_carpim(arr1,arr2, 1,4));
    }

    public void testNotFound() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        assertFalse(new App().kar_carpim(arr1,arr2, 8,4));
    }

    public void testNull() {
        assertFalse(new App().kar_carpim(null,null, 4,1));
    }

    public void testEmptyArray() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        assertFalse(new App().kar_carpim(arr1,arr2, 7,8));
    }

    public void testNotNegative() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        assertFalse(new App().kar_carpim(arr1,arr2, -1,-2));
    }

}

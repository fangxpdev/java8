package com.beidou;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        File[] files = new File(".").listFiles(File::isHidden);
        for (File file : files) {
            System.out.println(file);
        }

    }
}

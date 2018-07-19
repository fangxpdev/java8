package com.beidou.c2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author beidou
 * @since 18/7/18
 */
public class ReadFileTest {


    public static void main(String[] args) throws IOException {

        ReadFileTest test = new ReadFileTest();

        System.out.println(getFilePath("c2/data.txt"));

        String oneLine = processFile((BufferedReader br) -> br.readLine());
        System.out.println(oneLine);
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(twoLine);

        System.out.println(test.getPath("c2/data.txt"));

    }



    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(getFilePath("c2/data.txt")))) {
            return p.process(br);
        }
    }

    /**
     * 获取文件路径
     *
     * @param fileName
     * @return
     */
    public static String getFilePath(String fileName) {
        return ReadFileTest.class.getClassLoader().getResource(fileName).getPath();
    }


    private String getPath(String fileName) {
        System.out.println("clz=>"+getClass().toString());
        return getClass().getClassLoader().getResource(fileName).getPath();
    }

}

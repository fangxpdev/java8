package com.beidou.c2;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author beidou
 * @since 18/7/18
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader bufferedReader) throws IOException;

}

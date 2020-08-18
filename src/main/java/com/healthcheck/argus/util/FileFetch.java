package com.healthcheck.argus.util;

import java.io.IOException;

public class FileFetch {
    public static String getFile(String s) throws IOException {
        return new String(FileFetch.class
                .getClassLoader()
                .getResourceAsStream("healthcheck.yaml").readAllBytes());
    }
}

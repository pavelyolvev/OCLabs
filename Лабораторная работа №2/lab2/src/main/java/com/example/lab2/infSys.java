package com.example.lab2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


public class infSys {
    public long getSwap() throws IOException {
        Pattern pattern = Pattern.compile("([\\/A-Za-z0-9]+)[\\s]+([a-z]+)[\\s]+([0-9]+)[\\s]+([0-9]+)[\\s]+([\\-0-9]+).*");
        BufferedReader reader = new BufferedReader(new FileReader("/proc/swaps"));
        String s = reader.readLine();
        while (s != null) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) {
                System.out.println(s);
                return Long.parseLong(matcher.group(3)) * 1024L;
            }
            s = reader.readLine();
        }
        reader.close();
        return 0;
    }
}
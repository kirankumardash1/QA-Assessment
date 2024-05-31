package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public Properties prop;

    public Properties init_prop() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("test");
        prop.load(ip);
        return prop;
    }
}

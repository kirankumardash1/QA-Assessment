package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;
    public Properties init_prop() {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/Properties/config.properties");
            prop.load(ip);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }
    public void setProperty(String key, String value) throws IOException {
        init_prop();
        FileOutputStream out = new FileOutputStream("src/test/resources/Properties/config.properties");
        prop.setProperty(key, value);
        prop.store(out,null);
    }


}

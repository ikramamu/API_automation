package setup;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseSetup {


    private Properties properties;


    public BaseSetup() {
        String configPath = System.getProperty("user.dir") +
                "/src/test/resources/config.properties";
        properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get(configPath))) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file loading error
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }


    @Test
    public void test(){
        String str = "ikram";
        System.out.println(str.hashCode());
        str = "touqeer";
        System.out.println(str.hashCode());

        StringBuffer stb = new StringBuffer("ikram");
        System.out.println(stb.hashCode());
        stb = new StringBuffer("touqeer");
        System.out.println(stb.hashCode());

    }
}

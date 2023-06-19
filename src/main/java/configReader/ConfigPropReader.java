package configReader;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigPropReader {
    private Properties prop;
    private FileInputStream fis;

    public Properties initLangProp() {
        //mvn clean install -Dlang="french"
        String language = System.getProperty("lang");
        System.out.println("lang is: "+ language);
        prop = new Properties();
        try {
            switch (language) {
                case "english":
                    fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/lang.eng.properties");
                    break;
                case "french":
                    fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/lang.french.properties");
               break;
                default:
                    System.out.println("nothing");
                           }
            prop.load(fis);

        }catch (Exception e){
            System.out.println("error in reading prop file");
        }
       return prop;
    }

}

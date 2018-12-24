import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class PropertyManager {
    private final Object lock = new Object();
    private PropertyManager instance;
    private String propertyFilePath = "src/test/java/Config.properties";
    private String url;
    private String implicitWait;


    //Create a Singleton instance. We need only one instance of Property Manager.
    public PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();

        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        //Get properties from configuration.properties
        url = prop.getProperty("url");
        implicitWait = prop.getProperty("implicitWait");
    }

    public String ReturnBaseUrl(){
        if (url != null)
            return url;
        else throw new RuntimeException("url not specified in the Config.properties file.");
    }

    public Long ReturnImplicitWait(){
        if (implicitWait != null)
            return Long.parseLong(implicitWait);
        else throw new RuntimeException("implicitlyWait not specified in the Config.properties file.");
    }
}

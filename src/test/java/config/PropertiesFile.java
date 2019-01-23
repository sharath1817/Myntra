package config;

import Tests.TestNG;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop=new Properties();
    static String projectPath= System.getProperty("user.dir");
    public static void main(String args[]){
    getProperties();
    //setProperties();
    }
    public static void getProperties(){


        try {
            InputStream input=new FileInputStream(projectPath+"\\src\\main\\java\\config\\config.properties");
            prop.load(input);
            String browser=prop.getProperty("browser");
            String Username=prop.getProperty("Username");
            String Password=prop.getProperty("Password");
            System.out.println("........."+browser+" Browser is Loading..........");
            TestNG.browserName=browser;
            TestNG.Username=Username;
            TestNG.Password=Password;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void setProperties(){
        String projectPath= System.getProperty("user.dir");
        try {
            OutputStream output=new FileOutputStream(projectPath+"\\src\\main\\java\\config\\config.properties");
            prop.setProperty("browser","chrome");
            prop.store(output,"stored new browser name");
            String browser=prop.getProperty("browser");
            System.out.println(browser);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

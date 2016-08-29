package datapark.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dpliyuan on 2015/11/13.
 */
public class PropertiesUtil {

    private static Map propertyMap = new HashMap();

    public static Map getPropertyMap() {
        System.out.println(System.getProperty("user.dir"));
        File file = new File("./ConfigFiles/config.properties");

        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
                String[] pro = lineTxt.trim().split("@");
                propertyMap.put(pro[0], pro[1]);
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyMap;
    }

    public static void main(String[] args) {
//        PropertiesUtil.getPropertyMap();
//        PropertiesUtil.getProxyList();
    }

}
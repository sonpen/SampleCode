package ObjectMapperSample;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * Created by 1109806 on 2019-10-31.
 */
public class ObjectMapperSample {

    public static void main(String[] args) {
        System.out.println("---------------------- JSON String 을 MAP 으로 변환 -----------------------");
        ObjectMapper mapper = new ObjectMapper();

        String json = "{ \"name\" : \"ikju\", \"age\" : 20, \"message\" : [\"msg1\", \"msg2\", \"msg3\"] }";

        Map<String, Object> map = new HashMap<String,Object>();
        try {
            map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(map);
        System.out.println(map.get("name"));
        ArrayList arrayList = (ArrayList)map.get("message");
        System.out.println(arrayList.get(2));

        System.out.println("--------------------- MAP을 JSON String으로 변환 -----------------------");
        String json2 = "";
        try {
            //json2 = mapper.writeValueAsString(map);
            json2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json2);

        System.out.println("--------------------- MAP을 JSON String으로 변환후 파일에 쓰기 -----------------------");
        try {
            mapper.writeValue(new File("ObjectMapperSample.json"), map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------- JSON 파일을 읽어서 MAP으로 변환 -----------------------");
        try {
            Map<String, Object> map2 = mapper.readValue(new File("ObjectMapperSample.json"), new TypeReference<Map<String, Object>>() {});
            System.out.println(map2.get("name"));
            ArrayList<String> list = (ArrayList<String>)map.get("message");
            for(String msg : list) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------- class를 JSON String으로 변환 -----------------------");
        User user = new User("eunmi", 21, new ArrayList<String>(Arrays.asList("m1", "m2", "3")));
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(user);
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------- JSON String을 class로 변환 -----------------------");
        try {
            User user1 = mapper.readValue(jsonString, User.class);
            System.out.println(user.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

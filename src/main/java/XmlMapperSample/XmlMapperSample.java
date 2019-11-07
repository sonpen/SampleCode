package XmlMapperSample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by 1109806 on 2019-10-31.
 */
public class XmlMapperSample {

    public static void main(String[] args) {
        XmlMapper mapper = new XmlMapper();

        List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();

        HashMap<String, Object> map1 = new HashMap<String,Object>();
        map1.put("name", "ikju");
        map1.put("age", 20);
        map1.put("city", "seoul");
        list.add(map1);

        HashMap<String, Object> map2 = new HashMap<String,Object>();
        map2.put("name", "eunmi");
        map2.put("age", 21);
        map2.put("city", "pusan");
        list.add(map2);

        HashMap<String, Object> map3 = new HashMap<String,Object>();
        map3.put("name", "hyeunseung");
        map3.put("age", 10);
        map3.put("city", "wonju");
        list.add(map3);

        // Map을 xml string 으로 변환
        try {
            //String xmlString = mapper.writeValueAsString(map);
            String xmlString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println(xmlString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Map을 xml 파일로 쓰기
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("XmlMapperSample.xml"), list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // xml파일을 Map 으로 읽기
        try {
            List<HashMap<String,Object>> list1 = mapper.readValue(new File("XmlMapperSample.xml"), new TypeReference<List<HashMap<String,Object>>>() {});
            System.out.println(list1.get(0).get("name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

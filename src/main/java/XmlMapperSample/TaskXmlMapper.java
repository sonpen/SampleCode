package XmlMapperSample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1109806 on 2019-10-31.
 */
public class TaskXmlMapper {
    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<HashMap<String, String>> taskList = xmlMapper.readValue(new File("Task.xml"), new TypeReference<List<HashMap<String,String>>>() {});
            System.out.println("--------------> taskList\n" + taskList);
            System.out.println("--------------------------------------------------------------------------");

            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("TASK_LIST", taskList);
            System.out.println("--------------->JSON string\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map1));
            System.out.println("--------------------------------------------------------------------------");


            byte[] endcoded = Files.readAllBytes(Paths.get("Task.xml"));
            System.out.println(new String(endcoded));
            JSONObject jsonObject = XML.toJSONObject(new String(endcoded));
            System.out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package base.utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WorkingWithJson {

    private static String baseUrl = "src/test/resources/";

    public static JsonNode getResourcesFromJson(String relativePath) throws IOException {
        File file = new File(baseUrl + relativePath);
        String absolutePath = file.getAbsolutePath();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(absolutePath));
        return jsonNode;
    }
}

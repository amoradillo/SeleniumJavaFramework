package ave4testing.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.SequencedCollection;

public class DataReader {

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//ave4testing//data//PurchaseOrder.json"), StandardCharsets.UTF_8);

        // String to HashMap Jackson Data bid

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
        return data;
    }
}

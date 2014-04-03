package core.logic;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Bjørn on 30.03.2014.
 */
public class DateJSON {

    private static String
            ERROR_MESSAGE_CREATE_JSON = "Couldn't write JSON",
            ERROR_MESSAGE_DECODE_JSON = "Couldn't decode JSON";

    public static String createJSONString(List<Date> dates){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(dates);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_CREATE_JSON);
            return ERROR_MESSAGE_CREATE_JSON;
        }
    }

    public static String createJSONString(Date date){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(date);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_CREATE_JSON);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_CREATE_JSON);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_CREATE_JSON);
        }
        return ERROR_MESSAGE_CREATE_JSON;
    }

    public static File writeJSONFile(File file, List<Date> dates){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, dates);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_CREATE_JSON);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_CREATE_JSON);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_CREATE_JSON);
        }
        return file;
    }

    public static List<Date> decodeDateListJSON(String jsonDateList){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference ref = new TypeReference<List<Date>>(){};
        List<Date> dates = null;
        try {
            dates = mapper.readValue(jsonDateList, ref);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_DECODE_JSON);
        }
        return dates;
    }

    public static Date decodeDateJSON(String jsonDate){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference ref = new TypeReference<Date>(){};
        Date date = new Date();
        try {
            date = mapper.readValue(jsonDate, ref);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_DECODE_JSON);
        } catch (JsonParseException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_DECODE_JSON);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_DECODE_JSON);
        }
        return date;
    }

    public static List<Date> decodeJSON(File file){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference ref = new TypeReference<List<Date>>(){};
        List<Date> dates = null;
        try {
            dates = mapper.readValue(file, ref);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_DECODE_JSON);
        } catch (JsonParseException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_DECODE_JSON);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(ERROR_MESSAGE_DECODE_JSON);
        }
        return dates;
    }
}

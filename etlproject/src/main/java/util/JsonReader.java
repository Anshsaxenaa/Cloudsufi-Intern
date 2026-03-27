package util;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Employee;

public class JsonReader {
    public static List<Employee> readJson(String filename) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), new TypeReference<List<Employee>>() {
        });
    }

}

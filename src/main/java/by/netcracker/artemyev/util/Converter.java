package by.netcracker.artemyev.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public class Converter {
    private static Gson gson = new Gson();

    public static List<Long> fromWebJson(String jsonLine) {
        String idLine = jsonLine.replaceAll("undefined","");
        Type type = new TypeToken<Collection<Long>>(){}.getType();
        List<Long> list = new ArrayList<>();
        list = gson.fromJson(idLine, type);
        return list;
    }

    public static String toJson(List<Long> list) {
        String jsonLine = null;
        jsonLine = gson.toJson(list);
        return jsonLine;
    }


}

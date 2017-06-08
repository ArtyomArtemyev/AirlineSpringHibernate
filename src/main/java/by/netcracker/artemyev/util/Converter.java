package by.netcracker.artemyev.util;

import by.netcracker.artemyev.constant.LoggingName;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class describes converter for different types
 *
 * @autor Artemyev Artoym
 */
public final class Converter {
    private static Logger logger = LogManager.getLogger(Converter.class);
    private static Gson gson = new Gson();

    /**
     * Converts json line with id to list with id
     *
     * @param line - line with id
     * @return - list with id
     */
    public static List<Long> convertToList(String line) {
        logger.debug(LoggingName.FUNCTION_CONVERSION_TO_LIST);
        String idLine = line.replaceAll("undefined","");
        Type type = new TypeToken<Collection<Long>>(){}.getType();
        List<Long> list = new ArrayList<>();
        list = gson.fromJson(idLine, type);
        return list;
    }

    /**
     * Converts list with id to json line with id
     *
     * @param list - list with id
     * @return - line with id
     */
    public static String convertToLine(List<Long> list) {
        logger.debug(LoggingName.FUNCTION_CONVERSION_TO_LINE);
        String line = null;
        line = gson.toJson(list);
        return line;
    }

}

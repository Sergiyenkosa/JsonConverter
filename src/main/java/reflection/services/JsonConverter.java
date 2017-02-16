package reflection.services;

import reflection.annotations.CustomDateFormat;

import java.lang.reflect.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.reflect.Modifier.STATIC;

/**
 * Created by s.sergienko on 22.12.2016.
 */
public class JsonConverter {
    private final static Map<String, String> charsMap = new HashMap<>();
    static {
        charsMap.put("\"", "\"");
        charsMap.put("/", "/");
        charsMap.put("b", "\b");
        charsMap.put("f", "\f");
        charsMap.put("n", "\n");
        charsMap.put("r", "\r");
        charsMap.put("t", "\t");
    }

    public static String toJson(Object o) throws NoSuchMethodException, IllegalAccessException {
        if (o == null){
            return "";
        } else if (o instanceof String) {
            return  convertToJsonString(o.toString());
        } else if (o instanceof Boolean || o instanceof Character || o instanceof Number) {
            return o instanceof Character ?
                    convertToJsonString(o.toString()) : o.toString();
        } else if (o.getClass().isArray()) {
            return convertToJsonArray(o);
        } else if (o instanceof LocalDate){
            return "\"" + o.toString() + "\"";
        } else {
            o.getClass().getConstructor();//check for default constructor

            return convertToJsonObject(o);
        }
    }

    public static Object fromJson(String json, Class<?> clazz)
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        if (json.startsWith("{") || json.startsWith("[")) {
            if (json.matches("^.*?[:\\[]\"(([\\\\]{2})*?|(.*?[^\\\\]([\\\\]{2})*?))\".*?$")) {
                json = convertToEaseParsingJsonWithStrings(json, "\n");
            } else {
                json = convertToEaseParsingJsonWithoutStrings(json, "\n");
            }
        }

        return fromJsonRecursion(json, clazz);
    }

    public static String convertJsonToReadableView(String json) {
        return convertToEaseParsingJsonWithStrings(json, System.lineSeparator());
    }

    private static Object fromJsonRecursion(String json, Class<?> clazz)
            throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        json = json.replaceAll("^[\"\\[{]", "").replaceAll("[\"\\]}]$", "");

        if (clazz == String.class) {
            return convertToOriginalString(json);
        } else if (ClassHandler.isTypePrimitiveOrPrimitiveWrapper(clazz)) {
            if (clazz == char.class || clazz == Character.class)
                json = convertToOriginalString(json);

            return convertToOriginalPrimitiveOrWrapper(json, clazz);
        } else if (clazz.isArray()) {
            return convertToOriginalArray(json, clazz.getComponentType());
        } else if (clazz == LocalDate.class) {
            return LocalDate.parse(json);
        } else {
            Object instance = clazz.newInstance();

            return convertToOriginalJsonObject(json, instance);
        }
    }

    private static String convertToEaseParsingJsonWithStrings(String json, String separator) {
        Map<String, String> stringsMap = new TreeMap<>();

        Pattern pattern = Pattern.compile("(?<=[:\\[])\"(([\\\\]{2})*?|(.*?[^\\\\]([\\\\]{2})*?))\"");//find oll strings ore chars in json
        Matcher matcher = pattern.matcher(json);

        while (matcher.find()){
            final String mapKey = "/" + stringsMap.size() + "/";

            stringsMap.put(mapKey, matcher.group());

            json = json.replaceFirst(pattern.pattern(), mapKey);

            matcher = pattern.matcher(json);
        }

        json = convertToEaseParsingJsonWithoutStrings(json, separator);

        for (Map.Entry<String, String> entry : stringsMap.entrySet()) {
            json = json.replace(entry.getKey(), entry.getValue());
        }

        return json;
    }

    private static String convertToEaseParsingJsonWithoutStrings(String json, String separator) {
        Pattern pattern = Pattern.compile("((\\{|\\[|(?<![}|\\]]),)|(\t?(}(?!,)|},|](?!,)|],)))(?!" + separator + ")");
        Matcher matcher = pattern.matcher(json);

        StringBuilder tabs = new StringBuilder();

        while (matcher.find()){
            String s = matcher.group();

            if (s.matches("[{\\[]")) {
                tabs.append("\t");
                json = json.replaceFirst(pattern.pattern(), s + separator + tabs);
            } else if (s.matches("(?<![}\\]]),")) {
                json = json.replaceFirst(pattern.pattern(), s + separator + tabs);
            }else if (s.matches("(\t)[}\\]],?")){
                tabs = new StringBuilder(tabs.toString().replaceFirst("\t", ""));
                json = json.replaceFirst(pattern.pattern(), s.substring(1) + separator + tabs);
            } else {
                tabs = new StringBuilder(tabs.toString().replaceFirst("\t", ""));
                json = json.replaceFirst(pattern.pattern(), separator + tabs + s + separator + tabs);
            }

            matcher = pattern.matcher(json);
        }

        return json.substring(0, json.length() - separator.length()).replaceAll(":", ": ");
    }

    private static String convertToJsonString(String originalString) {
        return "\"" + originalString.replaceAll("\\\\", "\\\\\\\\").
                replaceAll("\"", "\\\\\"").replaceAll("/", "\\\\/").
                replaceAll("\b", "\\\\b").replaceAll("\f", "\\\\f").
                replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").
                replaceAll("\t", "\\\\t") + "\"";
    }

    private static String convertToOriginalString(String jsonString) {
        for (Map.Entry<String, String> entry : charsMap.entrySet()) {
            Pattern p = Pattern.compile("(^|^.*[^\\\\])(\\\\{2})*\\\\"+entry.getKey());//it was 4:51am :)
            Matcher m = p.matcher(jsonString);

            while (m.find()){
                String pattern = m.group();
                jsonString = jsonString.replace(pattern, pattern.substring(0, pattern.length()-2) + entry.getValue());
                m = p.matcher(jsonString);
            }
        }

        return jsonString.replaceAll("\\\\\\\\", "\\\\");
    }

    private static Object convertToOriginalPrimitiveOrWrapper(String jsonValueString, Class<?> type) {
        if (type == boolean.class || type == Boolean.class) {
            return Boolean.valueOf(jsonValueString);
        } else if (type == char.class || type == Character.class) {
            return jsonValueString.charAt(0);
        } else if (type == byte.class || type == Byte.class) {
            return Byte.valueOf(jsonValueString);
        } else if (type == short.class || type == Short.class) {
            return Short.valueOf(jsonValueString);
        } else if (type == int.class || type == Integer.class) {
            return Integer.valueOf(jsonValueString);
        } else if (type == long.class || type == Long.class) {
            return Long.valueOf(jsonValueString);
        } else if (type == float.class || type == Float.class) {
            return Float.valueOf(jsonValueString);
        } else if (type == double.class || type == Double.class) {
            return Double.valueOf(jsonValueString);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static String convertToJsonObject(Object o) throws NoSuchMethodException, IllegalAccessException {
        StringBuilder jsonResult = new StringBuilder("{");

        for (Map.Entry<String, Field> entry : FieldsHandler.getDeclaredFieldsMap(o).entrySet()) {
            Field field = entry.getValue();
            Object objectValue = field.get(o);

            if (objectValue != null && (field.getModifiers() & STATIC) != STATIC &&
                    !field.getType().isInterface() && !field.getType().isAnonymousClass() &&
                    !field.getType().isMemberClass()) {
                String stringValue;
                CustomDateFormat customDateFormat;

                if (field.getType() == LocalDate.class &&
                        (customDateFormat = field.getAnnotation(CustomDateFormat.class)) != null) {
                    LocalDate localDate = (LocalDate) objectValue;
                    String customLocalDate = localDate.format(DateTimeFormatter.ofPattern(customDateFormat.format()));

                    stringValue = "\"" + customLocalDate + "\"";
                } else {
                    stringValue = toJson(objectValue);
                }

                jsonResult.append(String.format("\"%s\":%s,", entry.getKey(), stringValue));
            }
        }

        return jsonResult.toString().endsWith(",") ? jsonResult.substring(0, jsonResult.length()-1) + "}" : jsonResult + "}";
    }

    private static Object convertToOriginalJsonObject(String json, Object instance)
            throws IllegalAccessException, NoSuchMethodException,
            InstantiationException, InvocationTargetException {
        if (json.length() > 1) {
            String[] stringFields = json.substring(3, json.length()-1).split(",\n\t\"");
            Map<String, Field> fieldsMap = FieldsHandler.getDeclaredFieldsMap(instance);

            for (String stringField : stringFields) {
                Field field = fieldsMap.get(stringField.substring(0, stringField.indexOf("\"")));
                String fieldValue = stringField.substring(stringField.indexOf(" ")+1).replaceAll("\n\t", "\n");
                CustomDateFormat customDateFormat;

                if (field.getType() == LocalDate.class &&
                        (customDateFormat = field.getAnnotation(CustomDateFormat.class)) != null) {
                    fieldValue = fieldValue.replaceAll("^\"", "").replaceAll("\"$", "");

                    LocalDate localDate = LocalDate.parse(fieldValue, DateTimeFormatter.ofPattern(customDateFormat.format()));

                    field.set(instance, localDate);
                } else {
                    field.set(instance, fromJsonRecursion(fieldValue, field.getType()));
                }
            }
        }

        return instance;
    }

    private static String convertToJsonArray(Object o) throws NoSuchMethodException, IllegalAccessException {
        StringBuilder jsonResult = new StringBuilder("[");

        for (int i = 0;i < Array.getLength(o); i++) {
            String insert = toJson(Array.get(o, i));
            insert = insert.equals("") ? "null" : insert;

            jsonResult.append(insert).append(",");
        }

        return jsonResult.toString().endsWith(",") ? jsonResult.substring(0, jsonResult.length()-1) + "]": jsonResult + "]";
    }

    private static Object convertToOriginalArray(String json, Class<?> type)
            throws IllegalAccessException, NoSuchMethodException,
            InstantiationException, InvocationTargetException {

        if (json.length() > 1) {
            json = json.substring(2, json.length()-1).replaceAll("\n\t", "\n");
        } else {
            return Array.newInstance(type, 0);
        }

        String[] stringValues = type.isArray() ? json.split("(\\],\n\\[)") : json.split(",\n(?=[^\t])");//it was 2:26am :)
        Object instance = Array.newInstance(type, stringValues.length);

        for (int i = 0; i < stringValues.length; i++) {
            if (!stringValues[i].equals("null")) {
                Array.set(instance, i, fromJsonRecursion(stringValues[i], type));
            }
        }

        return instance;
    }
}

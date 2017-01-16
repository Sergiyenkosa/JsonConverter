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
    public static String toJson(Object o) throws NoSuchMethodException, IllegalAccessException {
        if (o == null){
            return "";
        }
        else if (o instanceof String) {
            return  convertToJsonString(o.toString());
        }
        else if (o instanceof Boolean || o instanceof Character || o instanceof Number) {
            return o instanceof Character ?
                    convertToJsonString(o.toString()).replaceAll("^\"", "'").replaceAll("\"$", "'") : o.toString();
        }
        else if (o.getClass().isArray()) {
            return convertToJsonArray(o);
        }
        else if (o instanceof LocalDate){
            return "\"" + o.toString() + "\"";
        }
        else {
            o.getClass().getConstructor();//check for default constructor

            return convertToJsonObject(o);
        }
    }

    public static Object fromJson(String json, Class<?> clazz)
            throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        json = json.replaceAll("^(\"|\'|\\[|\\{)", "").replaceAll("(\"|\'|\\]|\\})$", "");

        if (clazz == String.class) {
            return convertToOriginalString(json);
        }
        else if (ClassHandler.isTypePrimitiveOrPrimitiveWrapper(clazz)) {
            if (clazz == char.class || clazz == Character.class)
                json = convertToOriginalString(json);

            return convertToOriginalPrimitiveOrWrapper(json, clazz);
        }
        else if (clazz.isArray()) {
            return convertToOriginalArray(json, clazz.getComponentType());
        }
        else if (clazz == LocalDate.class) {
            return LocalDate.parse(json);
        }
        else {
            Object instance = clazz.newInstance();

            return convertToOriginalJsonObject(json, instance);
        }
    }

    private static String convertToJsonString(String originalString) {
        return "\"" + originalString.replaceAll("\\\\", "\\\\\\\\").
                replaceAll("\"", "\\\\\"").replaceAll("/", "\\\\/").
                replaceAll("\b", "\\\\b").replaceAll("\f", "\\\\f").
                replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").
                replaceAll("\t", "\\\\t") + "\"";
    }

    private static String convertToOriginalString(String jsonString) {
        Map<String, String> charsMap = new HashMap<>();
        charsMap.put("\"", "\"");
        charsMap.put("/", "/");
        charsMap.put("b", "\b");
        charsMap.put("f", "\f");
        charsMap.put("n", "\n");
        charsMap.put("r", "\r");
        charsMap.put("t", "\t");

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
        if (type == boolean.class || type == Boolean.class)
            return Boolean.valueOf(jsonValueString);
        else if (type == char.class || type == Character.class)
            return jsonValueString.charAt(0);
        else if (type == byte.class || type == Byte.class)
            return Byte.valueOf(jsonValueString);
        else if (type == short.class || type == Short.class)
            return Short.valueOf(jsonValueString);
        else if (type == int.class || type == Integer.class)
            return Integer.valueOf(jsonValueString);
        else if (type == long.class || type == Long.class)
            return Long.valueOf(jsonValueString);
        else if (type == float.class || type == Float.class)
            return Float.valueOf(jsonValueString);
        else if (type == double.class || type == Double.class)
            return Double.valueOf(jsonValueString);
        else
            throw new IllegalArgumentException();
    }

    private static String convertToJsonObject(Object o) throws NoSuchMethodException, IllegalAccessException {
        String jsonResult = "{";

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
                }
                else {
                    stringValue = toJson(objectValue).replace("\n\t", "\n\t\t").replace("\n}", "\n\t}").replace("\n]", "\n\t]");
                }

                jsonResult += String.format("\n\t\"%s\": %s,", entry.getKey(), stringValue);
            }
        }

        return jsonResult.endsWith(",") ? jsonResult.substring(0, jsonResult.length()-1) + "\n}" : jsonResult + "\n}";
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
                }
                else {
                    field.set(instance, fromJson(fieldValue, field.getType()));
                }
            }
        }

        return instance;
    }

    private static String convertToJsonArray(Object o) throws NoSuchMethodException, IllegalAccessException {
        String jsonResult = "[";

        for (int i = 0;i < Array.getLength(o); i++) {
            String insert = toJson(Array.get(o, i));
            insert = insert.equals("") ? "null" : insert;

            jsonResult += "\n\t" + insert.replace("\n\t", "\n\t\t").replace("\n]", "\n\t]").replace("\n}", "\n\t}") + ",";
        }

        return jsonResult.endsWith(",") ? jsonResult.substring(0, jsonResult.length()-1) + "\n]": jsonResult + "\n]";
    }

    private static Object convertToOriginalArray(String json, Class<?> type)
            throws IllegalAccessException, NoSuchMethodException,
            InstantiationException, InvocationTargetException {

        if (json.length() > 1)
            json = json.substring(2, json.length()-1).replaceAll("\n\t", "\n");
        else
            return Array.newInstance(type, 0);

        String[] stringValues = type.isArray() ? json.split("(\\],\n\\[)") : json.split(",\n(?=[^\t])");//it was 2:26am :)
        Object instance = Array.newInstance(type, stringValues.length);

        for (int i = 0; i < stringValues.length; i++) {
            if (!stringValues[i].equals("null"))
                Array.set(instance, i, fromJson(stringValues[i], type));
        }

        return instance;
    }
}

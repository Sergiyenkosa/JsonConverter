package reflection.services;

import reflection.annotations.CustomDateFormat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.reflect.Modifier.STATIC;

/**
 * Created by s.sergienko on 22.12.2016.
 */
public class JsonConverter {
    public static String toJson(Object o) throws NoSuchMethodException, IllegalAccessException {
        o.getClass().getDeclaredConstructor();//check for default constructor

        Map<String, Field> fieldsMap = FieldsHandler.getDeclaredFieldsMap(o);
        String jsonResult = "{";

        for (Map.Entry<String, Field> entry : fieldsMap.entrySet()) {
            Field field = entry.getValue();
            Object objectValue = field.get(o);

            if (objectValue != null && (field.getModifiers() & STATIC) != STATIC &&
                    !field.getType().isInterface() && !field.getType().isAnonymousClass() &&
                    !field.getType().isMemberClass() && !field.getType().isArray()) {
                String stringValue;

                if (field.getType() == String.class) {
                    stringValue = "\"" + convertToJsonString(objectValue.toString()) + "\"";
                }
                else if (FieldsHandler.isFieldPrimitiveOrPrimitiveWrapper(field)) {
                    stringValue = objectValue instanceof Character ?
                            "'" + convertToJsonString(objectValue.toString()) + "'" : objectValue.toString();
                }
                else if (field.getType() == LocalDate.class){
                    CustomDateFormat customDateFormat = field.getAnnotation(CustomDateFormat.class);

                    stringValue = "\"" + convertToJsonLocalDate((LocalDate)objectValue, customDateFormat) + "\"";
                }
                else {
                    stringValue = toJson(objectValue).replace("\n\t", "\n\t\t").replace("\n}", "\n\t}");
                }

                jsonResult += String.format("\n\t\"%s\": %s,", entry.getKey(), stringValue);
            }
        }

        return jsonResult.endsWith(",") ? jsonResult.substring(0, jsonResult.length()-1) + "\n}" : jsonResult + "\n}";
    }

    public static Object fromJson(String json, Class<?> clazz)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        Object instance = constructor.newInstance();

        if (json.length() > 3) {
            String[] stringFields = json.substring(4, json.length()-2).split(",\n\t\"");
            Map<String, Field> fieldsMap = FieldsHandler.getDeclaredFieldsMap(instance);

            for (String stringField : stringFields) {
                Field field = fieldsMap.get(stringField.substring(0, stringField.indexOf("\"")));
                String fieldValue = stringField.substring(stringField.indexOf(" ")+1).
                        replaceAll("^(\"|\')", "").replaceAll("(\"|\')$", "").replaceAll("\n\t", "\n");

                if (field.getType() == String.class) {
                    field.set(instance, convertToOriginalString(fieldValue));
                }
                else if (FieldsHandler.isFieldPrimitiveOrPrimitiveWrapper(field)) {
                    if (field.getType() == char.class || field.getType() == Character.class)
                        fieldValue = convertToOriginalString(fieldValue);

                    field.set(instance, convertToOriginalPrimitiveOrWrapper(fieldValue, field.getType()));
                }
                else if (field.getType() == LocalDate.class) {
                    CustomDateFormat customDateFormat = field.getAnnotation(CustomDateFormat.class);

                    field.set(instance, convertToOriginalLocalDate(fieldValue, customDateFormat));
                }
                else {
                    field.set(instance, fromJson(fieldValue, field.getType()));
                }
            }

            return instance;
        }
        else {
            return instance;
        }
    }

    private static String convertToJsonString(String originalString) {
        return originalString.replaceAll("\\\\", "\\\\\\\\").
                replaceAll("\"", "\\\\\"").replaceAll("\b", "\\\\b").
                replaceAll("\n", "\\\\n").replaceAll("\t", "\\\\t").
                replaceAll("\r", "\\\\r");
    }

    private static String convertToOriginalString(String jsonString) {
        Map<String, String> charsMap = new HashMap<>();
        charsMap.put("b", "\b");
        charsMap.put("n", "\n");
        charsMap.put("t", "\t");
        charsMap.put("r", "\r");
        charsMap.put("\"", "\"");

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

    private static String convertToJsonLocalDate(LocalDate localDate, CustomDateFormat customDateFormat) {
        if (customDateFormat != null)
            return localDate.format(DateTimeFormatter.ofPattern(customDateFormat.format()));
        else
            return localDate.toString();
    }

    private static LocalDate convertToOriginalLocalDate(String localDateString, CustomDateFormat customDateFormat) {
        if (customDateFormat != null)
            return LocalDate.parse(localDateString, DateTimeFormatter.ofPattern(customDateFormat.format()));
        else
            return LocalDate.parse(localDateString);
    }
}

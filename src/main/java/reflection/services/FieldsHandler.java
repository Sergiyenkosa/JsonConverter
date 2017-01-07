package reflection.services;

import reflection.annotations.JsonValue;
import reflection.exceptions.TheSameFieldAndJsonValueNamesInDifferentFieldsException;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by s.sergienko on 22.12.2016.
 */
public class FieldsHandler {
    public static Map<String, Field> getDeclaredFieldsMap(Object o) {
        Map<String, Field> jsonFieldsMap = new HashMap<>();

        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            JsonValue jsonValue = field.getAnnotation(JsonValue.class);
            String name = jsonValue != null ? jsonValue.name() : field.getName();

            if (jsonFieldsMap.containsKey(name))
                throw new TheSameFieldAndJsonValueNamesInDifferentFieldsException(o.getClass(), name);
            else
                jsonFieldsMap.put(name, field);
        }

        return jsonFieldsMap;
    }

    public static boolean isFieldPrimitiveOrPrimitiveWrapper(Field field) {
        Class type = field.getType();

        return type.isPrimitive() || type == Boolean.class ||
                type == Character.class || type == Byte.class ||
                type == Short.class || type == Integer.class ||
                type == Long.class || type == Float.class ||
                type == Double.class;
    }
}

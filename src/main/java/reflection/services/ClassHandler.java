package reflection.services;

/**
 * Created by Lubov on 08.01.2017.
 */
public class ClassHandler {
    public static boolean isTypePrimitiveOrPrimitiveWrapper(Class type) {
        return type.isPrimitive() || type == Boolean.class ||
                type == Character.class || type == Byte.class ||
                type == Short.class || type == Integer.class ||
                type == Long.class || type == Float.class ||
                type == Double.class;
    }
}

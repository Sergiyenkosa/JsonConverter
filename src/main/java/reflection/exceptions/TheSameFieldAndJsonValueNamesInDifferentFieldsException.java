package reflection.exceptions;

import java.util.Set;

/**
 * Created by s.sergienko on 22.12.2016.
 */
public class TheSameFieldAndJsonValueNamesInDifferentFieldsException extends RuntimeException{
    public TheSameFieldAndJsonValueNamesInDifferentFieldsException(Class objectClass, String sameName) {
        super(String.format("Class: %s, Name: %s", objectClass.getName(), sameName));
    }
}

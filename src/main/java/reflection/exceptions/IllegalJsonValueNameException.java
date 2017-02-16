package reflection.exceptions;

/**
 * Created by s.sergienko on 16.02.2017.
 */
public class IllegalJsonValueNameException extends RuntimeException{
    public IllegalJsonValueNameException(Class objectClass, String illegalName) {
        super(String.format("Class: %s, Name: %s", objectClass.getName(), illegalName));
    }
}

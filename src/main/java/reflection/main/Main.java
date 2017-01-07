package reflection.main;

import reflection.exampleClasses.*;
import reflection.exceptions.TheSameFieldAndJsonValueNamesInDifferentFieldsException;
import reflection.services.JsonConverter;

import java.time.LocalDate;
import java.util.Date;


/**
 * Created by s.sergienko on 20.12.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DateAndLocalDate dateAndLocalDate = new DateAndLocalDate();
        dateAndLocalDate.setLd1(LocalDate.of(1111, 1, 1));
        dateAndLocalDate.setLd2(LocalDate.of(3333, 3, 3));
        dateAndLocalDate.setDate(new Date(1));

        Empty empty = new Empty();

        Merge1 merge1 = new Merge1();
        merge1.setDateAndLocalDate(dateAndLocalDate);
        merge1.setEmpty(empty);

        Primitives primitives = new Primitives();
        primitives.setPrimitiveBoolean(true);
        primitives.setPrimitiveChar('\n');
        primitives.setPrimitiveByte((byte) 1);
        primitives.setPrimitiveShort((short) 2);
        primitives.setPrimitiveInt(3);
        primitives.setPrimitiveLong(4);
        primitives.setPrimitiveFloat((float) 1.1);
        primitives.setPrimitiveDouble(1.2);

        PrimitiveWrappers primitiveWrappers = new PrimitiveWrappers();
        primitiveWrappers.setWrapperBoolean(true);
        primitiveWrappers.setWrapperChar('\b');
        primitiveWrappers.setWrapperByte((byte) 5);
        primitiveWrappers.setWrapperShort((short) 6);
        primitiveWrappers.setWrapperInt(7);
        primitiveWrappers.setWrapperLong(8L);
        primitiveWrappers.setWrapperFloat((float) 1.3);
        primitiveWrappers.setWrapperDouble(1.4);

        Merge2 merge2 = new Merge2();
        merge2.setPrimitives(primitives);
        merge2.setPrimitiveWrappers(primitiveWrappers);

        Strings strings = new Strings();
        strings.setString1("assgsg\"\"'}\\$\n\n\n\\\\\b");
        strings.setString3("dfgdfg\n\b\r\txxdfg");

        Nulls nulls = new Nulls();

        Merge3 merge3 = new Merge3();
        merge3.setStrings(strings);
        merge3.setNulls(nulls);

        merge1.setMerge2(merge2);
        merge2.setMerge3(merge3);

        String jsonMarge = JsonConverter.toJson(merge1);

        System.out.println("jsonMarge == \n" + jsonMarge);

        Merge1 margeCopy = (Merge1) JsonConverter.fromJson(jsonMarge, Merge1.class);

        String jsonMargeCopy = JsonConverter.toJson(margeCopy);

        System.out.println("jsonMargeCopy == \n" + jsonMargeCopy);

        System.out.println("Equals jsonMarge & jsonMargeCopy = " + jsonMarge.equals(jsonMargeCopy) + "!!! :)");

        TheSameNames theSameNames = new TheSameNames();

        try {
            JsonConverter.toJson(theSameNames);
        }
        catch (TheSameFieldAndJsonValueNamesInDifferentFieldsException e) {
            System.out.println("Checking exception: " + e);
        }
    }
}

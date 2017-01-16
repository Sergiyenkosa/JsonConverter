package reflection.main;

import reflection.exampleClasses.*;
import reflection.exceptions.TheSameFieldAndJsonValueNamesInDifferentFieldsException;
import reflection.services.JsonConverter;

import java.time.LocalDate;
import java.util.*;


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
        strings.setString1("ass//gs\fg\"\"'}\\$\n\n\n\\\\\b");
        strings.setString3("dfgdfg\n\b\r\txxdfg");

        Nulls nulls = new Nulls();

        Merge3 merge3 = new Merge3();
        merge3.setStrings(strings);
        merge3.setNulls(nulls);

        merge2.setMerge3(merge3);

        merge1.setMerge2(merge2);

        DifferentArrays differentArrays = new DifferentArrays();

        Merge2[] objectMerge2s = new Merge2[1];
        objectMerge2s[0] = merge2;

        Merge3[][] objectMerge3s = new Merge3[1][2];
        objectMerge3s[0][0] = merge3;
        objectMerge3s[0][1] = merge3;

        LocalDate[][][] objectLocaleDates = new LocalDate[1][2][3];
        objectLocaleDates[0][0][0] = LocalDate.MIN;

        String[] strings1 = new String[2];
        strings1[1] = "";

        String[][] strings2 = new String[2][1];
        strings2[1][0] = "\"fgsgergergw3fg\f\"";

        int[] primitiveInts = new int[3];
        primitiveInts[2] = 1;

        float[][] primitiveFloats = new float[3][2];
        primitiveFloats[2][1] = Float.MIN_VALUE;
        primitiveFloats[1][0] = Float.MAX_VALUE;

        char[][][] primitiveChars = new char[3][2][1];
        primitiveChars[0][0][0] = 'a';
        primitiveChars[1][1][0] = 'b';
        primitiveChars[2][1][0] = 'c';

        boolean[][][][] primitivesBoolean = new boolean[4][3][2][1];
        primitivesBoolean[2][2][1][0] = true;

        Long[][][][] wrapperLongs = new Long[3][3][3][3];
        wrapperLongs[2][2][2][2] = 3L;

        Double[][][] wrapperDoubles = new Double[5][5][5];
        wrapperDoubles[0][0][0] = Double.MIN_VALUE;
        wrapperDoubles[2][2][2] = 0.0;
        wrapperDoubles[4][4][4] = Double.MAX_VALUE;

        Character[][] wrapperCharacters = new Character[1][3];
        wrapperCharacters[0][2] = '1';

        Boolean [] wrapperBooleans = new Boolean[3];
        wrapperBooleans[1] = false;

        Object [][][] emptyArray = new Object[0][1][2];

        differentArrays.setObjectMerge2s(objectMerge2s);
        differentArrays.setObjectMerge3s(objectMerge3s);
        differentArrays.setObjectLocaleDates(objectLocaleDates);
        differentArrays.setStrings1(strings1);
        differentArrays.setStrings2(strings2);
        differentArrays.setPrimitiveInts(primitiveInts);
        differentArrays.setPrimitiveFloats(primitiveFloats);
        differentArrays.setPrimitiveChars(primitiveChars);
        differentArrays.setPrimitivesBoolean(primitivesBoolean);
        differentArrays.setWrapperLongs(wrapperLongs);
        differentArrays.setWrapperDoubles(wrapperDoubles);
        differentArrays.setWrapperCharacters(wrapperCharacters);
        differentArrays.setWrapperBooleans(wrapperBooleans);
        differentArrays.setEmptyArray(emptyArray);

        merge1.setDifferentArrays(differentArrays);

        String jsonMarge = JsonConverter.toJson(merge1);
        System.out.println("_________________________ jsonMarge == _________________________\n" + jsonMarge);

        Thread.sleep(100);//for check private final String string2; (new Date().getTime()) in Strings class

        Merge1 marge1Copy = (Merge1) JsonConverter.fromJson(jsonMarge, Merge1.class);

        System.out.println("___ Equals merge1 & marge1Copy == " + merge1.equals(marge1Copy) + "!!! :) ___");

        TheSameNames theSameNames = new TheSameNames();
        try {
            JsonConverter.toJson(theSameNames);
        }
        catch (TheSameFieldAndJsonValueNamesInDifferentFieldsException e) {
            System.out.println("___ Check exception == " + e + " ___");
        }
    }
}

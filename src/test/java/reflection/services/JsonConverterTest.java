package reflection.services;

import org.junit.Assert;
import org.junit.Test;
import reflection.services.exampleClasses.*;
import reflection.exceptions.TheSameFieldAndJsonValueNamesInDifferentFieldsException;

import java.time.LocalDate;
import java.util.Date;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * Created by s.sergienko on 01.02.2017.
 */
public class JsonConverterTest {

    @Test
    public void convertBooleanToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson(true), is("true"));
    }

    @Test
    public void createPrimitiveBooleanFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("false", boolean.class), is(false));
    }

    @Test
    public void createWrapperBooleanFromJsonTest() throws Exception {
        Assert.assertSame((Boolean)JsonConverter.fromJson("true", Boolean.class), true);
    }

    @Test
    public void convertCharToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson('\f'), is("'\\f'"));
    }

    @Test
    public void createPrimitiveCharFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("'\\r'", char.class), is('\r'));
    }

    @Test
    public void createWrapperCharFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("'\\n'", Character.class), is('\n'));
    }

    @Test
    public void convertByteToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson((byte)0), is("0"));
    }

    @Test
    public void createPrimitiveByteFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("1", byte.class), is((byte)1));
    }

    @Test
    public void createWrapperByteFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("2", Byte.class), is((byte)2));
    }

    @Test
    public void convertShortToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson((short)3), is("3"));
    }

    @Test
    public void createPrimitiveShortFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("4", short.class), is((short)4));
    }

    @Test
    public void createWrapperShortFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("5", Short.class), is((short)5));
    }

    @Test
    public void convertIntToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson(6), is("6"));
    }

    @Test
    public void createPrimitiveIntFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("7", int.class), is(7));
    }

    @Test
    public void createWrapperIntFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("8", Integer.class), is(8));
    }

    @Test
    public void convertLongToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson((long)9), is("9"));
    }

    @Test
    public void createPrimitiveLongFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("10", long.class), is((long)10));
    }

    @Test
    public void createWrapperLongFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("11", Long.class), is((long)11));
    }

    @Test
    public void convertFloatToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson((float)12), is("12.0"));
    }

    @Test
    public void createPrimitiveFloatFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("13.1", float.class), is((float)13.1));
    }

    @Test
    public void createWrapperFloatFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("14.2", Float.class), is((float)14.2));
    }

    @Test
    public void convertDoubleToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson(15.3), is("15.3"));
    }

    @Test
    public void createPrimitiveDoubleFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("16.4", double.class), is(16.4));
    }

    @Test
    public void createWrapperDoubleFromJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.fromJson("17.5", Double.class), is(17.5));
    }

    @Test
    public void convertPrimitivesArrayToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson(new int[]{1,2,3}), is("[\n\t1,\n\t2,\n\t3\n]"));
    }

    @Test
    public void createPrimitivesArrayFromJsonTest() throws Exception {
        Assert.assertArrayEquals((boolean[]) JsonConverter.fromJson(
                "[\n\ttrue,\n\tfalse,\n\ttrue\n]", boolean[].class), new boolean[]{true,false,true});
    }

    @Test
    public void convertWrappersMultidimensionalArrayToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson(new Double[][]{{5.5, 3.3}, {1.1}}),
                is("[\n\t[\n\t\t5.5,\n\t\t3.3\n\t],\n\t[\n\t\t1.1\n\t]\n]"));
    }

    @Test
    public void createWrappersMultidimensionalArrayFromJsonTest() throws Exception {
        Assert.assertArrayEquals((Character[]) JsonConverter.fromJson(
                "[\n\t'm',\n\t'\\n',\n\t'o'\n]", Character[].class), new Character[]{'m','\n','o'});
    }

    @Test
    public void convertObjectArrayToJsonTest() throws Exception {
        Assert.assertThat(JsonConverter.toJson(new LocalDate[]{LocalDate.MIN}),
                is("[\n\t\"-999999999-01-01\"\n]"));
    }

    @Test
    public void createObjectMultidimensionalArrayFromJsonTest() throws Exception {
        Assert.assertArrayEquals((Date[][]) JsonConverter.fromJson(
                "[\n\t[\n\t\t{\n\t\t\t\"fastTime\": 1\n\t\t}\n\t],\n\t[\n\t\t{\n\t\t\t\"fastTime\": 3\n\t\t}\n\t]\n]",
                Date[][].class), new Date[][]{{new Date(1)}, {new Date(3)}});
    }

    @Test
    public void isEqualsObjectsBeforeToJsonAndAfterFromJsonTest() throws Exception {
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

        Thread.sleep(100);//for check private final String string2; (new Date().getTime()) in Strings class

        Merge1 marge1Copy = (Merge1) JsonConverter.fromJson(jsonMarge, Merge1.class);

        assertEquals(merge1, marge1Copy);
    }

    @Test
    public void checkTheSameFieldAndJsonValueNamesInDifferentFieldsExceptionTest() throws Exception {
        try {
            JsonConverter.toJson(new TheSameNames());
        }
        catch (TheSameFieldAndJsonValueNamesInDifferentFieldsException e) {
            assertThat(e.getMessage(), is("Class: reflection.services.exampleClasses.TheSameNames, Name: s"));
        }
    }
}
package reflection.services;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
    @Rule
    public ExpectedException thrown= ExpectedException.none();

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
        // Given
        Merge3 merge3 = new Merge3();
        merge3.setStrings(getStringsObject());
        merge3.setNulls(new Nulls());

        Merge2 merge2 = new Merge2();
        merge2.setMerge3(merge3);
        merge2.setPrimitives(getPrimitivesObject());
        merge2.setPrimitiveWrappers(getPrimitiveWrappersObject());

        Merge1 merge1 = new Merge1();
        merge1.setMerge2(merge2);
        merge1.setDateAndLocalDate(getDateAndLocalDateObject());
        merge1.setEmpty(new Empty());
        merge1.setDifferentArrays(getDifferentArraysObject(merge2,  merge3));

        //When
        String jsonMarge = JsonConverter.toJson(merge1);

        Thread.sleep(100);//for check private final String string2; (new Date().getTime()) in Strings class

        Merge1 marge1Copy = (Merge1) JsonConverter.fromJson(jsonMarge, Merge1.class);

        //Then
        assertEquals(merge1, marge1Copy);
    }

    @Test
    public void checkTheSameFieldAndJsonValueNamesInDifferentFieldsExceptionTest() throws Exception {
        thrown.expect(TheSameFieldAndJsonValueNamesInDifferentFieldsException.class);
        thrown.expectMessage("Class: reflection.services.exampleClasses.TheSameNames, Name: s");
        JsonConverter.toJson(new TheSameNames());
    }

    private Strings getStringsObject() {
        Strings strings = new Strings();
        strings.setString1("ass//gs\fg\"\"'}\\$\n\n\n\\\\\b");
        strings.setString3("dfgdfg\n\b\r\txxdfg");

        return strings;
    }

    private Primitives getPrimitivesObject() {
        Primitives primitives = new Primitives();
        primitives.setPrimitiveBoolean(true);
        primitives.setPrimitiveChar('\n');
        primitives.setPrimitiveByte((byte) 1);
        primitives.setPrimitiveShort((short) 2);
        primitives.setPrimitiveInt(3);
        primitives.setPrimitiveLong(4);
        primitives.setPrimitiveFloat((float) 1.1);
        primitives.setPrimitiveDouble(1.2);

        return primitives;
    }

    private PrimitiveWrappers getPrimitiveWrappersObject() {
        PrimitiveWrappers primitiveWrappers = new PrimitiveWrappers();
        primitiveWrappers.setWrapperBoolean(true);
        primitiveWrappers.setWrapperChar('\b');
        primitiveWrappers.setWrapperByte((byte) 5);
        primitiveWrappers.setWrapperShort((short) 6);
        primitiveWrappers.setWrapperInt(7);
        primitiveWrappers.setWrapperLong(8L);
        primitiveWrappers.setWrapperFloat((float) 1.3);
        primitiveWrappers.setWrapperDouble(1.4);

        return primitiveWrappers;
    }

    private DateAndLocalDate getDateAndLocalDateObject() {
        DateAndLocalDate dateAndLocalDate = new DateAndLocalDate();
        dateAndLocalDate.setLd1(LocalDate.of(1111, 1, 1));
        dateAndLocalDate.setLd2(LocalDate.of(3333, 3, 3));
        dateAndLocalDate.setDate(new Date(1));

        return dateAndLocalDate;
    }

    private DifferentArrays getDifferentArraysObject(Merge2 merge2, Merge3 merge3) {
        boolean[][][][] primitivesBoolean = new boolean[4][3][2][1];
        primitivesBoolean[2][2][1][0] = true;

        Long[][][][] wrapperLongs = new Long[3][3][3][3];
        wrapperLongs[2][2][2][2] = 3L;

        Double[][][] wrapperDoubles = new Double[5][5][5];
        wrapperDoubles[0][0][0] = Double.MIN_VALUE;
        wrapperDoubles[2][2][2] = 0.0;
        wrapperDoubles[4][4][4] = Double.MAX_VALUE;

        DifferentArrays differentArrays = new DifferentArrays();
        differentArrays.setObjectMerge2s(new Merge2[]{merge2,null});
        differentArrays.setObjectMerge3s(new Merge3[][]{{merge3, merge3}});
        differentArrays.setObjectLocaleDates(new LocalDate[][][]{{{LocalDate.MIN, null, null},{null, null, null}}});
        differentArrays.setStrings1(new String[]{null, ""});
        differentArrays.setStrings2(new String[][]{{null}, {"\"fgsgergergw3fg\f\""}});
        differentArrays.setPrimitiveInts(new int[]{0, 0, 1});
        differentArrays.setPrimitiveFloats(new float[][]{{0, 0}, {Float.MAX_VALUE, 0}, {0, Float.MIN_VALUE}});
        differentArrays.setPrimitiveChars(new char[][][]{{{'a'}, {'\u0000'}}, {{'\u0000'}, {'b'}}, {{'\u0000'}, {'c'}}});
        differentArrays.setPrimitivesBoolean(primitivesBoolean);
        differentArrays.setWrapperLongs(wrapperLongs);
        differentArrays.setWrapperDoubles(wrapperDoubles);
        differentArrays.setWrapperCharacters(new Character[][]{{null, null, '1'}});
        differentArrays.setWrapperBooleans(new Boolean[]{null, false, null});
        differentArrays.setEmptyArray(new Object[0][1][2]);

        return differentArrays;
    }
}
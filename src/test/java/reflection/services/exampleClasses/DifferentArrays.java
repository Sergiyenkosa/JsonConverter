package reflection.services.exampleClasses;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by Sergiy on 10.01.2017.
 */
public class DifferentArrays {
    private Merge2[] objectMerge2s;
    private Merge3[][] objectMerge3s;
    private LocalDate[][][] objectLocaleDates;
    private String[] strings1;
    private String[][] strings2;
    private int[] primitiveInts;
    private float[][] primitiveFloats;
    private char[][][] primitiveChars;
    private boolean[][][][] primitivesBoolean;
    private Long[][][][] wrapperLongs;
    private Double[][][] wrapperDoubles;
    private Character[][] wrapperCharacters;
    private Boolean [] wrapperBooleans;
    private Object [][][] emptyArray;

    public Merge2[] getObjectMerge2s() {
        return objectMerge2s;
    }

    public void setObjectMerge2s(Merge2[] objectMerge2s) {
        this.objectMerge2s = objectMerge2s;
    }

    public Merge3[][] getObjectMerge3s() {
        return objectMerge3s;
    }

    public void setObjectMerge3s(Merge3[][] objectMerge3s) {
        this.objectMerge3s = objectMerge3s;
    }

    public LocalDate[][][] getObjectLocaleDates() {
        return objectLocaleDates;
    }

    public void setObjectLocaleDates(LocalDate[][][] objectLocaleDates) {
        this.objectLocaleDates = objectLocaleDates;
    }

    public String[] getStrings1() {
        return strings1;
    }

    public void setStrings1(String[] strings1) {
        this.strings1 = strings1;
    }

    public String[][] getStrings2() {
        return strings2;
    }

    public void setStrings2(String[][] strings2) {
        this.strings2 = strings2;
    }

    public int[] getPrimitiveInts() {
        return primitiveInts;
    }

    public void setPrimitiveInts(int[] primitiveInts) {
        this.primitiveInts = primitiveInts;
    }

    public float[][] getPrimitiveFloats() {
        return primitiveFloats;
    }

    public void setPrimitiveFloats(float[][] primitiveFloats) {
        this.primitiveFloats = primitiveFloats;
    }

    public char[][][] getPrimitiveChars() {
        return primitiveChars;
    }

    public void setPrimitiveChars(char[][][] primitiveChars) {
        this.primitiveChars = primitiveChars;
    }

    public boolean[][][][] getPrimitivesBoolean() {
        return primitivesBoolean;
    }

    public void setPrimitivesBoolean(boolean[][][][] primitivesBoolean) {
        this.primitivesBoolean = primitivesBoolean;
    }

    public Long[][][][] getWrapperLongs() {
        return wrapperLongs;
    }

    public void setWrapperLongs(Long[][][][] wrapperLongs) {
        this.wrapperLongs = wrapperLongs;
    }

    public Double[][][] getWrapperDoubles() {
        return wrapperDoubles;
    }

    public void setWrapperDoubles(Double[][][] wrapperDoubles) {
        this.wrapperDoubles = wrapperDoubles;
    }

    public Character[][] getWrapperCharacters() {
        return wrapperCharacters;
    }

    public void setWrapperCharacters(Character[][] wrapperCharacters) {
        this.wrapperCharacters = wrapperCharacters;
    }

    public Boolean[] getWrapperBooleans() {
        return wrapperBooleans;
    }

    public void setWrapperBooleans(Boolean[] wrapperBooleans) {
        this.wrapperBooleans = wrapperBooleans;
    }

    public Object[][][] getEmptyArray() {
        return emptyArray;
    }

    public void setEmptyArray(Object[][][] emptyArray) {
        this.emptyArray = emptyArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DifferentArrays that = (DifferentArrays) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(objectMerge2s, that.objectMerge2s)) return false;
        if (!Arrays.deepEquals(objectMerge3s, that.objectMerge3s)) return false;
        if (!Arrays.deepEquals(objectLocaleDates, that.objectLocaleDates)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(strings1, that.strings1)) return false;
        if (!Arrays.deepEquals(strings2, that.strings2)) return false;
        if (!Arrays.equals(primitiveInts, that.primitiveInts)) return false;
        if (!Arrays.deepEquals(primitiveFloats, that.primitiveFloats)) return false;
        if (!Arrays.deepEquals(primitiveChars, that.primitiveChars)) return false;
        if (!Arrays.deepEquals(primitivesBoolean, that.primitivesBoolean)) return false;
        if (!Arrays.deepEquals(wrapperLongs, that.wrapperLongs)) return false;
        if (!Arrays.deepEquals(wrapperDoubles, that.wrapperDoubles)) return false;
        if (!Arrays.deepEquals(wrapperCharacters, that.wrapperCharacters)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(wrapperBooleans, that.wrapperBooleans)) return false;
        return Arrays.deepEquals(emptyArray, that.emptyArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(objectMerge2s);
        result = 31 * result + Arrays.deepHashCode(objectMerge3s);
        result = 31 * result + Arrays.deepHashCode(objectLocaleDates);
        result = 31 * result + Arrays.hashCode(strings1);
        result = 31 * result + Arrays.deepHashCode(strings2);
        result = 31 * result + Arrays.hashCode(primitiveInts);
        result = 31 * result + Arrays.deepHashCode(primitiveFloats);
        result = 31 * result + Arrays.deepHashCode(primitiveChars);
        result = 31 * result + Arrays.deepHashCode(primitivesBoolean);
        result = 31 * result + Arrays.deepHashCode(wrapperLongs);
        result = 31 * result + Arrays.deepHashCode(wrapperDoubles);
        result = 31 * result + Arrays.deepHashCode(wrapperCharacters);
        result = 31 * result + Arrays.hashCode(wrapperBooleans);
        result = 31 * result + Arrays.deepHashCode(emptyArray);
        return result;
    }
}

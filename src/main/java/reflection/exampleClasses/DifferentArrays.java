package reflection.exampleClasses;

import java.time.LocalDate;

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
}

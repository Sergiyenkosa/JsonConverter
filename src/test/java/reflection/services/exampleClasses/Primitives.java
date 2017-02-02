package reflection.services.exampleClasses;

/**
 * Created by Lubov on 07.01.2017.
 */
public class Primitives {
    private boolean primitiveBoolean;
    private char primitiveChar;
    private byte primitiveByte;
    private short primitiveShort;
    private int primitiveInt;
    private long primitiveLong;
    private float primitiveFloat;
    private double primitiveDouble;

    public boolean isPrimitiveBoolean() {
        return primitiveBoolean;
    }

    public void setPrimitiveBoolean(boolean primitiveBoolean) {
        this.primitiveBoolean = primitiveBoolean;
    }

    public char getPrimitiveChar() {
        return primitiveChar;
    }

    public void setPrimitiveChar(char primitiveChar) {
        this.primitiveChar = primitiveChar;
    }

    public byte getPrimitiveByte() {
        return primitiveByte;
    }

    public void setPrimitiveByte(byte primitiveByte) {
        this.primitiveByte = primitiveByte;
    }

    public short getPrimitiveShort() {
        return primitiveShort;
    }

    public void setPrimitiveShort(short primitiveShort) {
        this.primitiveShort = primitiveShort;
    }

    public int getPrimitiveInt() {
        return primitiveInt;
    }

    public void setPrimitiveInt(int primitiveInt) {
        this.primitiveInt = primitiveInt;
    }

    public long getPrimitiveLong() {
        return primitiveLong;
    }

    public void setPrimitiveLong(long primitiveLong) {
        this.primitiveLong = primitiveLong;
    }

    public float getPrimitiveFloat() {
        return primitiveFloat;
    }

    public void setPrimitiveFloat(float primitiveFloat) {
        this.primitiveFloat = primitiveFloat;
    }

    public double getPrimitiveDouble() {
        return primitiveDouble;
    }

    public void setPrimitiveDouble(double primitiveDouble) {
        this.primitiveDouble = primitiveDouble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Primitives that = (Primitives) o;

        if (primitiveBoolean != that.primitiveBoolean) return false;
        if (primitiveChar != that.primitiveChar) return false;
        if (primitiveByte != that.primitiveByte) return false;
        if (primitiveShort != that.primitiveShort) return false;
        if (primitiveInt != that.primitiveInt) return false;
        if (primitiveLong != that.primitiveLong) return false;
        if (Float.compare(that.primitiveFloat, primitiveFloat) != 0) return false;
        return Double.compare(that.primitiveDouble, primitiveDouble) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (primitiveBoolean ? 1 : 0);
        result = 31 * result + (int) primitiveChar;
        result = 31 * result + (int) primitiveByte;
        result = 31 * result + (int) primitiveShort;
        result = 31 * result + primitiveInt;
        result = 31 * result + (int) (primitiveLong ^ (primitiveLong >>> 32));
        result = 31 * result + (primitiveFloat != +0.0f ? Float.floatToIntBits(primitiveFloat) : 0);
        temp = Double.doubleToLongBits(primitiveDouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

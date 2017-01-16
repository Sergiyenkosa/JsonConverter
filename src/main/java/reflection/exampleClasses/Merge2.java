package reflection.exampleClasses;

/**
 * Created by Lubov on 07.01.2017.
 */
public class Merge2 {
    private Primitives primitives;
    private PrimitiveWrappers primitiveWrappers;
    private Merge3 merge3;

    public Primitives getPrimitives() {
        return primitives;
    }

    public void setPrimitives(Primitives primitives) {
        this.primitives = primitives;
    }

    public PrimitiveWrappers getPrimitiveWrappers() {
        return primitiveWrappers;
    }

    public void setPrimitiveWrappers(PrimitiveWrappers primitiveWrappers) {
        this.primitiveWrappers = primitiveWrappers;
    }

    public Merge3 getMerge3() {
        return merge3;
    }

    public void setMerge3(Merge3 merge3) {
        this.merge3 = merge3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Merge2 merge2 = (Merge2) o;

        if (primitives != null ? !primitives.equals(merge2.primitives) : merge2.primitives != null) return false;
        if (primitiveWrappers != null ? !primitiveWrappers.equals(merge2.primitiveWrappers) : merge2.primitiveWrappers != null)
            return false;
        return merge3 != null ? merge3.equals(merge2.merge3) : merge2.merge3 == null;
    }

    @Override
    public int hashCode() {
        int result = primitives != null ? primitives.hashCode() : 0;
        result = 31 * result + (primitiveWrappers != null ? primitiveWrappers.hashCode() : 0);
        result = 31 * result + (merge3 != null ? merge3.hashCode() : 0);
        return result;
    }
}

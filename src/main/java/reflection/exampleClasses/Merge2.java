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
}

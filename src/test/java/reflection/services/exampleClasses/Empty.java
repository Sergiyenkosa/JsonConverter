package reflection.services.exampleClasses;

/**
 * Created by Lubov on 07.01.2017.
 */
public class Empty {
    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

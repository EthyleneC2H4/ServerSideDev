package concert;

public class DefaultEncoreable implements Encoreable {

    public void performEncore() {
        System.out.println("perform the encore!");
    }

    @Override
    public String toString() {
        return "============DefaultEncoreable============";
    }
}
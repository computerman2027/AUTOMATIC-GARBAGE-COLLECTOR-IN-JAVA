class GarbageCollector1 
{
    private int id;

    // Constructor
    public GarbageCollector1(int id) 
    {
        this.id = id;
        System.out.println("Object " + id + " created.");
    }

    // Override finalize() method to see when objects are garbage collected
    @Override
    protected void finalize() throws Throwable 
    {
        System.out.println("Object " + id + " is being garbage collected.");
    }
}

public class FinalizeExample {
    public static void main(String[] args) {
        // Creating many objects in a loop
        for (int i = 1; i <= 1000000; i++) {
            new GarbageCollector1(i); // Objects created but no references stored (becomes eligible for GC)
        }

        System.out.println("Objects created. Now requesting Garbage Collection...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of program.");
    }
}

class Car 
{
    int maxspeed;

    public Car() 
    {
        maxspeed = 70;
    }

    protected void finalize()
    {
        // Originally finalize method does nothing, but here we override finalize() saying it to print some stmt
        // Calling of finalize is uncertain. Difficult to observe so we force JVM to call it by System.gc(); GarbageCollection

        System.out.println("Called finalize method in class Car...");
    }
}
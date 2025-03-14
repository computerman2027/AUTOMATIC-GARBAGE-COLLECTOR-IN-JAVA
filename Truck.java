class Truck 
{
    int maxspeed;

    public Truck() {
        maxspeed = 50;
    }

    protected void finalize() {
        System.out.println("Called finalize method in class Truck...");
    }
}
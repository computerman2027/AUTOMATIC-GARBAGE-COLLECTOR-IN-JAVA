class FinalizeExample2 {

    public static void main(String args[]) {
        Car c = new Car();
        c = null;    // if c weren`t null JVM wouldn't be certain it's cleared or not, null means has no future use or no longer in use hence clears it
        Truck T = new Truck();
        System.gc();    // should clear c, but not b
        for (T.maxspeed = 1; T.maxspeed <= 100; T.maxspeed++) {
            System.out.print("\t" + T.maxspeed);
            if (T.maxspeed > 60) {
                System.out.println(" Over Speed. Pls slow down.");
            }
        }
    }
}
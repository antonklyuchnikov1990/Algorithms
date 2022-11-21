package pattern_Factory;

public class Main {
    public static void main(String[] args) {
        doSomething(new RoadLogistics());
        doSomething(new ShipLogistics());
    }

    private static void doSomething(Logistics logistics) {
        Transport transport = logistics.createTransport();
        transport.deliver();
    }
}

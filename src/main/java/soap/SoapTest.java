package soap;

import soap.jaxws.LaterCount;

public class SoapTest {
    public static void main(String[] args) {
        LaterCount counter = new LaterCount();
        System.out.println(counter.getLaterCounterPort().count("Pizza"));
    }
}

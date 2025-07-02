public class TestTime {
    public static void test() {
        Time t = new Time(14, 42, 38); 
        System.out.println("current time: " + t);
        System.out.println("Hour " + t.getHour());
        System.out.println("Minute " + t.getMinute());
        System.out.println("Second " + t.getSecond());   
        System.out.println("Time: " + t.toString());
    }
}
public class ShutDownHook {
    int age;
    public static void main(String args[]) {
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {

                System.out.println("JVM cleanup started");
            }
        });

        System.out.println("Main about to terminate");
    }
    public int getAge(){
        return age;
    }

}

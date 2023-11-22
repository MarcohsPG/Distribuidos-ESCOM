public class RunneableInterface {
    static int variable_compartida = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunneableInterface().new RunnableImpl());
        t1.start();
        Thread t2 = new Thread(new RunneableInterface().new RunnableImpl());
    }

    //Modifica
    public void modifica(){
     long idHilo = Thread.currentThread().getId();
     
    }

    private class RunnableImpl implements Runnable {
 
        public void run()
        {
            System.out.println(Thread.currentThread().getName()
                             + ", executing run() method!");
        }
    }
}

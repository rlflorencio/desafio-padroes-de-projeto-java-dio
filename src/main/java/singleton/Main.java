package singleton;

public class Main {
    public static void main(String[] args) {
        //Demonstrando o Singleton, onde mesmo tentando instanciar duas vezes a classe FornoDePizza
        //apenas a primeira tentativa será considerada.
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());
        threadOne.start();
        threadTwo.start();

    }
    static class ThreadOne implements Runnable {
        @Override
        public void run(){
            FornoDePizza forno = FornoDePizza.getInstance("Pizza de Calabresa");
            System.out.println(forno.nome);
        }
    }

    static class ThreadTwo implements Runnable {
        @Override
        public void run(){
            FornoDePizza forno = FornoDePizza.getInstance("Pizza 4 Queijos");
            System.out.println(forno.nome);
        }
    }
}
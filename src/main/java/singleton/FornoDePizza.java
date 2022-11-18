package singleton;

public class FornoDePizza {
    public String nome;
    private boolean aceso;
    private boolean pizzaNoForno;
    private boolean pizzaPronta;

    private static volatile FornoDePizza instance;

    private FornoDePizza(String nome) {
        this.nome = nome;
        aceso = false;
        pizzaNoForno = false;
        pizzaPronta = false;
    }

    public static FornoDePizza getInstance(String nome){
        FornoDePizza result = instance;
        if(result != null) {
            return result;
        }
        synchronized (FornoDePizza.class) {
            if (instance == null) {
                instance = new FornoDePizza(nome);
            }
            return instance;
        }
    }

    public void acender(){
        if(!isAceso()) {
            aceso = true;
            pizzaNoForno = false;
            pizzaPronta = false;
        }
    }

    public void colocaPizza(){
        if(isAceso()) {
            pizzaNoForno = true;
            pizzaPronta = false;
        }
    }

    public void assaPizza(){
        if(isAceso() && isPizzaNoForno()){
            pizzaPronta = true;
        }
    }

    public void retiraPizza(){
        if(isAceso() && isPizzaNoForno() && isPizzaPronta() ){
            pizzaNoForno = false;
            pizzaPronta = false;
        }
    }

    public void apagar(){
        if(isAceso() && isPizzaNoForno() && isPizzaPronta() ){
            aceso = false;
            pizzaNoForno = false;
            pizzaPronta = false;
        }
    }

    public boolean isAceso(){
        return aceso;
    }

    public boolean isPizzaNoForno() {
        return pizzaNoForno;
    }
    public boolean isPizzaPronta() {
        return pizzaPronta;
    }


}



package src.Pastelaria;

// main class given --> this is where everything is tested
public class Main {
    public static void main(String[] args) {

        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilderAbstract chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations"); // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: "+ cake);

        CakeBuilderAbstract sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");// squared, 2 layers
        cake = cakeMaster.getCake();System.out.println("Your cake is ready: "+ cake);

        CakeBuilderAbstract yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");// 3 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: "+ cake);
        //you should add here other example(s)of CakeBuilder
    }
}

package Ex2;

public class Contact {
    private int number;
    private String name;

    // contructors
    public Contact(){
        this.number = 0;
        this.name = "";
    }
    public Contact(String name, int number){
        this.name = name;
        this.number = number;
    }
    
    // setters
    public void setNumber(int number){
        this.number = number;
    }

    public void setName(String name){
        this.name = name;
    }

    // getters
    public int getNumber(){
        return this.number;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.number;
    }
}

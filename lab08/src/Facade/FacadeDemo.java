package Facade;

public class FacadeDemo {
    public static void main(String[] args) {
        CompanyFacade facade = new CompanyFacade();
        facade.getRegistationEmployee("Julio", 1000);
        facade.getRegistationEmployee("Antonio", 2200);
        facade.getRegistationEmployee("Maria", 10);
        
    }
}
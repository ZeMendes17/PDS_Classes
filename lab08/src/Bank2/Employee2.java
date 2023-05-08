package Bank2;

// import Bank2.BankAccount;
// import Bank2.Person;

class Employee2{

    private double salary;
    private Person person;
    private BankAccount ba;
        
        public Employee2(Person n, double s) {
            //super(n);
            person = n;
            salary = s;
            if(Company2.user == Bank2.User.COMPANY)
                {ba = new BankProxy("PeDeMeia", 0);
                System.out.println("ola");}
            else
                ba = new BankAccountImpl("PeDeMeia", 0);
            
        }

        public double getSalary() {
            return salary;
        }

        public void payEmp(double amount) {
            ba.deposit(amount);
        }
}
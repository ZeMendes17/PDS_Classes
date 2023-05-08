package Bank2;

class Person {
	
    private String name;
    private BankAccount bankAccount;

        public Person(String n) {
            name = n;

            //bankAccount = new BankAccountImpl("PeDeMeia", 0);
            if(Company2.user == Bank2.User.COMPANY)
                {bankAccount = new BankProxy("PeDeMeia", 0);
                System.out.println("ola");}
            else
                bankAccount = new BankAccountImpl("PeDeMeia", 0);
        }

        public String getName() {
            return name;
        }
        
        public BankAccount getBankAccount() {
            return bankAccount;
        }
}
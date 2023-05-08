package Bank;

class Person {
	
    private String name;
    private BankAccount bankAccount;

        public Person(String n) {
            name = n;
            
            //bankAccount = new BankAccountImpl("PeDeMeia", 0);
            if(Company.user == User.COMPANY)
                bankAccount = new BankProxy("PeDeMeia", 0);
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
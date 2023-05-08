package Bank2;
class BankProxy extends BankAccountImpl {


    private String bank;
    private double balance;

    BankProxy(String bank, double initialDeposit) {
        super(bank, initialDeposit);
        // this.bank = bank;
        // balance = initialDeposit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    public String getBankAccount() {
        return bank;
    }

}
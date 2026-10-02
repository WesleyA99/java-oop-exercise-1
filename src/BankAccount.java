
public class BankAccount {

    private double balance;
    private double limitCheck;

    public BankAccount(double balance) {
        this.balance = balance;

        if (balance <= 500) {
            this.limitCheck = 50;
        } else {
            this.limitCheck = balance * 0.5;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimitCheck() {
        return limitCheck;
    }

    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Depósito inválido");
        }

        double usedCheck;
        if (balance < 0) {
            usedCheck = balance * (-1);
        } else {
            usedCheck = 0;
        }

        balance += amount;

        if (usedCheck > 0) {
            double tax = usedCheck * 0.2;
            balance -= tax;
        }

        return balance;
    }

    public double withdraw(double takeMoney) {
        double availableAmount = balance + limitCheck;

        if (takeMoney < 0) {
            throw new IllegalArgumentException("Saque inválido");
        }
        if (takeMoney > availableAmount) {
            throw new IllegalArgumentException("Saque maior que o saldo disponível");
        }

        balance -= takeMoney;
        return balance;
    }

    public double payBill(double bill) {
        double availableAmount = balance + limitCheck;

        if (bill < 0) {
            throw new IllegalArgumentException("Boleto inválido");
        }
        if (bill > availableAmount) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        balance -= bill;
        return balance;
    }

    public boolean isUsingSpecialCheck() {
        if (balance < 0) {
            return true;
        } else {
            return false;
        }
    }
}
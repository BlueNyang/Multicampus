package kr.bluenyang.practice.springbootex.product.model;

public record MoneyVO(int amount) {
    public MoneyVO {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    public MoneyVO(Integer amount) {
        this(amount == null ? 0 : amount);
    }

    public MoneyVO add(MoneyVO other) {
        return new MoneyVO(this.amount + other.amount);
    }

    public MoneyVO subtract(MoneyVO other) {
        int result = this.amount - other.amount;
        if (result < 0) {
            throw new IllegalArgumentException("Resulting amount cannot be negative");
        }
        return new MoneyVO(result);
    }
}

package kr.bluenyang.practice.springbootex.product.vo;

public record Money(int amount) {
    public Money {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    public Money subtract(Money other) {
        int result = this.amount - other.amount;
        if (result < 0) {
            throw new IllegalArgumentException("Resulting amount cannot be negative");
        }
        return new Money(result);
    }
}

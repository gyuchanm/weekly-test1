package main;

public class Cart {
    private Product[] products;

    public Cart(Product[] products) {
        this.products = products;
    }

    public int calculateDeliveryCharge() {
        int totalWeight = 0;
        int totalPrice = 0;

        for (Product product : products) {
            totalWeight += product.weight;
            totalPrice += (product.price - product.getDiscountAmount());
        }

        // 배송비
        int shipping;
        if (totalWeight >= 10) {
            shipping = 10000;
        } else if (totalWeight >= 3) {
            shipping = 5000;
        } else {
            shipping = 1000;
        }

        // 최종배송비
        int finalShip;
        if (totalPrice >= 100000) {
            finalShip = 0; // 100,000원 이상일 경우 무료
        } else if (totalPrice >= 30000) {
            finalShip = shipping - 1000; // 30,000원 이상 100,000원 미만일 경우 1,000원 할인
        } else {
            finalShip = shipping; // 30,000원 미만일 경우 기본 배송비
        }

        return finalShip;
    }
}

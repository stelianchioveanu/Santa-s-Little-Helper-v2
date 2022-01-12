package gift;

import enums.Category;

public final class Gift {
    private final String productName;
    private final Double price;
    private final Category category;
    private Integer quantity;

    public Gift() {
        this.productName = "";
        this.price = 0.0;
        this.category = Category.BOARD_GAMES;
        this.quantity = 0;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

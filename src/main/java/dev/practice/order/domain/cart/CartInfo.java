package dev.practice.order.domain.cart;

import dev.practice.order.domain.partner.Partner;
import lombok.Getter;

@Getter
public class CartInfo {
    private final String cartToken;
    private final Long userId;
    private final String itemList;
//    private final Cart.Status status;

    public CartInfo(Cart cart) {
        this.cartToken = cart.getCartToken();
        this.userId = cart.getUserId();
        this.itemList = cart.getItemList();
    }
}

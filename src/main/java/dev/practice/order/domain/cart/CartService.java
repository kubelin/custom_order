package dev.practice.order.domain.cart;

public interface CartService {
    CartInfo registerCart(CartCommand command);

    CartInfo getCartInfo(Long userId);
}

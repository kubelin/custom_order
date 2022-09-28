package dev.practice.order.domain.cart;

import dev.practice.order.domain.partner.Partner;

public interface CartReader {
    Cart getCart(Long userId);
    Cart getCart(String partnerToken);
}

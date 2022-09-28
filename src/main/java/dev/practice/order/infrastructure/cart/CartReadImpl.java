package dev.practice.order.infrastructure.cart;

import dev.practice.order.common.exception.EntityNotFoundException;
import dev.practice.order.domain.cart.Cart;
import dev.practice.order.domain.cart.CartReader;
import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerReader;
import dev.practice.order.infrastructure.partner.PartnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CartReadImpl implements CartReader {
    private final CartRepository cartRepository;

    @Override
    public Cart getCart(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Cart getCart(String partnerToken) {
        return null;
    }
}

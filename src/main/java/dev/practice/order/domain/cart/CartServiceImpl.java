package dev.practice.order.domain.cart;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartStore cartStore;
    private final CartReader cartReader;

    /**
     * Cart저장 전 중복체크
     * @param command
     * @return
     */
    @Override
    @Transactional
    public CartInfo registerCart(CartCommand command) {
        var initCart = command.toEntity();
        Cart cart = cartStore.store(initCart);
        return new CartInfo(cart);
    }

    @Override
    @Transactional(readOnly = true)
    public CartInfo getCartInfo(Long userId) {
        Cart cart = cartReader.getCart(userId);
        return new CartInfo(cart);
    }
}

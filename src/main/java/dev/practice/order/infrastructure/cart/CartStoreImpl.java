package dev.practice.order.infrastructure.cart;

import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.domain.cart.Cart;
import dev.practice.order.domain.cart.CartStore;
import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerStore;
import dev.practice.order.infrastructure.partner.PartnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CartStoreImpl implements CartStore {

    private final CartRepository cartRepository;

    @Override
    public Cart store(Cart cart) {
        if ( cart.getUserId() == null) throw new InvalidParamException("cart.getUserId()");
        if (StringUtils.isEmpty(cart.getItemList())) throw new InvalidParamException("cart.getItemList()");
        // 같은 userId가 있으면 update 없으면 insert
        return cartRepository.saveAndFlush(cart);
        //return cartRepository.save(cart);
    }
}

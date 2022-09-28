package dev.practice.order.application.cart;

import dev.practice.order.domain.cart.CartCommand;
import dev.practice.order.domain.cart.CartInfo;
import dev.practice.order.domain.cart.CartService;
import dev.practice.order.domain.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Serviceg
@RequiredArgsConstructor
public class CartFacade {
    private final CartService cartService;
    private final NotificationService notificationService;

    public CartInfo registerCart(CartCommand command) {
        var cartInfo = cartService.registerCart(command);
        //notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
        System.out.println("CartFacade email is not gonna send");
        return cartInfo;
    }

    public CartInfo retrieveCartInfo(Long userId){
        return cartService.getCartInfo(userId);
    }

}

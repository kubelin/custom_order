package dev.practice.order.interfaces.cart;

import dev.practice.order.domain.cart.CartCommand;
import dev.practice.order.domain.cart.CartInfo;
import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CartDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        @NotNull(message = "userId 는 필수값입니다")
        private Long userId;

        @NotEmpty(message = "itemList 는 필수값입니다")
        private String itemList;

        public CartCommand toCommand() {
            return CartCommand.builder()
                    .userId(userId)
                    .itemList(itemList)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final Long userId;
        private final String itemList;

        public RegisterResponse(CartInfo cartInfo) {
            this.userId = cartInfo.getUserId();
            this.itemList = cartInfo.getItemList();
        }
    }
}

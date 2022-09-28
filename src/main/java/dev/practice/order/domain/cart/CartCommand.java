package dev.practice.order.domain.cart;

import dev.practice.order.domain.partner.Partner;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CartCommand {
    private final Long userId;
    private final String itemList;

    public Cart toEntity() {
        return Cart.builder()
                .userId(userId)
                .itemList(itemList)
                .build();
    }
}

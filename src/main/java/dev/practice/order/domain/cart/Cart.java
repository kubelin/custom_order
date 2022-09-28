package dev.practice.order.domain.cart;

import com.google.common.collect.Lists;
import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.common.util.TokenGenerator;
import dev.practice.order.domain.AbstractEntity;
import dev.practice.order.domain.item.optiongroup.ItemOptionGroup;
import dev.practice.order.domain.order.Order;
import dev.practice.order.domain.order.item.OrderItem;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@ToString
@Getter
@Entity
@NoArgsConstructor
@Table(name = "carts")
public class Cart extends AbstractEntity {

    private static final String CART_PREFIX = "cart_";

    @Id
    private Long userId;

    private String cartToken;
    private String itemList;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.PERSIST)
//    private List<CartItem> cartItemList = Lists.newArrayList();

    @Builder
    public Cart(
            Long userId,
            String itemList
    ){
        System.out.println("call builder ");
        if (userId == null) throw new InvalidParamException("Cart.userId");
        if (itemList == null) throw new InvalidParamException("Cart.itemList");

        this.cartToken = TokenGenerator.randomCharacterWithPrefix(CART_PREFIX);
        this.userId = userId;
        this.itemList = itemList;
    }



}

package dev.practice.order.domain.cart;

import com.google.common.collect.Lists;
import dev.practice.order.common.exception.IllegalStatusException;
import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.domain.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "cart_items")
public class CartItem extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Integer orderCount;
    private Long partnerId;
    private Long itemId;
    private String itemName;
    private String itemToken;
    private Long itemPrice;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Getter
    @AllArgsConstructor
    public enum DeliveryStatus {
        BEFORE_DELIVERY("배송전"),
        DELIVERY_PREPARE("배송준비중"),
        DELIVERING("배송중"),
        COMPLETE_DELIVERY("배송완료");

        private final String description;
    }

    @Builder
    public CartItem(
            Cart cart,
            Integer orderCount,
            Long partnerId,
            Long itemId,
            String itemName,
            String itemToken,
            Long itemPrice
    ) {
        if (cart == null) throw new InvalidParamException("OrderItemLine.cart");
        if (orderCount == null) throw new InvalidParamException("OrderItemLine.orderCount");
        if (partnerId == null) throw new InvalidParamException("OrderItemLine.partnerId");
        if (itemId == null && StringUtils.isEmpty(itemName))
            throw new InvalidParamException("OrderItemLine.itemNo and itemName");
        if (StringUtils.isEmpty(itemToken)) throw new InvalidParamException("OrderItemLine.itemToken");
        if (itemPrice == null) throw new InvalidParamException("OrderItemLine.itemPrice");

        this.cart = cart;
        this.orderCount = orderCount;
        this.partnerId = partnerId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemToken = itemToken;
        this.itemPrice = itemPrice;
        this.deliveryStatus = DeliveryStatus.BEFORE_DELIVERY;
    }


    public void deliveryPrepare() {
        if (this.deliveryStatus != DeliveryStatus.BEFORE_DELIVERY) throw new IllegalStatusException();
        this.deliveryStatus = DeliveryStatus.DELIVERY_PREPARE;
    }

    public void inDelivery() {
        if (this.deliveryStatus != DeliveryStatus.DELIVERY_PREPARE) throw new IllegalStatusException();
        this.deliveryStatus = DeliveryStatus.DELIVERING;
    }

    public void deliveryComplete() {
        if (this.deliveryStatus != DeliveryStatus.DELIVERING) throw new IllegalStatusException();
        this.deliveryStatus = DeliveryStatus.COMPLETE_DELIVERY;
    }
}

package dev.practice.order.domain.order.payment.validator;

import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.domain.order.Order;
import dev.practice.order.domain.order.OrderCommand;
import org.springframework.stereotype.Component;

@org.springframework.core.annotation.Order(value = 1)
@Component
public class PayAmountValidator implements PaymentValidator {

    @Override
    public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
        if (!order.calculateTotalAmount().equals(paymentRequest.getAmount())){
            System.out.println(order.calculateTotalAmount());
            throw new InvalidParamException(order.calculateTotalAmount() + " 주문가격이 불일치합니다");
        }

    }
}

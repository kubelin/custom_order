package dev.practice.order;

import dev.practice.order.domain.cart.Cart;
import dev.practice.order.domain.cart.CartStore;
import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerService;
import dev.practice.order.domain.partner.PartnerServiceImpl;
import dev.practice.order.infrastructure.cart.CartStoreImpl;
import dev.practice.order.infrastructure.partner.PartnerStoreImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

@SpringBootTest
class OrderApplicationTests {

    @MockBean
    private PartnerService partnerService;
    @Autowired
    private PartnerStoreImpl ptStore;
    @Autowired
    private CartStoreImpl cartStore;

    @Test
    void contextLoads() {
        System.out.println("start contextLoads 시작시작  ");

        Partner pt =  new Partner("JODOCKCOMPANY", "1", "jodock@gmail.com");
        Long tempId = 139760L;
        String itemList = "5,1,2,3";
        Cart cart1 = new Cart(tempId,itemList);
        System.out.println(cart1.toString());
        cartStore.store(cart1);
//        ptStore.store(pt);






        System.out.println("end contextLoads");
    }

}

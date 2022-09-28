package dev.practice.order.interfaces.cart;

import dev.practice.order.application.cart.CartFacade;
import dev.practice.order.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartApiController {
    private final CartFacade cartFacade;

    /**
     * 카트 등록 ( 중복키 발생시 업데이트 )
     * @param request
     * @return
     */
    @PostMapping("/init")
    public CommonResponse registerCart(@RequestBody @Valid CartDto.RegisterRequest request) {
        System.out.println("Call Cart INIT API \n");
        var orderCommand = request.toCommand();
        var cartInfo = cartFacade.registerCart(orderCommand);
        var response = new CartDto.RegisterResponse(cartInfo);
//        var response = giftOrderDtoMapper.of(result);
        return CommonResponse.success(response);
    }

    /**
     * 카트 조회 ( 단건 )
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public CommonResponse retrieve(@PathVariable("userId") Long userId){
        var cartInfo = cartFacade.retrieveCartInfo(userId);
        var response = new CartDto.RegisterResponse(cartInfo);
        return CommonResponse.success(response);
    }

}

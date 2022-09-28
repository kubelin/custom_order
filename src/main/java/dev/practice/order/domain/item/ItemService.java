package dev.practice.order.domain.item;

import java.util.List;

public interface ItemService {
    String registerItem(ItemCommand.RegisterItemRequest request, String partnerToken);
    void changeOnSale(String itemToken);
    void changeEndOfSale(String itemToken);
    ItemInfo.Main retrieveItemInfo(String itemToken);

    ItemInfo.ItemListInfo retrieveItemList();
}

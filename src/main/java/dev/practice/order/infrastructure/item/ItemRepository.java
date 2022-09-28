package dev.practice.order.infrastructure.item;


import dev.practice.order.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByItemToken(String itemToken);

    List<Item> findAll();
}

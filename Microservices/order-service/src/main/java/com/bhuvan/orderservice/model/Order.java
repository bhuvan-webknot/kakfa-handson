package com.bhuvan.orderservice.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}

/*
* {
*   id:1,
*   orderNumber:123,
*   orderLineItemsList: [
*       {
            id:1,
            skuCode:'iphone',
            price:134440,
            quantity:2
        }
*   ]
* }
*/

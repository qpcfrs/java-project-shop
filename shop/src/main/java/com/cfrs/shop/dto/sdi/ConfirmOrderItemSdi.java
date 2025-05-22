package com.cfrs.shop.dto.sdi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfirmOrderItemSdi {
    private String productName;
    private Integer quantity;
    private Long price;
}

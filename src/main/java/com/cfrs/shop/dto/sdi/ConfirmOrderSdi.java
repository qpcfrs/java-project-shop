package com.cfrs.shop.dto.sdi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfirmOrderSdi {
    private Long userId;
    private List<ConfirmOrderItemSdi> productItems;
}

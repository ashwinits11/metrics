package com.et.ms.metrics.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Donetrade {
    private String transactionId;
    private String clOrdId;
    private String side;
    private String securityId;
    private String lastQty;
    private String lastPx;
}

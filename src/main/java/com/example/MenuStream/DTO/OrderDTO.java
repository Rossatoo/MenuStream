package com.example.MenuStream.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
@Data
public class OrderDTO {
    private Long customerId;
    private List<OrderDetailDTO> orderDetails;
    private BigDecimal totalAmount;
    private String status;
    private Date orderDate;
    private Date fulfillmentDate;
}
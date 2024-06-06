package com.example.MenuStream.service;

import com.example.MenuStream.DTO.OrderDTO;
import com.example.MenuStream.DTO.OrderDetailDTO;
import com.example.MenuStream.model.Customer;
import com.example.MenuStream.model.Order;
import com.example.MenuStream.model.OrderDetail;
import com.example.MenuStream.model.Product;
import com.example.MenuStream.repository.CustomerRepository;
import com.example.MenuStream.repository.OrderRepository;
import com.example.MenuStream.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    public Order saveOrder(OrderDTO orderDTO) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(orderDTO.getStatus());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setFulfillmentDate(orderDTO.getFulfillmentDate());

        for (OrderDetailDTO detail : orderDTO.getOrderDetails()) {
            Product product = productRepository.findById(detail.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(product);
            orderDetail.setQuantity(detail.getQuantity());
            order.addOrderDetail(orderDetail);

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(detail.getQuantity()));
            totalAmount = totalAmount.add(itemTotal);
        }

        //Acrescentando aqueles 10%
        order.setTotalAmount(totalAmount.multiply(BigDecimal.valueOf(1.1)));

        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long id, OrderDTO orderDTO) {

        Order order = getOrderById(id);
        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        order.setCustomer(customer);
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setStatus(orderDTO.getStatus());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setFulfillmentDate(orderDTO.getFulfillmentDate());

        // Limpar os detalhes de pedido existentes primeiro (se você deseja substituí-los)
        order.getOrderDetails().clear();

        // Adicionar novos ou atualizados detalhes do pedido
        for (OrderDetailDTO detail : orderDTO.getOrderDetails()) {
            Product product = productRepository.findById(detail.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);  // Vincula o detalhe ao pedido
            orderDetail.setProduct(product);
            orderDetail.setQuantity(detail.getQuantity());
            order.addOrderDetail(orderDetail);
        }

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

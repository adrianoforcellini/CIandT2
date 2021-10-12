package br.com.codenation.service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    /**
     * Calculate the sum of all OrderItems
     */
    @Override
    public Double calculateOrderValue(List<OrderItem> items) {
        DoubleStream list = items.stream().mapToDouble(item -> {
            Long quantity = item.getQuantity();
            Optional<Product> product = productRepository.findById(item.getProductId());
            assert product.orElse(null) != null;
            Double value = product.orElse(null).getValue();
            if (!product.get().getIsSale()) {
                return value * quantity;
            }
            value = value * 0.8;
            return value * quantity;
        });
        return list.reduce(0.0, Double::sum);
    }

// Stream to doublestream
// https://www.geeksforgeeks.org/stream-maptodouble-java-examples/

// Somando elementos double em lista stream
// https://www.ti-enxame.com/pt/java/maptodouble-e-realmente-necessario-para-somar-uma-lista-double-com-java-8-fluxos/1047029528/

// Para solucionar a questão que eu estava encontrando ao utilizar o método get para obter o product
// ( 'Optional.get()' without 'isPresent()' check ), utilizei o metodo orElse(null)
// https://stackoverflow.com/questions/38725445/optional-get-without-ispresent-check
// para evitar um null point exception, utilizei o assert da linha 24.

    /**
     * Map from idProduct List to Product Set
     */
    @Override
    public Set<Product> findProductsById(List<Long> ids) {
        return productRepository.findAll().
                stream().filter(product -> ids.contains(product.getId())).
                collect(Collectors.toSet());
    }

//  Filtraldo elementos ( e muitas outras funcionalidades do stream)
//  https://medium.com/@racc.costa/streams-no-java-8-e-no-java-9-36177c5c3313

//  Convertendo Stream de volta para Set:
//  https://www.geeksforgeeks.org/convert-stream-set-java/
//  A interface Set representa um grupo de elementos sem duplicatas.

    /**
     * Calculate the sum of all Orders(List<OrderIten>)
     */
    @Override
    public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
        DoubleStream list = orders.stream().mapToDouble(this::calculateOrderValue);
        return list.reduce(0.0, Double::sum);
    }

    /**
     * Group products using isSale attribute as the map key
     */
    @Override
    // O map basicamente "cria objetos" -> Pares Chave valor.
    // no caso "groupProductsBySale.getKey() = Boolean" e "groupProductsBySale.getValue() = List"

    public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
        return productIds.stream()
                .map(id -> productRepository.findById(id).get())
                .collect(Collectors.groupingBy(Product::getIsSale));
    }

    // Como agrupar uma lista de objetos por atributos
    // https://qastack.com.br/programming/21678430/group-a-list-of-objects-by-an-attribute-java
    // Map<String, List<Student>> studlistGrouped =
    // studlist.stream().collect(Collectors.groupingBy(w -> w.stud_location));
    // -> necessario uso do get para obter o product de optional
    // mapeando os elementos da stream para gerar  a nova stream a ser agrupada
    // https://medium.com/@racc.costa/streams-no-java-8-e-no-java-9-36177c5c3313

}
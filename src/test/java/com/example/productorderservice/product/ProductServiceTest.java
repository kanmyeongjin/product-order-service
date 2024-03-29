package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
//    private StubProductPort productPort = new StubProductPort();

    @BeforeEach
    void setUp() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }

    @Test
    void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품수정", 2000, DiscountPolicy.NONE);
        final Product product = new Product("상품명",1000,DiscountPolicy.NONE);
        Mockito.when(productPort.getProduct(productId)).thenReturn(product);
//        productPort.getProduct_vill_return = product;
        productService.updateProduct(productId, request);

        assertThat(product.getName()).isEqualTo("상품수정");
        assertThat(product.getPrice()).isEqualTo(2000);

    }


//    private static class StubProductPort implements ProductPort {
//        public Product getProduct_vill_return;
//
//        @Override
//        public void save(Product product) {
//        }
//
//        @Override
//        public Product getProduct(Long productId) {
//            return getProduct_vill_return;
//        }
//    }
}

package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.example.productorderservice.product.ProductSteps.상품등록요청;
import static com.example.productorderservice.product.ProductSteps.상품등록요청_생성;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class ProductApiTest extends ApiTest {

//    @Autowired
//    private ProductService productService;

    //@AutoWired 추가로 주석
//    private ProductPort productPort;
//    private ProductRepository productRepository;
//
//    @BeforeEach
//    void setUp() {
//        productRepository = new ProductRepository();
//        productPort = new ProductAdapter(productRepository);
//        productService = new ProductService(productPort);
//    }

    @Test
    void 상품등록() {
        final var request = 상품등록요청_생성();
        //productService.addProduct(request);

        // API 요청
        final var response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        final var response = ProductSteps.상품조회요청(productId);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

    // 레코드로 만든다고함
//    private static class AddProductRequest{
//        private final String name;
//        private final int price;
//        private final DiscountPolicy discountPloicy;
//        public AddProductRequest(final String name, final int price, final DiscountPolicy discountPlicy){
//            Assert.hasText(name, "상품명은 필수입니다");
//            Assert.isTrue(price > 0, "상품 가격은 0보다 커야합니다.");
//            Assert.notNull(discountPolicy, "할인 정책은 필수입니다");
//            this.name = name;
//            this.price = price;
//            this.discountPolicy = discountPolicy;
//        }
//    }


}

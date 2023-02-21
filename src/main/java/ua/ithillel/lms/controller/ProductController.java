package ua.ithillel.lms.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ithillel.lms.dto.ProductDto;
import ua.ithillel.lms.exception.ProductNotFoundException;
import ua.ithillel.lms.service.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

  private final ProductService productService;

  @GetMapping("/")
  public List<ProductDto> getProducts() {
    return productService.getProducts();
  }

  @GetMapping("/{id}")
  public ProductDto getProductById(@PathVariable long id) {
    ProductDto productDto = new ProductDto();
    try {
      productDto = productService.getProductById(id);
    } catch (ProductNotFoundException e) {
      log.error(e.getMessage());
    }
    return productDto;
  }

  @PostMapping("/")
  public ProductDto addProduct(@RequestBody ProductDto productDto) {
    return productService.addProduct(productDto);
  }

  @DeleteMapping("/{id}")
  public List<ProductDto> deleteProduct(@PathVariable long id) {
    List<ProductDto> productDtoList = new ArrayList<>();
    try {
      productDtoList = productService.deleteProduct(id);
    } catch (ProductNotFoundException e) {
      log.error(e.getMessage());
    }
    return productDtoList;
  }
}

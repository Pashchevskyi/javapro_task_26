package ua.ithillel.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.lms.dto.ProductDto;
import ua.ithillel.lms.exception.ProductNotFoundException;
import ua.ithillel.lms.model.Product;
import ua.ithillel.lms.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  private final ObjectMapper objectMapper;

  /**
   * Returns ProductDto mapping of Product object by id of searching Product
   *
   * @param id of Product to search for
   * @return ProductDto object
   * @throws ProductNotFoundException if Product has not been found
   */
  public ProductDto getProductById(long id) throws ProductNotFoundException {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id));
    return objectMapper.convertValue(product, ProductDto.class);
  }

  /**
   * Returns list of ProductDto objects
   *
   * @return ArrayList<ProductDto>
   */
  public List<ProductDto> getProducts() {
    Iterable<Product> products = productRepository.findAll();
    List<ProductDto> result = new ArrayList<>();
    products.forEach(product -> result.add(objectMapper.convertValue(product, ProductDto.class)));
    return result;
  }

  /**
   * Returns ProductDto object for Product added
   *
   * @param productDto object to add
   * @return ProductDto object added
   */
  public ProductDto addProduct(ProductDto productDto) {

    Product product = objectMapper.convertValue(productDto, Product.class);

    Product addedProduct = productRepository.save(product);
    productDto.setId(addedProduct.getId());
    return productDto;
  }

  /**
   * Removes a Product object and returns ProductDto, mapped from the deleted one
   *
   * @param id of object, which you are going to delete
   * @return List of ProductDto mappings of Product objects without deleted object
   * @throws ProductNotFoundException if Product object has not been found
   */
  public List<ProductDto> deleteProduct(long id) throws ProductNotFoundException {
    productRepository.deleteById(id);
    return getProducts();
  }
}

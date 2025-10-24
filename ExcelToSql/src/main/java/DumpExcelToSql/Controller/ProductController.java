package DumpExcelToSql.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import DumpExcelToSql.Helper.MyExcelHelper;
import DumpExcelToSql.Service.ProductService;
import DumpExcelToSql.entity.Product;

@RestController
@CrossOrigin("*")
// anu user from any origin can access this controller
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping("/product/upload")
  public ResponseEntity<?> uploadProduct(@RequestParam("file") MultipartFile file) {
    if (MyExcelHelper.checkExcelFormat(file)) {
      // true
      this.productService.save(file);
      return ResponseEntity.ok("File is uploaded and data is saved to db");
    }

    return ResponseEntity.status(400).body("Please upload excel file only");
  }

  @GetMapping("/product")
  public List<Product> getAllProducts() {
    return this.productService.getAllProducts();
  }

}

package DumpExcelToSql.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import DumpExcelToSql.Helper.MyExcelHelper;
import DumpExcelToSql.Repositories.PdtRepo;
import DumpExcelToSql.entity.Product;

@Service
public class ProductService {

  @Autowired
  private PdtRepo pdtRepo;

  // convert data from excel file to product entity and save to database
  public void save(MultipartFile file) {
    try {
      List<Product> products = MyExcelHelper.convertExcelToList(file.getInputStream());
      pdtRepo.saveAll(products);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  // get all products from database as json using productrepo
  public List<Product> getAllProducts() {
    return this.pdtRepo.findAll();

  }

}

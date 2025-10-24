package DumpExcelToSql.Helper;

// import java.io.InputStream;
// import java.util.ArrayList;
// import java.util.List;

// import org.apache.poi.ss.usermodel.Workbook;
// import org.springframework.web.multipart.MultipartFile;

// import entity.Product;

// public class MyExcelHelper {

//   // check given file is excel file or not
//   public static boolean checkExcelFormat(MultipartFile file) {

//     String contentType = file.getContentType();
//     if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
//       return true;
//     } else {
//       return false;
//     }

//   }

//   // other helper methods if needed
//   // convert excel to list of products

//   public static List<Product> convertExcelToList(InputStream is) {
//     // implementation to read excel and convert to list of products{
//     List<Product> list = new ArrayList<>();
//     try {

//       Workbook workbook = WorkbookFactory.create(is);

//     } catch (Exception e) {
//       e.printStackTrace();
//     }
//     return list;
//   }
// }

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import DumpExcelToSql.entity.Product;

public class MyExcelHelper {

  // check given file is excel file or not
  public static boolean checkExcelFormat(MultipartFile file) {

    String contentType = file.getContentType();
    if (contentType == null) {
      return false;
    }
    // accept both xlsx and xls
    return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
        || contentType.equals("application/vnd.ms-excel");

  }

  // other helper methods if needed
  // convert excel to list of products

  public static List<Product> convertExcelToList(InputStream is) {
    List<Product> list = new ArrayList<>();
    try (Workbook workbook = WorkbookFactory.create(is)) {

      Sheet sheet = workbook.getSheetAt(0);
      // assume first row is header; start at row 1
      for (int r = 1; r <= sheet.getLastRowNum(); r++) {
        Row row = sheet.getRow(r);
        if (row == null) {
          continue;
        }
        Product product = new Product();
        // TODO: map cells to product fields, e.g.:
        product.setPdtname(row.getCell(0).getStringCellValue());
        product.setPdtprice(row.getCell(1).getNumericCellValue());
        // adjust according to your Product class
        list.add(product);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
}

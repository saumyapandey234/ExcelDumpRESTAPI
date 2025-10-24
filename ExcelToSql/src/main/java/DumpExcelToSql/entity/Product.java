package DumpExcelToSql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@Getter
@Setter

@Entity
public class Product {

  @Id
  private Integer pdtid;
  private String pdtname;
  private Double pdtprice;

}

package DumpExcelToSql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "DumpExcelToSql.entity") // ✅ Add this
@EnableJpaRepositories(basePackages = "DumpExcelToSql.Repositories") // ✅ Add this
public class ExcelToSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelToSqlApplication.class, args);
	}
}

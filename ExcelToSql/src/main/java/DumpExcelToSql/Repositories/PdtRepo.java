package DumpExcelToSql.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PdtRepo extends JpaRepository<DumpExcelToSql.entity.Product, Integer> {
  // List<entity.Product> findByName(String name);
  // List<entity.Product> findByCategory(String category);
  // List<entity.Product> findByPriceBetween(Double minPrice, Double maxPrice);
  // List<entity.Product> findByDescriptionContaining(String keyword);
  // List<entity.Product> findByBrand(String brand);
  // List<entity.Product> findByRating(Double rating);
  // List<entity.Product> findByCreatedAtAfter(LocalDate date);
  // List<entity.Product> findByUpdatedAtAfter(LocalDate date);
  // List<entity.Product> findByStatus(String status);

  // repo have by default saveAll method ,findall method

}

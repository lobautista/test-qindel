package com.qindel.ecommerce.repository;

import com.qindel.ecommerce.model.dto.response.ProductInformationDto;
import com.qindel.ecommerce.model.entity.Price;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInformationRepository extends CrudRepository<Price, Long> {

	@Query("SELECT new com.qindel.ecommerce.model.dto.response.ProductInformationDto(c.brandId," +
			" p.startDate, p.endDate, p.priceList, p.productId, p.priority, p.price, p.curr)" +
			" FROM Price p INNER JOIN p.brandId c WHERE c.brandId = ?1 AND p.productId = ?2" +
			" AND ?3 between p.startDate and p.endDate order by p.priority desc")
	public List<ProductInformationDto> getProductInformation(Long brandId, Integer productId, Timestamp date);
}

package com.syscho.boot.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Soni
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Products")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private int productPrice;
	private String productDescription;

	public ProductEntity(String productName, int productPrice, String productDescription) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}

}

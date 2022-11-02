package com.jlcindiabookstore;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "mybookprice", schema = "jlcbookpricedb")
@ApiModel("BookPrice which contains BookId, price and offer/discount")
public class BookPrice {
	@Id
	@ApiModelProperty("holds BookId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookId_generator")

	@SequenceGenerator(name = "bookId_generator", sequenceName = "mybookId_gen", initialValue = 110, allocationSize = 1)
	@Column(name = "book_id")

	private Integer bookId;
	@Column(name = "price")
	@ApiModelProperty("holds Bookprice")
	private double price;
	@Column(name = "offer")
	@ApiModelProperty("holds Bookoffer")
	private double offer;

	public BookPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookPrice(Integer bookId, double price, double offer) {
		super();
		this.bookId = bookId;
		this.price = price;
		this.offer = offer;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "BookPrice [bookId=" + bookId + ", price=" + price + ", offer=" + offer + "]";
	}

}

package com.jlcindiabookstore;

import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookPriceServiceImpl implements BookPriceService {

	static Logger log = LoggerFactory.getLogger(BookPriceServiceImpl.class);
	@Autowired
	BookPriceDao bprice;

	@Override
	public BookPrice getBookPriceById(int id) {
		log.info("this is our first microoservicces");

		Optional<BookPrice> opt = bprice.findById(id);
		BookPrice bs = null;

		if (opt.isPresent()) {
			bs = opt.get();

		}
		return bs;

	}

	@Override
	public double getBookOfferById(int id) {
		log.info("this is our discount to one book id microoservicces");

		Optional<BookPrice> opt = bprice.findById(id);
		BookPrice bs = null;
		double afterdiscountforonebok = 0.0;

		if (opt.isPresent()) {
			bs = opt.get();
			double bookprice = bs.getPrice();
			double offer = bs.getOffer();
			double discount = bookprice * offer / 100;
			afterdiscountforonebok = bookprice - discount;

		}
		return afterdiscountforonebok;

	}

}

package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidTests {
	@Autowired
	private BidListService bidListService;

	@Test
	public void findBidById(){

		// given
		BidList bidList1 = new BidList();
		bidList1.setAccount("test");
		bidList1.setBidQuantity(229.0);
		bidList1.setType("test");
	//	bidListService.saveBidList(bidList1);

		// when + then
		Optional<BidList> bidListById = bidListService.getBidListById(32);
		assertEquals(bidListById.get().getAccount(), "test");
	}

	@Test
	public  void findAllBidList(){
		Optional<BidList>   bidLists = bidListService.getBidListById(1);
		assertEquals(bidLists.isPresent(),true );
	}


	@Test
	public  void saveBidList(){

		// given
		BidList bidList1 = new BidList();
		bidList1.setAccount("BidList");
		bidList1.setBidQuantity(229.0);
		bidList1.setType("test");

		// Update
		bidList1.setAccount("BidList Update");
		bidList1 = bidListService.saveBidList(bidList1);
		Assert.assertTrue(bidList1.getAccount().equals("BidList Update"));

	}
	@Test
	public  void deleteBidList(){

		BidList bidList = new BidList();
		bidList.setAccount("Test2024");
		bidList.setBidQuantity(229.0);
		bidList.setType("Compte épargne");
		bidListService.saveBidList(bidList);

		Integer id = bidList.getBidListId();
		bidListService.deleteBid(bidList);
		Optional<BidList> listBidList = bidListService.getBidListById(id);
		Assert.assertFalse(listBidList.isPresent());
	}
}

package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BidTests {

	@Autowired
	private BidListRepository bidListRepository;

	@Autowired
	private BidListService bidListService;
	@Test
	public  void saveBidList(){
	/*BidList bid = new BidList("100", "Type Test", 10d);
		BidList bidList = bidListService.saveBidList(bid);
		Assert.assertEquals("15",bidList.getBid());
	 */
		// given
		BidList bidList1 = new BidList();
		bidList1.setAccount("test");
		bidList1.setBidQuantity(229.0);
		bidList1.setType("test");
		bidListService.saveBidList(bidList1);




	}
	@Test
	public  void findBid(){
		//Optional<BidList>  bidList  = bidListService.getBidListById(1);
	//	assertEquals(bidList.isPresent(),true );

		// given
		BidList bidList1 = new BidList();
		bidList1.setAccount("test");
		bidList1.setBidQuantity(229.0);
		bidList1.setType("test");
		bidListService.saveBidList(bidList1);

		// when + then
		Optional<BidList> bidListById = bidListService.getBidListById(17);
		assertEquals(bidListById.get().getAccount(), "test");
	}

	@Test
	public  void findAllBidList(){
		List<BidList>  bidLists  = bidListService.getBidLists();
		assertEquals(bidLists.size(), 5);
	}


	@Test
	public  void deleteBidList(){
		BidList bidList = new BidList();
		List<BidList> bidLists = new ArrayList<>();
		bidList.setAccount("test");
		bidList.setBidQuantity(229.0);
		bidList.setType("test");
		bidLists.add(bidList);
		//bidListService.saveBidList(bidList1);

		bidListService.deleteBid(bidList);
	//	assertEquals(usersEntity.size(), 8);
	}
}

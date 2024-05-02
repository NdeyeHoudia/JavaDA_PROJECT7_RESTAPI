package com.nnk.springboot;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.services.TradeService;
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
public class TradeTests {

	@Autowired
	private TradeService tradeService;

	@Test
	public void findRuleNameById(){

		Optional<Trade> trade1 = tradeService.getTradeById(10);
		assertEquals(trade1.get().getType(), "Epargne");
	}

	@Test
	public  void findAllBidList(){

		List<Trade>  trades  = tradeService.getTrade();
		assertEquals(trades.size(),4 );
	}

	@Test
	public  void saveBidList(){

		// given
		Trade trade = new Trade();
		trade.setAccount("Compte ABBDC");
		trade.setBuyQuantity(200.0);
		trade.setType("Epargne");

		// Save
		trade = tradeService.saveTrade(trade);
		Assert.assertNotNull(trade.getTradeId());
		Assert.assertTrue(trade.getType().equals("Epargne"));

	}
	@Test
	public  void deleteBidList(){

		Trade trade = new Trade();
		trade.setAccount("Compte ABBDC");
		trade.setBuyQuantity(200.0);
		trade.setType("Epargne");
		tradeService.saveTrade(trade);

		Integer id = trade.getTradeId();
		tradeService.deleteTrade(trade);
		Optional<Trade> optionalTrade = tradeService.getTradeById(id);
		Assert.assertFalse(optionalTrade.isPresent());
	}
}

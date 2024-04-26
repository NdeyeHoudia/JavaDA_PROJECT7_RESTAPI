package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;
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
public class RatingTests {

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private RatingService ratingService;

/*	@Test
	public void ratingTest() {
		Rating rating = new Rating("Moodys Rating", "Sand PRating", "Fitch Rating", 10);

		// Save
		rating = ratingRepository.save(rating);
		Assert.assertNotNull(rating.getId());
		Assert.assertTrue(rating.getOrderNumber() == 10);

		// Update
		rating.setOrderNumber(20);
		rating = ratingRepository.save(rating);
		Assert.assertTrue(rating.getOrderNumber() == 20);

		// Find
		List<Rating> listResult = ratingRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = rating.getId();
		ratingRepository.delete(rating);
		Optional<Rating> ratingList = ratingRepository.findById(id);
		Assert.assertFalse(ratingList.isPresent());
	}*/

	@Test
	public  void findBid(){
		//Optional<BidList>  bidList  = bidListService.getBidListById(1);
		//	assertEquals(bidList.isPresent(),true );

		// given
		Rating rating = new Rating();
		rating.setFitchRating("test");
		rating.setMoodysRating("test");
		rating.setOrderNumber(2);
		rating.setSandPRating("logiciel");
		ratingService.saveRating(rating);

		// when + then
		Optional<Rating> rating1 = ratingService.getRatingById(1);
		assertEquals(rating1.get().getFitchRating(), "test");
	}

	@Test
	public  void findAllBidList(){
		List<Rating>  ratingList  = ratingService.getRatings();
		assertEquals(ratingList.size(), 2);
	}

}

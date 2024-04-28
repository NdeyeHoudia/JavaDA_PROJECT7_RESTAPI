package com.nnk.springboot;

import com.nnk.springboot.domain.Rating;
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
	private RatingService ratingService;

		//findAll
		@Test
		public  void findAllRating(){
			List<Rating>  ratingList  = ratingService.getRatings();
			assertEquals(ratingList.size(), 2);
		}
		// findById
		@Test
		public  void findRating(){
			// given
			Rating rating = new Rating();
			rating.setFitchRating("test");
			rating.setMoodysRating("test");
			rating.setOrderNumber(2);
			rating.setSandPRating("logiciel");

			// when + then
			Optional<Rating> rating1 = ratingService.getRatingById(1);
			assertEquals(rating1.get().getFitchRating(), "test");
		}

		//Save
		@Test
		public  void saveRating(){
			// given
			Rating rating = new Rating();
			rating.setFitchRating("test");
			rating.setMoodysRating("MoodysRating(");
			rating.setOrderNumber(2);
			rating.setSandPRating("logiciel");

			// Save
			rating = ratingService.saveRating(rating);
			Assert.assertNotNull(rating.getId());
			Assert.assertTrue(rating.getMoodysRating().equals("MoodysRating("));
		}
		@Test
		public  void deleteRating(){

			Rating rating = new Rating();
			rating.setFitchRating("test");
			rating.setMoodysRating("MoodysRating(");
			rating.setOrderNumber(2);
			rating.setSandPRating("logiciel");

			ratingService.saveRating(rating);

			Integer id = rating.getId();
			ratingService.deleteRating(rating);
			Optional<Rating> ratingList = ratingService.getRatingById(id);
			Assert.assertFalse(ratingList.isPresent());
		}
}

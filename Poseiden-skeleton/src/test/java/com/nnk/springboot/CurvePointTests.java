package com.nnk.springboot;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurvePointService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointTests {
	@Autowired
	private CurvePointService curvePointService;

	//findAll
	@Test
	public  void findBidById (){
		Optional<CurvePoint>  curvePoint  = curvePointService.getCurvePointById(1);
		assertEquals(curvePoint.isPresent(),true );
	}
	//findById
	@Test
	public void findAllCurvePoint(){

		List<CurvePoint> curvePoints = curvePointService.getCurvePoint();
		assertNotNull(curvePoints.size());
		// given
	}

	//Save
	@Test
	public  void saveCurvePoint(){

		// given
		CurvePoint curvePoint1 = new CurvePoint();
		curvePoint1.setTerm(129.0);
		curvePoint1.setValue(229.0);

		// Update
		curvePoint1.setValue(300.0);
		curvePoint1 = curvePointService.saveCurvePoint(curvePoint1);
		Assert.assertTrue(curvePoint1.getValue().equals(300.0));

	}
	//delete
	@Test
	public  void deleteCurvePoint(){

		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setTerm(19.0);
		curvePoint.setValue(30.0);
		curvePointService.saveCurvePoint(curvePoint);

		Integer id = curvePoint.getId();
		curvePointService.deleteCurvePoint(curvePoint);
		Optional<CurvePoint> listById = curvePointService.getCurvePointById(id);
		Assert.assertFalse(listById.isPresent());
	}

}

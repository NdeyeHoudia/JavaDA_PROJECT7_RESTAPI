package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointTests {
	@Autowired
	private CurvePointService curvePointService;

	@Test
	public  void findAllCurvePoint(){
		Optional<CurvePoint>  curvePoint  = curvePointService.getCurvePointById(1);
		assertEquals(curvePoint.isPresent(),true );
	}

	@Test
	public void findBid(){

		// given
		CurvePoint curvePoint1 = new CurvePoint();
		curvePoint1.setTerm(129.0);
		curvePoint1.setValue(229.0);
		curvePointService.saveCurvePoint(curvePoint1);

		// when + then
		Optional<CurvePoint> listById = curvePointService.getCurvePointById(11);
		assertEquals(listById.get().getTerm(), 129.0);
	}

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
	@Test
	public  void deleteCurvePoint(){

		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setValue(12.0);
		curvePoint.setTerm(19.0);
		curvePointService.saveCurvePoint(curvePoint);

		Integer id = curvePoint.getCurveId();
		curvePointService.deleteCurvePoint(curvePoint);
		Optional<CurvePoint> listById = curvePointService.getCurvePointById(id);
		Assert.assertFalse(listById.isPresent());
	}

}

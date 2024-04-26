package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;
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
	private CurvePointRepository curvePointRepository;
	@Autowired
	private CurvePointService curvePointService;

	@Test
	public  void findCurvePoint(){
		Optional<CurvePoint>  curvePoint  = curvePointService.getCurvePointById(1);
		assertEquals(curvePoint.isPresent(),true );
/*
		// given
		CurvePoint curvePoint1 = new CurvePoint();
		curvePoint1.setTerm(129.0);
		curvePoint1.setValue(229.0);
		curvePointService.saveCurvePoint(curvePoint1);

		// when + then
		Optional<CurvePoint> curvePoint2 = curvePointService.getCurvePointById(2);
		assertEquals(curvePoint2.get().getTerm(), 129.0);

 */
	}
	@Test
	public  void findAllCurvePoint(){
		List<CurvePoint>  curvePoints  = curvePointService.getCurvePoint();
		assertEquals(curvePoints.size(), 2);
	}



}

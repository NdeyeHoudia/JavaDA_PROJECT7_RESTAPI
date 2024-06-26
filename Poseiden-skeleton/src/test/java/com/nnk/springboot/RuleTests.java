package com.nnk.springboot;


import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.RuleNameService;
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
public class RuleTests {

	@Autowired
	private RuleNameService ruleNameService;

		//findAll
		@Test
		public  void findRuleNameById(){
			Optional<RuleName>  ruleNames  = ruleNameService.getRuleNameById(1);
			assertEquals(ruleNames.isPresent(),true );
		}
		@Test
		public void findAllBidList(){

			// when + then
			List<RuleName> ruleNames = ruleNameService.getRuleName();
			assertNotNull(ruleNames.size());
		}

		// save
		@Test
		public  void saveBidList(){

			// given
			RuleName ruleName = new RuleName();
			ruleName.setName("Testeur");
			ruleName.setDescription("description rule");
			ruleName.setJson("json ");
			ruleName.setTemplate("template");
			ruleName.setSqlStr("sqlstr");
			ruleName.setSqlPart("sql ");

			// Save
			ruleName = ruleNameService.saveRuleName(ruleName);
			Assert.assertNotNull(ruleName.getId());
			Assert.assertTrue(ruleName.getName().equals("Testeur"));

		}
		//delete
		@Test
		public  void deleteBidList(){

			RuleName ruleName = new RuleName();
			ruleName.setName("test");
			ruleName.setDescription("description rule");
			ruleName.setJson("json ");

			ruleNameService.saveRuleName(ruleName);

			Integer id = ruleName.getId();
			ruleNameService.deleteRuleName(ruleName);
			Optional<RuleName> ruleNameList = ruleNameService.getRuleNameById(id);
			Assert.assertFalse(ruleNameList.isPresent());
		}
}

package lt.help.desk.bd.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lt.help.desk.bd.gedimai.PatikrintiPateiktaArgumenta;
import lt.help.desk.bd.klasifikatoriai.Vaidmenys;
import lt.help.desk.bd.most.important.LoginUserFromMySql;

class UnitTestas {
	LoginUserFromMySql loginUserFromMySql = new LoginUserFromMySql();

	@Test
	void userConnectionTest() {
		boolean result = loginUserFromMySql.getUserConnection("001", "1111", Vaidmenys.user);
		assertEquals(true, result);
	}

}

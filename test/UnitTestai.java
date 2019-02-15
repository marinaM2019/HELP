
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lt.help.desk.bd.klasifikatoriai.Vaidmenys;
import lt.help.desk.bd.most.important.LoginUserFromMySql;
import lt.help.desk.bd.most.important.PatikrintiNaujoUserDuomenys;

class UnitTestai {
	LoginUserFromMySql loginUserFromMySql = new LoginUserFromMySql();
	PatikrintiNaujoUserDuomenys patikrintiDuomenys = new PatikrintiNaujoUserDuomenys();

	@Test
	void userConnectionTest() {
		boolean result = loginUserFromMySql.getUserConnection("001", "1111", Vaidmenys.user);
		assertEquals(true, result);
	}

	@Test
	void patikrintiDUomenysTest() {
		boolean arSutampa = patikrintiDuomenys.arSlaptazodisSutampa("1234", "1234");
		assertEquals(true, arSutampa);
	}

}

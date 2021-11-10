package com.etisalat.imrh;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CountryServiceTest.class,
	CityServiceTest.class,
	BankServiceTest.class,
	WalletServiceTest.class,
	ProductServiceTest.class,
	PartnerServiceTest.class,
	PartnerCustomerServiceTest.class,
	ResourceServiceTest.class,
//	AppUserServiceTest.class,
//	AppNotificationServiceTest.class
})
class ImrhApplicationTests {

}

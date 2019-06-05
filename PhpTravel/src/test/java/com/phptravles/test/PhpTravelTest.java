package com.phptravles.test;

import org.testng.annotations.Test;

import com.phptravel.pages.PhpFrontPage;
import com.phptravles.library.PhpBasePage;;

public class PhpTravelTest extends PhpBasePage {
	
	PhpFrontPage PhpFP = new PhpFrontPage();
	 
	@Test
	public void callPhpmeathods() {
		
		PhpFP.PhpTravelLogin();
		//PhpFP.PhpHotel();
		
		
	}
	
}

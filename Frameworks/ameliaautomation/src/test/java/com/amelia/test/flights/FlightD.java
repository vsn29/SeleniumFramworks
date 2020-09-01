package com.amelia.test.flights;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amelia.utility.Base;

public class FlightD extends Base {

	@Test
	@Parameters({ "url" })
	public void oneWayFlightSearch(@Optional("https://www.flipkart.com") String url)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		String str = "Santosh";
		switch (str) {

		case "nishanth":

			System.out.println("I am nishanth..");
			break;

		case "Karthik":
			System.out.println("I am Karthik..");
			break;

		case "Jayalaxmi":
			System.out.println("I am Jayalaxmi..");
			break;
			
		case "abc":
			System.out.println("I am abc..");
			break;

		case "abc1":
			System.out.println("I am abc1..");
			break;

        default:
        	
        	System.out.println("Default code to be executed..");
		}
	}

}

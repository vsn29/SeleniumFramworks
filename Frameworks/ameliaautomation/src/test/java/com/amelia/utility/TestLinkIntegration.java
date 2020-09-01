package com.amelia.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class TestLinkIntegration {

	public String TESTLINK_KEY = "5a303074383870f360bb0a1fb45b92b6";
	public String TESTLINK_URL = "http://localhost/testlink/lib/api/xmlrpc.php";
	public static final String TEST_PROJECT_NAME = "Flipkart";
	public static final String TEST_PLAN_NAME = "Release-01";
	public static final String TEST_CASE_NAME = "Sample";
	public static final String BUILD_NAME = "Build-01";

	HashMap<String, String> mp = new HashMap<String, String>();

	public void updateTestCaseResult(Integer testCaseId, Integer testCaseExternalId, Integer testPlanId,
			String platform, String status) throws TestLinkAPIException, MalformedURLException {

		TestLinkAPI tc1 = new TestLinkAPI(new URL(TESTLINK_URL), TESTLINK_KEY);

		System.out.println("Before Execution------");

		if (status == "PASS") {
			tc1.reportTCResult(testCaseId, testCaseExternalId, testPlanId, ExecutionStatus.PASSED, 1, "build-1",
					"notes", true, "", 1, platform, mp, true);

		} else if (status == "FAIL") {
			tc1.reportTCResult(testCaseId, testCaseExternalId, testPlanId, ExecutionStatus.FAILED, 1, "build-1",
					"notes", true, "", 1, platform, mp, true);

			System.out.println("In FAIL Condition---------------------");
		} else if (status == "BLOCKED") {
			tc1.reportTCResult(testCaseId, testCaseExternalId, testPlanId, ExecutionStatus.BLOCKED, 1, "build-1",
					"notes", true, "", 1, platform, mp, true);
		}

		System.out.println("After Execution-------");
	}

}

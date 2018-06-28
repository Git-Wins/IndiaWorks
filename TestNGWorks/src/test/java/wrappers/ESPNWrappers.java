package wrappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.DataInputProvider;

public class ESPNWrappers extends GenericWrappers {

	public String browserName;
	public String dataSheetName;
	static String currentDte, trimDate;
	static String trimmedInput, inputToLCase;
	static String playerDetails, playerPosition, matchesPlayed, goalsScored;
	static String finalFetchedStrInput1A, finalFetchedStrInput1AGenericWrappersA, finalFetchedStrInput1AA;
	static String finalFetchedIntInput1A, finalFetchedIntInput1AA;
	static String finalFetchedTiming1A, finalFetchedTiming1AA;
	static String finalFetchedStrInputLong1A, finalFetchedStrInputLong1AA;
	static String finalFetchedGoals1A, finalFetchedGoals1AA;
	static String currentTeam, opponentTeam;
	static String Team1Percentage, Team2Percentage;
	static String TrimmedTeam1Percentage, TrimmedTeam2Percentage;
	static String lastMatchTeam1Name, lastMatchTeam2Name, lastMatchTeam1Score, lastMatchTeam2Score;
	static String matchValue;
	static String teamNameLastMatch, teamScoreLastMatch;
	static int T1Percentage, T2Percentage, TotalPercentage;
	static int parsedCurrentDte, parsedpageDte;
	static int CountofTableContents;
	static int lastMatchTeamAScore, lastMatchTeamBScore;
	static int teamGoalsScored;
	static int adCount;
	static int playersCount;
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
	Date calDate;

	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authors);
		invokeApp(browserName);
	}

	@AfterMethod
	public void afterMethod(){
		endTestcase();
		quitBrowser();
	}
	
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}

	//To check whether the error message pops up while logged in, if so PASS
	public void errorMessagePASS() {
		try {
			switchToFrame("disneyid-iframe");
			System.out.println("SUCCESS! - Log-In Failed as expected");
			reportStep("Log-In Failed as expected", "PASS");
		}catch (Exception e) {
			reportStep("Unknown exception occured while fetching data", "FAIL");
		}
	}

	//To check whether the error message pops up while logged in, if so FAIL
	public void errorMessageFAIL() {
		try {
			switchToFrame("disneyid-iframe");
			System.out.println("FAIL - Log In Failed due to technical difficulties");
			reportStep("Log-In Failed due to technical difficulties", "FAIL");
		}
		catch (NoSuchElementException e) {
			reportStep("Log-In successfull", "FAIL");
		}catch (Exception e) {
			reportStep("Unknown exception occured while fetching data", "FAIL");
		}
	}

	//To verify the presence of the Current Team in the Last Match section
	public boolean verifyTeamPresentLastMatch()
	{
		String Team1Name = driver.findElement(By.xpath("//div[@class='last-match']/div/div/div/div/div[1]")).getText();
		System.out.println(Team1Name);
		String Team2Name = driver.findElement(By.xpath("//div[@class='last-match']/div/div/div/div/div[1]")).getText();
		System.out.println(Team2Name);
		boolean bReturn = false;
		try {
			if(Team1Name.contains("Leicester City")){
				System.out.println("In the Last_Match-section, the Team1 is identified to be 'Leicester City'");
				reportStep("In the Last_Match-section, the Team1 is identified to be 'Leicester City'", "PASS");
				bReturn = true;
			}else{
				if(Team2Name.contains("Leicester City")){
					System.out.println("In the Last_Match-section, the Team2 is identified to be 'Leicester City'");
					reportStep("In the Last_Match-section, the Team2 is identified to be 'Leicester City'", "PASS");
					bReturn = true;
				}
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	//To verify the presence of the Current Team in the Next Match section
	public boolean verifyTeamPresentNextMatch()
	{
		String Team1Name = driver.findElement(By.xpath("//div[@class='next-match']/div/div/div/div/div[1]")).getText();
		String Team2Name = driver.findElement(By.xpath("//div[@class='next-match']/div/div/div/div/div[2]")).getText();
		boolean bReturn = false;
		try {
			if(Team1Name.contains("Leicester City")){
				System.out.println("In the Next_Match-section, the Team1 is identified to be 'Leicester City'");
				reportStep("In the Next_Match-section, the Team1 is identified to be 'Leicester City'", "PASS");
				bReturn = true;
			}else{
				if(Team2Name.contains("Leicester City")){
					System.out.println("In the Next_Match-section, the Team2 is identified to be 'Leicester City'");
					reportStep("In the Next_Match-section, the Team2 is identified to be 'Leicester City'", "PASS");
					bReturn = true;
				}
			}
		}catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	//To verify the last match-status of Leicester City
	public void verifyLeiCityLastMatchStatus()
	{
		lastMatchTeam1Name = driver.findElement(By.xpath("(//a[@class='team-name'])[1]")).getText();
		lastMatchTeam1Score = driver.findElement(By.xpath("//span[@class='score icon-font-after']")).getText();
		lastMatchTeamAScore = Integer.parseInt(lastMatchTeam1Score);
		lastMatchTeam2Name = driver.findElement(By.xpath("(//a[@class='team-name'])[2]")).getText();
		lastMatchTeam2Score = driver.findElement(By.xpath("//span[@class='score icon-font-before']")).getText();
		lastMatchTeamBScore = Integer.parseInt(lastMatchTeam2Score);

		try {
			if(lastMatchTeamAScore>lastMatchTeamBScore)
			{
				if(lastMatchTeam1Name.contains("Leicester City"))
				{
					System.out.println("Leicester City won it's last match with "+"'"+lastMatchTeam2Name+"'"+" by "+lastMatchTeam1Score+" goals");
					reportStep("Leicester City won it's last match", "PASS");
				}else{
					System.out.println("Leicester City lost it's last match with "+"'"+lastMatchTeam1Name+"'"+" by "+(lastMatchTeamAScore-lastMatchTeamBScore)+" goals");
					reportStep("Leicester City lost it's last match", "PASS");
				}
			}else{
				if(lastMatchTeamAScore==lastMatchTeamBScore)
				{
					System.out.println("Leicester City's last match was a draw with both the teams scoring "+lastMatchTeamAScore+" goals each");
					reportStep("Leicester City's last match was a draw", "PASS");
				}
			}
		} catch (NoSuchElementException e) {
			reportStep("The stated element could not be located", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while locating the stated element", "FAIL");
		}
	}

	//Verify Ads count
	public void verifyAdsOnHomePage()
	{
		adCount=0;
		try {
			List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
			for(WebElement frame : totalFrames)
			{
				matchValue = frame.getAttribute("title");
				if(matchValue.equalsIgnoreCase("3rd party ad content"))
				{
					adCount++;
				}
			}
			if(adCount==7)
			{
				System.out.println("The total no. of Ads in the Home and Login page is verified to be 7");
				reportStep("The total no. of Ads in the Home and Login page is verified to be 7", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The stated element could not be located", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while locating the stated element", "FAIL");
		}
	}

	//To verify the score and the details displayed are unique-Last Match report page
	public void scoreAndPlayerDetailsVerify(String xPathValTeamName, String xPathValScore, String xPathValPlayers)
	{
		try {
			teamNameLastMatch = driver.findElement(By.xpath(xPathValTeamName)).getText();
			teamScoreLastMatch = driver.findElement(By.xpath(xPathValScore)).getText();
			teamGoalsScored = Integer.parseInt(teamScoreLastMatch);
			if(teamGoalsScored>=1)
			{
				WebElement scoredPlayers = driver.findElement(By.xpath(xPathValPlayers));
				List<WebElement> playersList = scoredPlayers.findElements(By.tagName("li"));
				playersCount = playersList.size();
				if(teamGoalsScored == playersCount)
				{
					System.out.println("The team: "+teamNameLastMatch+"'s Score and Player details match");
					reportStep("The team: "+teamNameLastMatch+"'s Score and Player details match", "PASS");
				}else
				{
					System.out.println("The team: "+teamNameLastMatch+"'s Score and Player details DO NOT match");
					reportStep("The team: "+teamNameLastMatch+"'s Score and Player details DO NOT match", "FAIL");
				}
			}else{
				System.out.println("The team: "+teamNameLastMatch+" scored no goals");
				reportStep("The team: "+teamNameLastMatch+" scored no goals", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The stated element could not be located", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while locating the stated element", "FAIL");
		}
	}

	//To verify the total percentage of 2 teams
	public void verifyTotalPercent(){
		Team1Percentage = getTextByXpath("(//div[@class='possession']//span)[3]");
		TrimmedTeam1Percentage = Team1Percentage.substring(0, 2);
		T1Percentage = Integer.parseInt(TrimmedTeam1Percentage);
		Team2Percentage = getTextByXpath("(//div[@class='possession']//span)[6]");
		TrimmedTeam2Percentage = Team2Percentage.substring(0, 2);
		T2Percentage = Integer.parseInt(TrimmedTeam2Percentage);
		TotalPercentage = T1Percentage + T2Percentage;
		try 
		{
			if(TotalPercentage==100)
			{
				System.out.println("The posession of both the teams sums up to 100");
				reportStep("The posession of both the teams sums up to 100", "PASS");
			}
			else
			{
				System.out.println("The posession of both the teams DOES NOT sum up to 100");
				reportStep("The posession of both the teams does NOT sums up to 100", "FAIL");
			}
		}catch (NoSuchElementException e) {
			reportStep("The element could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding the element", "FAIL");
		}
	}

	//get Team's total goals scored
	public void getTeamGoalsScoredCount(){
		String TeamName =subStringBegEndIndexesXpath("//li[@class='stat-box']//span", 0, 4);
		try {
			if(TeamName.contains("LEI"))
			{
				String Team1TotalGoalCount = driver.findElement(By.xpath("(//li[@class='stat-box']//span)[5]")).getText();
				System.out.println("Team1-Leicester's Goals Count: " +Team1TotalGoalCount );
				reportStep("Team1-Leicester's Goals Count is verified to be: "+Team1TotalGoalCount, "PASS");
			}	
			else
			{
				String Team2TotalGoalCount = driver.findElement(By.xpath("(//li[@class='stat-box']//span)[8]")).getText();
				System.out.println("Team2-Leicester's Goals Count: " + Team2TotalGoalCount );
				reportStep("Team2-Leicester's Goals Count is verified to be: "+Team2TotalGoalCount, "PASS");
			}
		}catch (NoSuchElementException e) {
			reportStep("The element could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding the element", "FAIL");
		}
	}

	//get Team's total goals conceded
	public void getTeamGoalsConcededCount(){
		String TeamName =subStringBegEndIndexesXpath("(//li[@class='stat-box']//span)[11]", 0, 4);
		try {
			if(TeamName.contains("LEI"))
			{
				String Team1GoalsConcededCount = driver.findElement(By.xpath("(//li[@class='stat-box']//span)[15]")).getText();
				System.out.println("Team1-Leicester's Goals Conceded Count: " +Team1GoalsConcededCount);
				reportStep("Team1-Leicester's Goals Conceded Count is verified to be: "+Team1GoalsConcededCount, "PASS");
			}	
			else
			{
				String Team2GoalsConcededCount = driver.findElement(By.xpath("(//li[@class='stat-box']//span)[18]")).getText();
				System.out.println("Team2-Leicester's Goals Conceded Count: " + Team2GoalsConcededCount);
				reportStep("Team2-Leicester's Goals Conceded Count is verified to be: "+Team2GoalsConcededCount, "PASS");
			}
		}catch (NoSuchElementException e) {
			reportStep("The element could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding the element", "FAIL");
		}	
	}

	//get player info
	public void getPlayerInfo(String xPathVal){
		try {
			playerDetails = driver.findElement(By.xpath(xPathVal)).getText();
			if(playerDetails.length()==28){
				playerPosition = playerDetails.substring(0, 7); 
				System.out.println(playerPosition);
				matchesPlayed = playerDetails.substring(17, 19);
				System.out.println(matchesPlayed);
				goalsScored = playerDetails.substring(27);
				System.out.println(goalsScored);
				reportStep("Player details fetched successfully", "PASS");
			}else{
				if(playerDetails.length()==31){
					playerPosition = playerDetails.substring(0, 10); 
					System.out.println(playerPosition);
					matchesPlayed = playerDetails.substring(20, 22);
					System.out.println(matchesPlayed);
					goalsScored = playerDetails.substring(30);
					System.out.println(goalsScored);
					reportStep("Player details fetched successfully", "PASS");
				}
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xPathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xPathVal, "FAIL");
		}
	}

	//verify player position
	public void verifyPlayerPosition(String xPathVal){
		try {
			String aa = driver.findElement(By.xpath(xPathVal)).getText();
			if(aa.contains(playerPosition)){
				System.out.println("Player-Position verified");
				reportStep("Player-Position verified", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xPathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xPathVal, "FAIL");
		}
	}

	//verify player's matches played count 
	public void verifyPlayerMatches(String xPathVal){
		try {
			String aa = driver.findElement(By.xpath(xPathVal)).getText();
			int aaLength = aa.length();
			if(aaLength <= 7)
			{
				String trimmedAa1 = aa.substring(0, 1);
				if(trimmedAa1.contains(matchesPlayed))
				{
					System.out.println("Player-Matches verified");
					reportStep("Player-Matches verified", "PASS");
				}
			}
			else
			{
				if(aaLength >7)
				{
					String trimmedAa2 = aa.substring(0, 2);
					if(trimmedAa2.contains(matchesPlayed))
					{
						System.out.println("Player-Matches verified");
						reportStep("Player-Matches verified", "PASS");
					}	
				}
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xPathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xPathVal, "FAIL");
		}	
	}

	//verify player's goals scored count 
	public void verifyPlayerGoals(String xPathVal){
		try {
			String aa = driver.findElement(By.xpath(xPathVal)).getText();
			int aaLength = aa.length();
			if(aaLength == 7)
			{
				if(aa.substring(0, 1).contains(goalsScored))
				{
					System.out.println("Player-Goals verified");
					reportStep("Player-Goals verified", "PASS");
				}
			}
			else
			{
				if(aaLength == 8)
				{
					if(aa.substring(0, 2).contains(goalsScored))
					{
						System.out.println("Player-Goals verified");
						reportStep("Player-Goals verified", "PASS");
					}
				}
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xPathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xPathVal, "FAIL");
		}	
	}

	//To fetch an Input 
	public void fetchInput(String xpathVal,int i)
	{ try{
		String inputFetched = driver.findElement(By.xpath(xpathVal)).getText();
		int inputFetchedLength = inputFetched.length();
		if (inputFetchedLength==3){
			trimmedInput = inputFetched.substring(0, 1);
			inputToLCase = inputFetched.substring(1, 3).toLowerCase();
			switch(i){
			case 0:
				finalFetchedStrInput1A=trimmedInput+inputToLCase;
				System.out.println("The fetched String input-finalFetchedStrInput1A is "+"'"+finalFetchedStrInput1A+"'");
				reportStep("The String input: "+finalFetchedStrInput1A+" has been fetched", "PASS");
				break;
			case 1:
				finalFetchedStrInput1AA=trimmedInput+inputToLCase;
				System.out.println("The fetched String input-finalFetchedStrInput1AA is "+"'"+finalFetchedStrInput1AA+"'");
				reportStep("The input: "+finalFetchedStrInput1AA+ " has been fetched", "PASS");
				break;
			default:
				System.out.println(i+"is greater than 1");
				reportStep(i+" is greater than 1", "FAIL");
			}
		}else{
			if (inputFetchedLength==1){
				switch(i){
				case 0:
					finalFetchedIntInput1A=driver.findElement(By.xpath(xpathVal)).getText();
					System.out.println("The fetched Integer input-finalFetchedIntInput1A is "+"'"+finalFetchedIntInput1A+"'");
					reportStep("The Integer input: "+finalFetchedIntInput1A+ " has been fetched", "PASS");
					break;
				case 1:
					finalFetchedIntInput1AA=driver.findElement(By.xpath(xpathVal)).getText();
					System.out.println("The fetched Integer input-finalFetchedIntInput1AA is "+"'"+finalFetchedIntInput1AA+"'");
					reportStep("The Integer input: "+finalFetchedIntInput1AA+ " has been fetched", "PASS");
					break;
				default:
					System.out.println(i+"is greater than 1");
					reportStep(i+" is greater than 1", "FAIL");
				}
			}else{
				if (inputFetchedLength==7){
					switch(i){
					case 0:
						finalFetchedTiming1A=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched Timing-finalFetchedTiming1A is "+"'"+finalFetchedTiming1A+"'");
						reportStep("The Timing: "+finalFetchedTiming1A+ " has been fetched", "PASS");
						break;
					case 1:
						finalFetchedTiming1AA=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched Timing-finalFetchedTiming1AA is "+"'"+finalFetchedTiming1AA+"'");
						reportStep("The Timing: "+finalFetchedTiming1AA+ " has been fetched", "PASS");
						break;
					default:
						System.out.println(i+"is greater than 1");
						reportStep(i+" is greater than 1", "FAIL");
					}
				}else{
					switch(i){
					case 0:
						finalFetchedStrInputLong1A=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input-finalFetchedStrInputLong1A is "+"'"+finalFetchedStrInputLong1A+"'");
						reportStep("The input: "+finalFetchedStrInputLong1A+ " has been fetched", "PASS");
						break;
					case 1:
						finalFetchedStrInputLong1AA=driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input-finalFetchedStrInputLong1AA is "+"'"+finalFetchedStrInputLong1AA+"'");
						reportStep("The input: "+finalFetchedStrInputLong1AA+ " has been fetched", "PASS");
						break;
					case 2:
						currentTeam =driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input-finalFetchedStrInputLong1AA(Current Team) is "+"'"+currentTeam+"'");
						reportStep("The input: "+finalFetchedStrInputLong1AA+ " has been fetched", "PASS");
						break;
					case 3:
						opponentTeam =driver.findElement(By.xpath(xpathVal)).getText();
						System.out.println("The fetched input-finalFetchedStrInputLong1AA(Opponent Team) is "+"'"+opponentTeam+"'");
						reportStep("The input: "+finalFetchedStrInputLong1AA+ " has been fetched", "PASS");
						break;
					default:
						System.out.println(i+"is greater than 2");
						reportStep(i+" is greater than 2", "FAIL");
					}	
				}
			}
		}
	}
	catch(NoSuchElementException e)
	{
		System.out.println("Unable to fetch the target");
		reportStep("Element not fetched", "FAIL");
	}
	}

	//To verify the fetched Input
	public void verifyInput(String xpathValue, int k)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpathValue))));
			String ddeeff = driver.findElement(By.xpath(xpathValue)).getText();
			int FSTIBLength = ddeeff.length();

			if(FSTIBLength==4 && (ddeeff.contains("/"))){
				switch(k){
				case 0:
					if(ddeeff.contains(finalFetchedStrInputLong1A))
					{
						System.out.println("The input: "+ddeeff+" is Verified");
						reportStep("The input: "+ddeeff+" is Verified", "PASS");
						break;
					}
				case 1:
					if(ddeeff.contains(finalFetchedStrInputLong1AA))
					{
						System.out.println("The input: "+ddeeff+" is Verified");
						reportStep("The input: "+ddeeff+" is Verified", "PASS");
						break;
					}
				default:
					System.out.println(k+" is greater than 1");
					reportStep(k+" is greater than 1", "FAIL");
				}
			}else{
				if(FSTIBLength<=1){
					switch(k){
					case 0:
						if(ddeeff.contains(finalFetchedIntInput1A))
						{
							System.out.println("The input: "+ddeeff+" is Verified");
							reportStep("The input: "+ddeeff+" is Verified", "PASS");
							break;
						}
					case 1:
						if(ddeeff.contains(finalFetchedIntInput1AA))
						{
							System.out.println("The input: "+ddeeff+" is Verified");
							reportStep("The input: "+ddeeff+" is Verified", "PASS");
							break;
						}
					default:
						System.out.println(k+" is greater than 1");
						reportStep(k+" is greater than 1", "FAIL");
					}	
				}else{
					if(FSTIBLength>1 && ddeeff.contains("IST")){
						switch(k){
						case 0:
							if(ddeeff.contains(finalFetchedTiming1A))
							{
								System.out.println("The Timing: "+ddeeff+" is Verified");
								reportStep("The Timing: "+ddeeff+" is Verified", "PASS");
								break;
							}
						case 1:
							if(ddeeff.contains(finalFetchedTiming1AA))
							{
								System.out.println("The Timing: "+ddeeff+" is Verified");
								reportStep("The Timing: "+ddeeff+" is Verified", "PASS");
								break;
							}
						default:
							System.out.println(k+" is greater than 1");
							reportStep(k+" is greater than 1", "FAIL");
						}
					}else{
						if(FSTIBLength>1 && (ddeeff.contains("Premier"))){
							switch(k){
							case 0:
								if(ddeeff.contains(finalFetchedStrInputLong1A))
								{
									System.out.println("The input: "+ddeeff+" is Verified");
									reportStep("The input: "+ddeeff+" is Verified", "PASS");
									break;
								}
							case 1:
								if(ddeeff.contains(finalFetchedStrInputLong1AA))
								{
									System.out.println("The input: "+ddeeff+" is Verified");
									reportStep("The input: "+ddeeff+" is Verified", "PASS");
									break;
								}
							default:
								System.out.println(k+" is greater than 1");
								reportStep(k+" is greater than 1", "FAIL");
							}
						}else{
							if(FSTIBLength>1){
								switch(k){
								case 0:
									if(ddeeff.contains(finalFetchedStrInput1A))
									{
										System.out.println("The input: "+ddeeff+" is Verified");
										reportStep("The input: "+ddeeff+" is Verified", "PASS");
										break;
									}
								case 1:
									if(ddeeff.contains(finalFetchedStrInput1AA))
									{
										System.out.println("The input: "+ddeeff+" is Verified");
										reportStep("The input: "+ddeeff+" is Verified", "PASS");
										break;
									}
								case 2:
									if(ddeeff.contains(currentTeam))
									{
										System.out.println("The input: "+ddeeff+" is Verified");
										reportStep("The input: "+ddeeff+" is Verified", "PASS");
										break;
									}
								case 3:
									if(ddeeff.contains(opponentTeam))
									{
										System.out.println("The input: "+ddeeff+" is Verified");
										reportStep("The input: "+ddeeff+" is Verified", "PASS");
										break;
									}

								default:
									System.out.println(k+" is greater than 1");
									reportStep(k+" is greater than 1", "FAIL");
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("The verification failed");
			reportStep("The input: is Not Verified :", "FAIL");
		}
	}

	//To fetch the Current-Calendar date
	public Date toFetchCalendarDate() throws ParseException{
		try {
			Date currentDate = new Date();
			String formattedCurrentDate=sdf.format(currentDate);
			calDate = sdf.parse(formattedCurrentDate);
		} catch (Exception e) {
			System.out.println("Unable to fetch the Calendar Date");
			reportStep("Unknown exception occured while fetching the Calendar date", "FAIL");
		}
		return calDate;
	}

	//To verify the last match date
	public void toVerifyLastMatchDate(String xpathVal) throws ParseException{
		try {
			String dateToBeVerified=driver.findElement(By.xpath(xpathVal)).getText();
			String dateToBeVerified1=dateToBeVerified.substring(2);
			Date lastMatchDate=sdf.parse(dateToBeVerified1);
			System.out.println("Fetched Date: "+lastMatchDate);
			if(lastMatchDate.before(toFetchCalendarDate())){
				System.out.println("The fetched date is verified to be earlier than the current date");
				reportStep("The fetched date is verified to be earlier than the current date", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}

	//To verify the next match date
	public void toVerifyNextMatchDate(String xpathVal) throws ParseException{
		try {
			String dateToBeVerified=driver.findElement(By.xpath(xpathVal)).getText();
			String dateToBeVerified1=dateToBeVerified.substring(2);
			Date nextMatchDate=sdf.parse(dateToBeVerified1);
			System.out.println("Fetched Date: "+nextMatchDate);
			if(nextMatchDate.after(toFetchCalendarDate())){
				System.out.println("The fetched date is verified to be in the future");
				reportStep("The fetched date is verified to be in the future", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}

	//To verify the count of Main players in a team
	public void verifyCountofMainPlayers(String xpathVal){
		try {
			WebElement tableToFetch = driver.findElement(By.xpath(xpathVal));
			List<WebElement> tableContents = tableToFetch.findElements(By.tagName("tr"));
			CountofTableContents = tableContents.size();
			if(CountofTableContents==11){
				System.out.println("Hence the count of Main Players is verified to be 11");
				reportStep("Count of Main Players is verified", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}

	//To verify the count of Substitute players in a team
	public void verifyCountofSubstitutePlayers(String xpathVal){
		try {
			WebElement tableToFetch = driver.findElement(By.xpath(xpathVal));
			List<WebElement> tableContents = tableToFetch.findElements(By.tagName("tr"));
			CountofTableContents = tableContents.size();
			if(CountofTableContents>=3){
				System.out.println("Hence the count of Substitute Players is verified to be greater than or equal to 3");
				reportStep("Count of Substitute Players is verified", "PASS");
			}
		} catch (NoSuchElementException e) {
			reportStep("The element: "+xpathVal+" could not be found", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while finding "+xpathVal, "FAIL");
		}
	}
}







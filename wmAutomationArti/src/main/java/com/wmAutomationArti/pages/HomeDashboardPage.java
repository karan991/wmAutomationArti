package com.wmAutomationArti.pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.wmAutomationArti.testBase.testBase;
import com.wmAutomationArti.util.JDBCConnection;
import com.wmAutomationArti.util.JSExecutorUtils;
import com.wmAutomationArti.util.testUtil;
import net.bytebuddy.description.modifier.Visibility;

public class HomeDashboardPage extends testBase {

	ResultSet rs = null;

	@FindBy(xpath = "//div[@ng-init='board.getDashboardTopCount()']//div[@class='mini-charts-item bgm-cyan']//small[@class='ng-binding']")
	WebElement MT4UsersLabel;

	@FindBy(xpath = "//h2[@ng-if='users']")
	WebElement MT4UsersCount;

	@FindBy(xpath = "//div[@ng-init='board.getDashboardTopCount()']//div[@class='mini-charts-item bgm-lightgreen']//small[@class='ng-binding']")
	WebElement TodaysDepositLabel;

	@FindBy(xpath = "//h2[@ng-if='TodaysDeposit']")
	WebElement TodaysDepositValue;

	@FindBy(xpath = "//div[@ng-init='board.getDashboardTopCount()']//div[@class='mini-charts-item bgm-orange']//small[@class='ng-binding']")
	WebElement TodaysWithdrawalLabel;

	@FindBy(xpath = "//h2[@ng-if='TodaysWithdrawl']")
	WebElement TodaysWithdrawalValue;

	@FindBy(xpath = "//div[@ng-init='board.getDashboardTopCount()']//div[@class='mini-charts-item bgm-bluegray']//small[@class='ng-binding']")
	WebElement TodaysComissionLabel;

	@FindBy(xpath = "//h2[@ng-if='TodaysCommission']")
	WebElement TodaysComissionValue;

	@FindBy(xpath = "//div[@ng-init='board.getDashboardBelowCount()']//div[@class='mini-charts-item bgm-cyan']//small[@class='ng-binding']")
	WebElement TodaysBOCloseTradeLabel;

	@FindBy(xpath = "//h2[@ng-if='BinaryCloseCount']")
	WebElement TodaysBOCloseTradeValue;

	@FindBy(xpath = "//div[@ng-init='board.getDashboardBelowCount()']//div[@class='mini-charts-item bgm-lightgreen']//small[@class='ng-binding']")
	WebElement TodaysForexCloseTradeLabel;

	@FindBy(xpath = "//h2[@ng-if='ForexCloseCount']")
	WebElement TodaysForexCloseTradeValue;

	@FindBy(xpath = "//div[@ng-init='board.getDashboardBelowCount()']//div[@class='mini-charts-item bgm-orange']//small[@class='ng-binding']")
	WebElement TopBOProfitUserLabel;

	@FindBy(xpath = "//h2[@ng-if='TopBoUser']")
	WebElement TopBOProfitUserMt4Id;

	@FindBy(xpath = "//div[@ng-init='board.getDashboardBelowCount()']//div[@class='mini-charts-item bgm-bluegray']//small[@class='ng-binding']")
	WebElement TopFxProfitUserLabel;

	@FindBy(xpath = "//h2[@ng-if='TopFxUser']")
	WebElement TopFxProfitUserMt4Id;

	@FindBy(xpath = "//ul[@class='main-menu']//a[@data-ui-sref ='home']")
	WebElement HomeTab;

	@FindBy(xpath = "//li[@class='sub-menu']/a")
	WebElement WhitelableTabCollapsed;
	
	 /** Here we use one web element to find an element which has two xpaths in
	 * different conditions,So its a tab - which is when clsoed has different xpath
	 * and when open has different xpath*/
	 

	@FindAll({ @FindBy(xpath = "//li[@class='sub-menu']/a"),
			@FindBy(xpath = "//li[@class='sub-menu toggled']/a[contains(text(),Whitelable)]") })
	// @FindBy(xpath="//span[contains(text(),'Whitelabel')]")
	public WebElement WhitelableTab;

	@FindBy(xpath = "//li[@class='sub-menu toggled']/ul//a[@data-ui-sref='whitelabel.users']//span[@class='title ng-binding']")
	public WebElement WhitelableTabExpandManageUsers;

	@FindBy(xpath = "//li[@class='sub-menu toggled']/ul//a[@data-ui-sref='whitelabel.roles']//span[@class='title ng-binding']")
	public WebElement WhitelableTabExpandManageRoles;

	
	 /** @FindAll({ @FindBy(xpath =
	 * "//li[@class='sub-menu slider-toggle ng-scope toggled']//a[@ng-show='1']//span"
	 * ),
	 * 
	 * @FindBy(xpath = "//li[@class='sub-menu slider-toggle ng-scope']//span") })
	 */

	@FindBy(xpath = "//span[contains(text(),'Trading Report')]")
	WebElement TradingReportTab;

	@FindBy(xpath = "//a[@href='#/report/tradingreports?type=ALL_TRANSACTION']/span")
	WebElement TradingReportAllTransaction;

	@FindBy(xpath = "//a[@href='#/report/tradingreports?type=CLOSED_TRADE']/span")
	WebElement TradingReportClosedTrades;

	@FindBy(xpath = "//a[@href='#/report/tradingreports?type=DW']/span")
	WebElement TradingReportDepostWithdraw;

	@FindBy(xpath = "//a[@href='#/report/tradingreports?type=ND']/span")
	WebElement TradingReportNetDpeosit;

	@FindBy(xpath = "//a[@href='#/report/tradingreports?type=OS']/span")
	WebElement TradingReportOverallSummary;

	@FindBy(xpath = "//a[@href='#/report/sponsorsnetdeposit']/span")
	WebElement TradingReportSponserNetDeposit;

	@FindBy(xpath = "//a[@href='#/report/tradingreports?type=OS_TRADING_CLIENTS']/span")
	WebElement TradingReportOverallSummaryWithTradingClient;

	@FindBy(xpath = "//a[@href='#/report/tradingreports?type=Last_Transaction']/span")
	WebElement TradingReportLastTransaction;

	@FindBy(xpath = "//a[@href='#/report/sponserTradingReports?type=DIRECT_SPONSER_TRADING']/span")
	WebElement TradingReportDirectSponsorsDownlineTrading;

	@FindBy(xpath = "//a[@href='#/report/sponserTradingReports?type=SPONSER_TRADING']/span")
	WebElement TradingReportSponsorsTradingVolume;

	@FindBy(xpath = "//span[contains(text(),'Comission Report')]")
	WebElement CommissionReportTab;

	@FindBy(xpath = "//a[@href='#/report/commissionreports?type=COMISSION_REPORT']/span")
	WebElement CommissionReportComissionDetailedReport;

	@FindBy(xpath = "//a[@href='#/report/commissionreports?type=COMISSION_SUMMARY']/span")
	WebElement CommissionReportComissionSummaryReport;

	@FindBy(xpath = "//a[@href='#/report/commissionreports?type=COMISSION_SUMMARY_BO_FX_M']/span")
	WebElement CommissionReportComissionSummaryBO_FX_M;

	@FindBy(xpath = "//span[contains(text(),'Daily Report')]")
	WebElement DailyReportTab;

	@FindBy(xpath = "//a[@href='#/report/dailyreport?type=full']/span")
	WebElement DailyReportTop20Winner;

	@FindBy(xpath = "//a[@href='#/report/dailyreport?type=first_half']/span")
	WebElement DailyReportTop20WinnerFirstHalf;

	@FindBy(xpath = "//a[@href='#/report/dailyreport?type=second_half']/span")
	WebElement DailyReportTop20WinnerSecondHalf;

	@FindBy(xpath = "//a[@href='#/report/dailyreportTop10?type=full']/span")
	WebElement DailyReportTop10Symbols;

	@FindBy(xpath = "//a[@href='#/report/dailyreportTop10?type=first_half']/span")
	WebElement DailyReportTop10SymbolsFirstHalf;

	@FindBy(xpath = "//a[@href='#/report/dailyreportTop10?type=second_half']/span")
	WebElement DailyReportTop10SymbolsSecondHalf;

	@FindBy(xpath = "//a[@href='#/report/dailyboreport']/span")
	WebElement DailyReportTDailyReports;

	@FindBy(xpath = "//a[@href='#/report/top20Custom']/span")
	WebElement DailyReportTop20CustomRange;

	@FindBy(xpath = "//a[@href='#/report/top10Custom']/span")
	WebElement DailyReportTop10CustomRange;

	public HomeDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public void getDBMT4UserCount() {

		String getDBMt4UserCountQuery = "select count(*) from sky9fx_report.mt4_users where email not like '%test%';";

		try {

			rs = JDBCConnection.JDBCCreateStatement().executeQuery(getDBMt4UserCountQuery);
			while (rs.next()) {

				System.out.println(rs.getInt("count(*)"));
			}

		} catch (Exception e) {
			try {
				rs.close();
				JDBCConnection.closeJDBCConnection();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				JDBCConnection.closeJDBCConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void verifyDashboardTileLabelCountAndValue() {

		// Mt4 users tile
		//---------------------------------------------------------------------------------------------
		
		JSExecutorUtils.highLighterMethod(driver, MT4UsersLabel, MT4UsersCount);
		
		testUtil.softAsertion.assertEquals(MT4UsersLabel.getText(), "MT4 USERS", "MT4UsersLabel not matching");
		testUtil.softAsertion.assertEquals(MT4UsersCount.getText(), "46718", "MT4UsersCount count not matching");

		// Today's Deposit tile
		//---------------------------------------------------------------------------------------------
		
		JSExecutorUtils.highLighterMethod(driver, TodaysDepositLabel, TodaysDepositValue);
		
		testUtil.softAsertion.assertEquals(TodaysDepositLabel.getText(), "TODAY'S DEPOSIT",
				"TodaysDepositLabel not matching");
		testUtil.softAsertion.assertEquals(TodaysDepositValue.getText(), "$0.00", "TodaysDepositValue not matching");

		// Today's Withdrawal tile
		//---------------------------------------------------------------------------------------------
		
		JSExecutorUtils.highLighterMethod(driver, TodaysWithdrawalLabel, TodaysWithdrawalValue);
		
		testUtil.softAsertion.assertEquals(TodaysWithdrawalLabel.getText(), "TODAY'S WITHDRAWAL",
				"TodaysWithdrawalLabel not matching");
		testUtil.softAsertion.assertEquals(TodaysWithdrawalValue.getText(), "$0.00",
				"TodaysWithdrawalValue not matching");

		// Today's Commission tile
		//---------------------------------------------------------------------------------------------
		
		JSExecutorUtils.highLighterMethod(driver, TodaysComissionLabel, TodaysComissionValue);
		
		testUtil.softAsertion.assertEquals(TodaysComissionLabel.getText(), "TODAY'S COMMISSION",
				"TodaysComissionLabel not matching");
		testUtil.softAsertion.assertEquals(TodaysComissionValue.getText(), "$0.00",
				"TodaysComissionValue not matching");

		// Today's BO close trade tile
		//---------------------------------------------------------------------------------------------
		
		JSExecutorUtils.highLighterMethod(driver, TodaysBOCloseTradeLabel, TodaysBOCloseTradeValue);
		
		testUtil.softAsertion.assertEquals(TodaysBOCloseTradeLabel.getText(), "TODAY'S BO CLOSE TRADE",
				"TodaysBOCloseTradeLabel not matching");
		testUtil.softAsertion.assertEquals(TodaysBOCloseTradeValue.getText(), "0",
				"TodaysBOCloseTradeValue not matching");

		// Today's Forex close trade tile
		// ---------------------------------------------------------------------------------------------
		
		JSExecutorUtils.highLighterMethod(driver, TodaysForexCloseTradeLabel, TodaysForexCloseTradeValue);
		
		testUtil.softAsertion.assertEquals(TodaysForexCloseTradeLabel.getText(), "TODAY'S FOREX CLOSE TRADE",
				"TodaysForexCloseTradeLabel not matching");
		testUtil.softAsertion.assertEquals(TodaysForexCloseTradeValue.getText(), "0",
				"TodaysForexCloseTradeValue not matching");

		// Top BO profit user 
		//----------------------------------------------------------------------------------------------
		
		JSExecutorUtils.highLighterMethod(driver, TopBOProfitUserLabel, TopBOProfitUserMt4Id);
		
		testUtil.softAsertion.assertEquals(TopBOProfitUserLabel.getText(), "TOP BO PROFIT USER",
				"TopBOProfitUserLabel not matching");
		testUtil.softAsertion.assertEquals(TopBOProfitUserMt4Id.getText(), "no user found",
				"TopBOProfitUserMt4Id not matching");

		// Top Forex profit user
		//---------------------------------------------------------------------------------------------
		
		JSExecutorUtils.highLighterMethod(driver, TopFxProfitUserLabel, TopFxProfitUserMt4Id);
		
		testUtil.softAsertion.assertEquals(TopFxProfitUserLabel.getText(), "TOP FX PROFIT USER",
				"TopBOProfitUserLabel not matching");
		testUtil.softAsertion.assertEquals(TopFxProfitUserMt4Id.getText(), "no user found",
				"TopFxProfitUserMt4Id not matching");

		// LEFT SIDE MENUs TO VERIFIES LABEL
		// --------------------------------------------------------------------------------------------------

		// HOME TAB
		//---------------------------------------------------------------------------------------------------

		JSExecutorUtils.highLighterMethod(driver, HomeTab);
		testUtil.softAsertion.assertEquals("Home", HomeTab.getText());

		// WHITELABLE TAB
		//---------------------------------------------------------------------------------------------------

		
		WhitelableTab.click();//open or expand tab
		
		JSExecutorUtils.highLighterMethod(driver,WhitelableTab, WhitelableTabExpandManageUsers, WhitelableTabExpandManageRoles);
		
		testUtil.softAsertion.assertEquals("Whitelabel", WhitelableTab.getText());
		testUtil.softAsertion.assertEquals(WhitelableTabExpandManageUsers.getText(), "Manage Users");
		testUtil.softAsertion.assertEquals(WhitelableTabExpandManageRoles.getText(), "Manage Roles");
		
		//WhitelableTab.click(); //close or collapse tab

		// TRADING REPORT TAB
		// ---------------------------------------------------------------------------------------------------

		
		TradingReportTab.click(); //open or expand tab
		
		JSExecutorUtils.highLighterMethod(driver, TradingReportTab, TradingReportAllTransaction,
				TradingReportClosedTrades, TradingReportDepostWithdraw, TradingReportLastTransaction,
				TradingReportDirectSponsorsDownlineTrading, TradingReportNetDpeosit, TradingReportOverallSummary,
				TradingReportOverallSummaryWithTradingClient, TradingReportSponserNetDeposit,
				TradingReportSponsorsTradingVolume);
		
		JSExecutorUtils.pageScrollElementvisible(driver, TradingReportTab);
		
		testUtil.softAsertion.assertEquals("Trading Report", TradingReportTab.getText());
		testUtil.softAsertion.assertEquals(TradingReportAllTransaction.getText(), "All Transactions");
		testUtil.softAsertion.assertEquals(TradingReportClosedTrades.getText(), "Closed Trades");
		testUtil.softAsertion.assertEquals(TradingReportDepostWithdraw.getText(), "Deposit Withdrawal");
		testUtil.softAsertion.assertEquals(TradingReportNetDpeosit.getText(), "Net Deposit");
		testUtil.softAsertion.assertEquals(TradingReportOverallSummary.getText(), "Overall Summary");
		testUtil.softAsertion.assertEquals(TradingReportSponserNetDeposit.getText(), "Sponsors Net Deposit");
		
		JSExecutorUtils.pageScrollElementvisible(driver, TradingReportOverallSummaryWithTradingClient);
		
		testUtil.softAsertion.assertEquals(TradingReportOverallSummaryWithTradingClient.getText(),
				"Overall Summary with Trading Clients");
		testUtil.softAsertion.assertEquals(TradingReportLastTransaction.getText(), "Last Transactions");
		testUtil.softAsertion.assertEquals(TradingReportSponsorsTradingVolume.getText(), "Sponsor Trading Volume");
		testUtil.softAsertion.assertEquals(TradingReportDirectSponsorsDownlineTrading.getText(),
				"Direct Sponsor Downline Trading Volume");
		
		
		//TradingReportTab.click(); //close or collapse tab

		// COMMISSION REPORT TAB
		// -----------------------------------------------------------------------------------

		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(CommissionReportTab));
		
		CommissionReportTab.click();
		
		JSExecutorUtils.highLighterMethod(driver, CommissionReportTab, CommissionReportComissionDetailedReport,
				CommissionReportComissionSummaryReport, CommissionReportComissionSummaryBO_FX_M);
		
		JSExecutorUtils.pageScrollElementvisible(driver, CommissionReportTab);
		
		testUtil.softAsertion.assertEquals(CommissionReportTab.getText(), "Comission Report");
		testUtil.softAsertion.assertEquals(CommissionReportComissionDetailedReport.getText(),
				"Commission Detailed Report");
		testUtil.softAsertion.assertEquals(CommissionReportComissionSummaryReport.getText(),
				"Commission Summary Report");
		testUtil.softAsertion.assertEquals(CommissionReportComissionSummaryBO_FX_M.getText(),
				"Commission Summary Bo,Fx,M");
		
		//CommissionReportTab.click();

		// DAILY REPORT TAB 
		// -------------------------------------------------------------------------------------------

		DailyReportTab.click();
		
		JSExecutorUtils.highLighterMethod(driver, DailyReportTab, DailyReportTop20Winner,
				DailyReportTop20WinnerFirstHalf, DailyReportTop20WinnerSecondHalf, DailyReportTop10Symbols,
				DailyReportTop10SymbolsFirstHalf, DailyReportTop10SymbolsSecondHalf, DailyReportTop10CustomRange,
				DailyReportTop20CustomRange, DailyReportTDailyReports);
		
		JSExecutorUtils.pageScrollElementvisible(driver, DailyReportTab);
		
		
		testUtil.softAsertion.assertEquals(DailyReportTab.getText(), "Daily Report");
		testUtil.softAsertion.assertEquals(DailyReportTop20Winner.getText(), "Top 20 Winner");
		testUtil.softAsertion.assertEquals(DailyReportTop20WinnerFirstHalf.getText(), "Top 20 Winner First Half");
		testUtil.softAsertion.assertEquals(DailyReportTop20WinnerSecondHalf.getText(), "Top 20 Winner Second Half");
		testUtil.softAsertion.assertEquals(DailyReportTop10Symbols.getText(), "Top 10 Symbols");
		testUtil.softAsertion.assertEquals(DailyReportTop10SymbolsFirstHalf.getText(), "Top 10 Symbols First Half");
		testUtil.softAsertion.assertEquals(DailyReportTop10SymbolsSecondHalf.getText(), "Top 10 Symbols Second Half");
		
		JSExecutorUtils.pageScrollElementvisible(driver, DailyReportTDailyReports);
		
		testUtil.softAsertion.assertEquals(DailyReportTDailyReports.getText(), "Daily Reports");
		testUtil.softAsertion.assertEquals(DailyReportTop10CustomRange.getText(), "Top 10 Custom Range");
		testUtil.softAsertion.assertEquals(DailyReportTop20CustomRange.getText(), "Top 20 Custom Range");
		
		JSExecutorUtils.pageScrollElementvisible(driver, DailyReportTab);
		
		DailyReportTab.click();
		
		//----------------------------------------------------------------------------------------------

		testUtil.softAsertion.assertAll();
	}
	
	public WhitelabelManageUserTab ManageUser() {
		WhitelableTab.click();
		WhitelableTabExpandManageUsers.click();
		WhitelableTab.click();
		return new WhitelabelManageUserTab();
	}
	
	public WhitelabelManageRolesTab ManageRoles() {
		WhitelableTab.click();
		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(WhitelableTabExpandManageRoles));
		JSExecutorUtils.highLighterMethod(driver, WhitelableTab,WhitelableTabExpandManageRoles);
		WhitelableTabExpandManageRoles.click();
		//WhitelableTab.click();
		return new WhitelabelManageRolesTab(); 
	}

	public TradingReportAllTransactionTab TradingReportAllTransaction() {
		TradingReportTab.click();
		TradingReportAllTransaction.click();
		TradingReportTab.click();
		return new TradingReportAllTransactionTab();
	}
	
	public CommissionReportCommissionDetailedReportTab CommissionDetailedReport() {
		CommissionReportTab.click();
		CommissionReportComissionDetailedReport.click();
		CommissionReportTab.click();
		return new CommissionReportCommissionDetailedReportTab();
	}
	
	public DailyReportTop20WinnerTab Top20Report() {
		DailyReportTab.click();
		DailyReportTop20Winner.click();
		DailyReportTab.click();
		return new DailyReportTop20WinnerTab();
	}
	
	/*public Object JustPassParentandSubMenu(WebElement ParentMenu, WebElement SubMenu) {
		ParentMenu.click();
		testUtil.fluentwaitr.until(ExpectedConditions.visibilityOf(SubMenu));
		SubMenu.click();
		ParentMenu.click();
		return new Object();
	}*/
		
	
}



package com.amazon.createSIM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.KeyEvent;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//{@literal @RunWith(JUnit4.class)}
public class createSIM extends App {

        private static ChromeDriverService service;
        private WebDriver driver;

        // {@literal @BeforeClass}
        public static void createAndStartService() throws IOException {
                service = new ChromeDriverService.Builder()
                                .usingDriverExecutable(new File("Resources/chromedriver.exe")).usingAnyFreePort()
                                .build();
                service.start();
        }

        // {@literal @AfterClass}
        public static void createAndStopService() {
                service.stop();
        }

        // {@literal @Before}
        public void createDriver() {
                driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        }

        // {@literal @After}
        public void quitDriver() {
                driver.quit();
        }

        // {@literal @Test}

        Sheet sheet;
        Cell cell;
        String link, TITLE, Desc, filepath, sevoption, tasktype, gloption, marketplace, avsvendor, countsub, DCleadtime;
        double cs, dc;
        String narc, penvmc, penot, cntsub, updct, dclt;
        String resdes, usrname, rbscount, others, noaction, vmcount, completed, usrnm;
        String arc, dupof, issdet, resdess, tasktype2, gloption2, marketplace2, avsvendor2;
        String reso;

        double r1, r2, r3, r4, r5, n1, n2, n3, n4, n5, n6;
        String fp;

        public int ketData() throws IOException {

                FileInputStream finput = new FileInputStream(new File("SIMBulkcreation.xlsm"));

                Workbook workbook = WorkbookFactory.create(finput);

                int k;

                sheet = workbook.getSheetAt(0);
                k = sheet.getLastRowNum();

                finput.close();
                workbook.close();

                return k;
        }

        public void getData(int j) {
                cell = sheet.getRow(j).getCell(0);
                link = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(1);
                TITLE = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(2);
                Desc = cell.getStringCellValue();
                try {
                        cell = sheet.getRow(j).getCell(3);
                        filepath = cell.getStringCellValue();

                } catch (NullPointerException e) {

                }
                cell = sheet.getRow(j).getCell(4);
                sevoption = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(5);
                cs = cell.getNumericCellValue();
                countsub = String.format("%d", (long) cs);
                cell = sheet.getRow(j).getCell(6);
                tasktype = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(7);
                gloption = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(8);
                marketplace = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(9);
                avsvendor = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(10);
                System.out.println(avsvendor);
                dc = cell.getNumericCellValue();
                DCleadtime = String.format("%d", (long) dc);
                cell = sheet.getRow(j).getCell(11);
                resdes = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(12);
                r1 = cell.getNumericCellValue();
                rbscount = String.format("%d", (long) r1);
                cell = sheet.getRow(j).getCell(13);
                r2 = cell.getNumericCellValue();
                others = String.format("%d", (long) r2);
                cell = sheet.getRow(j).getCell(14);
                r3 = cell.getNumericCellValue();
                noaction = String.format("%d", (long) r3);
                cell = sheet.getRow(j).getCell(15);
                r4 = cell.getNumericCellValue();
                vmcount = String.format("%d", (long) r4);
                cell = sheet.getRow(j).getCell(16);
                r5 = cell.getNumericCellValue();
                completed = String.format("%d", (long) r5);
                cell = sheet.getRow(j).getCell(18);
                usrname = cell.getStringCellValue();
                usrnm = "//li[@data-value='kerberos:" + usrname + "@ANT.AMAZON.COM']";
                // cell = sheet.getRow(j).getCell(19);
                // arc = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(19);
                reso = cell.getStringCellValue();
                try {
                        cell = sheet.getRow(j).getCell(20);
                        dupof = cell.getStringCellValue();
                        cell = sheet.getRow(j).getCell(21);
                        issdet = cell.getStringCellValue();

                } catch (NullPointerException e) {
                }
                cell = sheet.getRow(j).getCell(22);
                resdess = cell.getStringCellValue();
                cell = sheet.getRow(j).getCell(23);
                n1 = cell.getNumericCellValue();
                narc = String.format("%d", (long) n1);
                cell = sheet.getRow(j).getCell(24);
                n2 = cell.getNumericCellValue();
                penvmc = String.format("%d", (long) n2);
                cell = sheet.getRow(j).getCell(25);
                n3 = cell.getNumericCellValue();
                penot = String.format("%d", (long) n3);
                cell = sheet.getRow(j).getCell(26);
                n4 = cell.getNumericCellValue();
                cntsub = String.format("%d", (long) n4);
                cell = sheet.getRow(j).getCell(27);
                n5 = cell.getNumericCellValue();
                updct = String.format("%d", (long) n5);
                cell = sheet.getRow(j).getCell(28);
                n6 = cell.getNumericCellValue();
                dclt = String.format("%d", (long) n6);
        }

        public void putData(int n) throws InterruptedException, IOException, AWTException {
                WebDriverWait wait = new WebDriverWait(driver, 30);
                driver.get(link);

                Map<String, String> map = new HashMap<>();
                map.put("1 - Bus. Critical Function Down",
                                "//option[contains(text(),'1 - Bus. Critical Function Down')]");
                map.put("2 - Bus. Critical Function Impaired",
                                "//option[contains(text(),'2 - Bus. Critical Function Impaired')]");
                map.put("2.5 - [Business Hours Sev-2] Bus. Critical Function Impaired",
                                "//option[contains(text(),'2.5 - [Business Hours Sev-2] Bus. Critical Functio");
                map.put("3 - Group Productivity Impaired",
                                "//option[contains(text(),'3 - Group Productivity Impaired')]");
                map.put("4 - Individual Productivity Impaired",
                                "//option[contains(text(),'4 - Individual Productivity Impaired')]");
                map.put("5 - Productivity not immediately affected",
                                "//option[contains(text(),'5 - Productivity not immediately affected')]");
                map.put("None", "None");
                map.put("Pre-Live: Suppression Check", "//option[contains(text(),'Pre-Live: Suppression Check')]");
                map.put("Pre-Live: IDQ Check", "//option[contains(text(),'Pre-Live: IDQ Check')]");
                map.put("Pre-Live: RSP Check", "//option[contains(text(),'Pre-Live: RSP Check')]");
                map.put("Pre-Live Inventory Monitoring", "//option[contains(text(),'Pre-Live Inventory Monitoring')]");
                map.put("Live: Walk the Store", "//option[contains(text(),'Live: Walk the Store')]");
                map.put("Live: Sales Monitoring", "//option[contains(text(),'Live: Sales Monitoring')]");
                map.put("Live: Suppression Check",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/select[1]/option[8]");
                map.put("Post Mortem: CCOGS Postmortem", "//option[contains(text(),'Post Mortem: CCOGS Postmortem')]");
                map.put("Opportunity Buy Creation", "//option[contains(text(),'Opportunity Buy Creation')]");
                map.put("Contra-COGS Creation", "//option[contains(text(),'Contra-COGS Creation')]");
                map.put("Deal Edits", "//option[contains(text(),'Deal Edits')]");
                map.put("PO Edits", "//option[contains(text(),'PO Edits')]");
                map.put("CCOGS Edits", "//option[contains(text(),'CCOGS Edits')]");
                map.put("Deal Creation", "//option[contains(text(),'Deal Creation')]");
                map.put("Not classified above", "//option[contains(text(),'Not classified above')]");
                map.put("BxGy", "//option[contains(text(),'BxGy')]");
                map.put("Price Discount", "//option[contains(text(),'Price Discount')]");
                map.put("Wine", "//option[contains(text(),'Wine')]");
                map.put("Furniture", "//option[contains(text(),'Furniture')]");
                map.put("Kitchen", "//option[contains(text(),'Kitchen')]");
                map.put("Home", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[5]");
                map.put("Lawn and Garden", "//option[contains(text(),'Lawn and Garden')]");
                map.put("Personal Care Appliances", "//option[contains(text(),'Personal Care Appliances')]");
                map.put("Apparel",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[5]");
                map.put("Office Products", "//option[contains(text(),'Office Products')]");
                map.put("Sports",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[10]");
                map.put("Home Improvement", "//option[contains(text(),'Home Improvement')]");
                map.put("Health & Personal Care", "//option[contains(text(),'Health & Personal Care')]");
                map.put("Wireless",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[13]");
                map.put("Pet Products", "//option[contains(text(),'Pet Products')]");
                map.put("Video DVD", "//option[contains(text(),'Video DVD')]");
                map.put("Camera", "//option[contains(text(),'Camera')]");
                map.put("Beauty",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[17]");
                map.put("Musical Instruments", "//option[contains(text(),'Musical Instruments')]");
                map.put("Digital Ebook Purchase", "//option[contains(text(),'Digital Ebook Purchase')]");
                map.put("Automotive", "//option[contains(text(),'Automotive')]");
                map.put("Toys", "//option[contains(text(),'Toys')]");
                map.put("Electronics",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[22]");
                map.put("PC", "//option[contains(text(),'PC')]");
                map.put("Books", "//option[contains(text(),'Books')]");
                map.put("Grocery", "//option[contains(text(),'Grocery')]");
                map.put("Home Entertainment", "//option[contains(text(),'Home Entertainment')]");
                map.put("Major Appliances", "//option[contains(text(),'Major Appliances')]");
                map.put("Digital Video Games", "//option[contains(text(),'Digital Video Games')]");
                map.put("Mixed", "//option[contains(text(),'Mixed')]");
                map.put("Consumables Email Gift Cards", "//option[contains(text(),'Consumables Email Gift Cards')]");
                map.put("Video Games",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[31]");
                map.put("Luggage", "//option[contains(text(),'Luggage')]");
                map.put("Baby", "//option[contains(text(),'Baby')]");
                map.put("Watches", "//option[contains(text(),'Watches')]");
                map.put("Biss", "//option[contains(text(),'Biss')]");
                map.put("Digital Software", "//option[contains(text(),'Digital Software')]");
                map.put("Shoes", "//option[contains(text(),'Shoes')]");
                map.put("Software",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[38]");
                map.put("Consumables Physical Gift Cards",
                                "//option[contains(text(),'Consumables Physical Gift Cards')]");
                map.put("Tools", "//option[contains(text(),'Tools')]");
                map.put("Outdoors", "//option[contains(text(),'Outdoors')]");
                map.put("Luxury Beauty", "//option[contains(text(),'Luxury Beauty')]");
                map.put("Other", "//option[contains(text(),'Other')]");
                map.put("ShopBop", "//option[contains(text(),'ShopBop')]");
                map.put("Video Game - Consoles", "//option[contains(text(),'Video Game - Consoles')]");
                map.put("Unassigned", "//option[contains(text(),'Unassigned')]");
                map.put("Music", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[47]");
                map.put("Unknown", "//option[contains(text(),'Unknown')]");
                map.put("Gifts", "//option[contains(text(),'Gifts')]");
                map.put("Games", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[50]");
                map.put("Video", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[51]");
                map.put("Batteries", "//option[contains(text(),'Batteries')]");
                map.put("Shops", "//option[contains(text(),'Shops')]");
                map.put("Universal", "//option[contains(text(),'Universal')]");
                map.put("Ebook", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[55]");
                map.put("Photo", "//option[contains(text(),'Photo')]");
                map.put("Slots", "//option[contains(text(),'Slots')]");
                map.put("Catalog of the World", "//option[contains(text(),'Catalog of the World')]");
                map.put("Audible", "//option[contains(text(),'Audible')]");
                map.put("Downloadable Software", "//option[contains(text(),'Downloadable Software')]");
                map.put("Magazines", "//option[contains(text(),'Magazines')]");
                map.put("Target",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[62]");
                map.put("Target Gift Card", "//option[contains(text(),'Target Gift Card')]");
                map.put("Paper Catalog", "//option[contains(text(),'Paper Catalog')]");
                map.put("Restaurant Menu", "//option[contains(text(),'Restaurant Menu')]");
                map.put("Food and Beverage", "//option[contains(text(),'Food and Beverage')]");
                map.put("Jewelry", "//option[contains(text(),'Jewelry')]");
                map.put("Cadillac", "//option[contains(text(),'Cadillac')]");
                map.put("Media", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[69]");
                map.put("Gift Card",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[70]");
                map.put("Travel Store", "//option[contains(text(),'Travel Store')]");
                map.put("Misc SDP", "//option[contains(text(),'Misc SDP')]");
                map.put("Loose Stones", "//option[contains(text(),'Loose Stones')]");
                map.put("Gourmet", "//option[contains(text(),'Gourmet')]");
                map.put("Local Directories", "//option[contains(text(),'Local Directories')]");
                map.put("Posters", "//option[contains(text(),'Posters')]");
                map.put("Sports Memorabilia", "//option[contains(text(),'Sports Memorabilia')]");
                map.put("School Supplies", "//option[contains(text(),'School Supplies')]");
                map.put("Art and Craft Supplies", "//option[contains(text(),'Art and Craft Supplies')]");
                map.put("Medical Laboratory Supplies", "//option[contains(text(),'Medical Laboratory Supplies')]");
                map.put("Art", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[81]");
                map.put("Antiques", "//option[contains(text(),'Antiques')]");
                map.put("Gift Certificates", "//option[contains(text(),'Gift Certificates')]");
                map.put("Tires", "//option[contains(text(),'Tires')]");
                map.put("Digital Short Lit", "//option[contains(text(),'Digital Short Lit')]");
                map.put("Digital Documents", "//option[contains(text(),'Digital Documents')]");
                map.put("Philanthropy", "//option[contains(text(),'Philanthropy')]");
                map.put("Authority Non Buyable", "//option[contains(text(),'Authority Non Buyable')]");
                map.put("Free Gift Card", "//option[contains(text(),'Free Gift Card')]");
                map.put("Webservices", "//option[contains(text(),'Webservices')]");
                map.put("Library Services", "//option[contains(text(),'Library Services')]");
                map.put("Digital Video Download", "//option[contains(text(),'Digital Video Download')]");
                map.put("Digital Music Service", "//option[contains(text(),'Digital Music Service')]");
                map.put("Digital Book Service", "//option[contains(text(),'Digital Book Service')]");
                map.put("Nba Gift Card", "//option[contains(text(),'Nba Gift Card')]");
                map.put("Digital Music Purchase", "//option[contains(text(),'Digital Music Purchase')]");
                map.put("Digital Text",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[97]");
                map.put("Digital Periodicals", "//option[contains(text(),'Digital Periodicals')]");
                map.put("Wireless Accessory", "//option[contains(text(),'Wireless Accessory')]");
                map.put("Wireless Prepaid Phone", "//option[contains(text(),'Wireless Prepaid Phone')]");
                map.put("Wireless Service Plan", "//option[contains(text(),'Wireless Service Plan')]");
                map.put("Data Activity Plans", "//option[contains(text(),'Data Activity Plans')]");
                map.put("Advertising", "//option[contains(text(),'Advertising')]");
                map.put("Video Game Hardware", "//option[contains(text(),'Video Game Hardware')]");
                map.put("Membership",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[105]");
                map.put("Prescription Drugs", "//option[contains(text(),'Prescription Drugs')]");
                map.put("Prescription Eyewear", "//option[contains(text(),'Prescription Eyewear')]");
                map.put("Digital Accessories",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/select[1]/option[108]");
                map.put("Video Membership", "//option[contains(text(),'Video Membership')]");
                map.put("Mobile Apps", "//option[contains(text(),'Mobile Apps')]");
                map.put("Digital Content Subscription", "//option[contains(text(),'Digital Content Subscription')]");
                map.put("Digital Services", "//option[contains(text(),'Digital Services')]");
                map.put("Digital Media Access License", "//option[contains(text(),'Digital Media Access License')]");
                map.put("Downloadable Digital Media", "//option[contains(text(),'Downloadable Digital Media')]");
                map.put("Virtual Currency", "//option[contains(text(),'Virtual Currency')]");
                map.put("Virtual Goods", "//option[contains(text(),'Virtual Goods')]");
                map.put("Cloud Software Applications", "//option[contains(text(),'Cloud Software Applications')]");
                map.put("A Drive", "//option[contains(text(),'A Drive')]");
                map.put("Deal Sourcer", "//option[contains(text(),'Deal Sourcer')]");
                map.put("Amazon Sourced", "//option[contains(text(),'Amazon Sourced')]");
                map.put("Financial Products", "//option[contains(text(),'Financial Products')]");
                map.put("Mobile Electronics", "//option[contains(text(),'Mobile Electronics')]");
                map.put("Digital Text 2", "//option[contains(text(),'Digital Text 2')]");
                map.put("Digital Accessories 2", "//option[contains(text(),'Digital Accessories 2')]");
                map.put("Publisher Services", "//option[contains(text(),'Publisher Services')]");
                map.put("Amazon Points", "//option[contains(text(),'Amazon Points')]");
                map.put("Digital Music Locker", "//option[contains(text(),'Digital Music Locker')]");
                map.put("Protected Collection", "//option[contains(text(),'Protected Collection')]");
                map.put("Entertainment Collectibles", "//option[contains(text(),'Entertainment Collectibles')]");
                map.put("Coins Collectibles", "//option[contains(text(),'Coins Collectibles')]");
                map.put("Stamps Collectibles", "//option[contains(text(),'Stamps Collectibles')]");
                map.put("Arts Collectibles", "//option[contains(text(),'Arts Collectibles')]");
                map.put("Nonactivated Gift Cards", "//option[contains(text(),'Nonactivated Gift Cards')]");
                map.put("Social Games", "//option[contains(text(),'Social Games')]");
                map.put("Digital Products 1", "//option[contains(text(),'Digital Products 1')]");
                map.put("Digital Products 2", "//option[contains(text(),'Digital Products 2')]");
                map.put("Payment Devices", "//option[contains(text(),'Payment Devices')]");
                map.put("Digital Products 3", "//option[contains(text(),'Digital Products 3')]");
                map.put("Local Business", "//option[contains(text(),'Local Business')]");
                map.put("Prime", "//option[contains(text(),'Prime')]");
                map.put("Digital Text 3", "//option[contains(text(),'Digital Text 3')]");
                map.put("Amazon Pantry", "//option[contains(text(),'Amazon Pantry')]");
                map.put("gl digital accessories 4", "//option[contains(text(),'gl digital accessories 4')]");
                map.put("3d Designs And Print On Demand",
                                "//option[contains(text(),'3d Designs And Print On Demand')]");
                map.put("Digital Text 4", "//option[contains(text(),'Digital Text 4')]");
                map.put("gl digital products 5", "//option[contains(text(),'gl digital products 5')]");
                map.put("3d Designs And Manufacturing Ser",
                                "//option[contains(text(),'3d Designs And Manufacturing Ser')]");
                map.put("gl vehicle", "//option[contains(text(),'gl vehicle')]");
                map.put("Kindle Unlimited", "//option[contains(text(),'Kindle Unlimited')]");
                map.put("Designer Apparel", "//option[contains(text(),'Designer Apparel')]");
                map.put("GUILD", "//option[contains(text(),'GUILD')]");
                map.put("gl fresh perishable", "//option[contains(text(),'gl fresh perishable')]");
                map.put("gl fresh produce", "//option[contains(text(),'gl fresh produce')]");
                map.put("gl fresh prepared", "//option[contains(text(),'gl fresh prepared')]");
                map.put("gl fresh ambient", "//option[contains(text(),'gl fresh ambient')]");
                map.put("VALUE ADDED SERVICES", "//option[contains(text(),'VALUE ADDED SERVICES')]");
                map.put("Video Devices", "//option[contains(text(),'Video Devices')]");
                map.put("Softlines Private Label", "//option[contains(text(),'Softlines Private Label')]");
                map.put("SUD Devices", "//option[contains(text(),'SUD Devices')]");
                map.put("gl project diamond", "//option[contains(text(),'gl project diamond')]");
                map.put("DE", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/select[1]/option[2]");
                map.put("UK", "//option[contains(text(),'UK')]");
                map.put("FR", "//option[contains(text(),'FR')]");
                map.put("ES", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/select[1]/option[5]");
                map.put("IT", "//option[contains(text(),'IT')]");
                map.put("US", "//option[contains(text(),'US')]");
                map.put("PAN-EU", "//option[contains(text(),'PAN-EU')]");
                map.put("TR", "//option[contains(text(),'TR')]");
                map.put("NL", "//option[contains(text(),'NL')]");
                // map.put("Yes ", "//option[contains(text(),'Yes')]");
                // map.put("No",
                // "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/select[1]/option[3]");
                map.put("yes", "//option[contains(text(),'Yes')]");
                map.put("no", "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/select[1]/option[3]");
                map.put("Successfully executed",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]");
                map.put("No action taken",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[3]");
                map.put("Partially executed",
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[4]");
                Thread.sleep(5000);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[3]/div[1]/div[1]/div[1]/button[1]")));
                driver.findElement(By.id("issue-title")).clear();
                driver.findElement(By.id("issue-title")).sendKeys(TITLE);
                driver.findElement(By.id("editable-rich-text-field")).clear();
                driver.findElement(By.id("editable-rich-text-field")).sendKeys(Desc);
                if (filepath != null) {
                        try {
                                WebElement uplo = driver.findElement(By.xpath(
                                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/input[1]"));
                                uplo.sendKeys(new File(filepath).getAbsolutePath());
                                wait.until(ExpectedConditions
                                                .presenceOfElementLocated(By.xpath("//a[contains(text(),'×')]")));
                                Thread.sleep(2000);
                        } catch (Exception e) {
                                WebElement uplo = driver.findElement(By.xpath(
                                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]"));
                                uplo.click();
                                Robot rb = new Robot();

                                // copying File path to Clipboard
                                StringSelection str = new StringSelection(filepath);
                                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
                                Thread.sleep(2000);
                                // press Contol+V for pasting
                                rb.keyPress(KeyEvent.VK_CONTROL);
                                rb.keyPress(KeyEvent.VK_V);

                                // release Contol+V for pasting
                                rb.keyRelease(KeyEvent.VK_CONTROL);
                                rb.keyRelease(KeyEvent.VK_V);

                                // for pressing and releasing Enter
                                rb.keyPress(KeyEvent.VK_ENTER);
                                rb.keyRelease(KeyEvent.VK_ENTER);
                                e.printStackTrace();
                        }
                } else {
                }
                if (!"None".equals(map.get(sevoption))) {
                        driver.findElement(By.xpath(map.get(sevoption))).click();
                } else {
                }
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("window.scrollBy(0,900)", "");
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[3]/div[1]/div[1]/div[1]/button[1]")));
                Thread.sleep(2000);
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
                                .clear();
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
                                .sendKeys(countsub);
                driver.findElement(By.xpath(map.get(tasktype))).click();
                driver.findElement(By.xpath(map.get(gloption))).click();
                try {
                        driver.findElement(By.xpath(map.get(marketplace))).click();
                } catch (ElementNotInteractableException e) {
                }
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/select[1]"))
                                .click();
                System.out.println(map.get(avsvendor));
                driver.findElement(By.xpath(map.get(avsvendor))).click();
                try{
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/input[1]"))
                                .sendKeys(DCleadtime);
                }catch(NoSuchElementException e){
                        e.printStackTrace();
                }
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                                .clear();
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                                .sendKeys(resdes);
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]"))
                                .clear();
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]"))
                                .sendKeys(rbscount);
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/input[1]"))
                                .clear();
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/input[1]"))
                                .sendKeys(others);
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/input[1]"))
                                .clear();
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/input[1]"))
                                .sendKeys(noaction);
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/input[1]"))
                                .clear();
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/input[1]"))
                                .sendKeys(vmcount);
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/input[1]"))
                                .clear();
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/span[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/input[1]"))
                                .sendKeys(completed);
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/div[4]/div[1]/span[1]/span[1]/span[1]/i[1]"))
                                .click();
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/div[4]/div[1]/span[1]/span[1]/div[1]/span[1]/ul[1]/input[1]"))
                                .sendKeys(usrname);
                Thread.sleep(2000);
                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[2]/div[1]/div[2]/div[4]/div[1]/span[1]/span[1]/div[1]/span[1]/ul[1]/div[1]/li[2]"))
                                .click();

                driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/section[3]/div[1]/div[1]/div[1]/button[1]"))
                                .click();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[4]/a[1]")));
                Thread.sleep(2000);
                String ID = driver.findElement(By.xpath(
                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[4]/a[1]"))
                                .getText();
                System.out.println(ID);

                FileWriter writer = new FileWriter("Tasks.txt", true);
                if (ID != null) {
                        writer.write(ID);
                        writer.write("\r\n"); // write new line
                } else {
                        writer.write("null");
                        writer.write("\r\n"); // write new line
                }
                writer.close();
                System.out.println(reso);
                if (reso != "Open") {
                        driver.findElement(By.xpath("//button[contains(text(),'Resolve')]")).click();
                        Thread.sleep(2000);
                        // driver.findElement(By.xpath(
                        // "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[1]/div[2]/div[1]/section[1]/span[1]/span[1]/input[1]"))
                        // .sendKeys(arc);
                        if (dupof != null) {
                                driver.findElement(By.xpath(
                                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[3]/input[1]"))
                                                .sendKeys(dupof);
                        } else {
                        }
                        if (issdet != null) {
                                driver.findElement(By.xpath(
                                                "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[5]/div[1]/div[1]/div[3]/textarea[1]"))
                                                .sendKeys(issdet);
                        } else {
                        }
                        driver.findElement(By.xpath(map.get(resdess))).click();
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"))
                                        .clear();
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"))
                                        .sendKeys(narc);
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]"))
                                        .clear();
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]"))
                                        .sendKeys(penvmc);
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]"))
                                        .clear();
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]"))
                                        .sendKeys(penot);
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/input[1]"))
                                        .clear();
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/input[1]"))
                                        .sendKeys(cntsub);
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[10]/div[1]/input[1]"))
                                        .clear();
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[10]/div[1]/input[1]"))
                                        .sendKeys(updct);
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[11]/div[1]/input[1]"))
                                        .clear();
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/section[6]/span[1]/div[1]/div[1]/div[1]/div[1]/div[11]/div[1]/input[1]"))
                                        .sendKeys(dclt);
                        Thread.sleep(2000);
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"))
                                        .click();
                        Thread.sleep(2000);
                        driver.findElement(By.xpath(
                                        "//body/div[@id='application-wrapper']/div[@id='application-container']/div[@id='application-content-wrapper']/div[@id='application-content']/div[1]/div[1]/div[1]/div[2]/div[4]/section[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"))
                                        .click();

                        wait.until(ExpectedConditions
                                        .presenceOfElementLocated(By.xpath("//button[contains(text(),'Reopen')]")));
                } else {
                }
        }

}
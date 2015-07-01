
import java.io.*;
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;

public class Auction1 {
	
	//public String myInputFile;
	public static String S_Title; //&lt;title&gt;</span> Apple iPad 2 32GB Wi Fi 9 7in Black
	public static String S_SellerID; //&userid=papawn652
	public static String S_Feedback;//feedback&amp feedback score: 67
	public static String S_Condition; //vi-itm-cond</span>"&gt; used
	public static String S_TimeLeft;//vi-cdown_timeLeft</span>"&gt; 9d 04h
	public static String S_CurrentBid; //price</span>"&gt; US $269.00
	public static String S_Shipping;//innerHTML = "+$15.25 shipping"

	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			Pattern Title;
			Pattern SellerID;
			Pattern Feedback;
			Pattern Condition;
			Pattern TimeLeft;
			Pattern CurrentBid;
			Pattern Shipping;
			
			Matcher matcher;
			in = new BufferedReader(new FileReader("ebayAuction.txt"));
			String line = "";
			boolean f1= false, f2= false, f3= false, f4= false, f5= false, f6= false, f7= false;
			
			Title = Pattern.compile("og:title(.*?)&gt;");
			SellerID = Pattern.compile("www.ebay.com/usr(.*?)trksid=");
			Feedback = Pattern.compile("feedback score: 67(.*?)&lt;");
			Condition = Pattern.compile("vi-itm-cond(.*?)&lt;");
			TimeLeft = Pattern.compile("vi-cdown_timeLeft(.*?)&lt;");
			CurrentBid = Pattern.compile("prcIsum_bidPrice(.*?)&lt;");
			Shipping = Pattern.compile("shElemntArry[i].innerHTML(.*?);}</td>");


			while ((line = in.readLine()) != null) {
				try {

					if (!f1){
					matcher = Title.matcher(line);
					if (matcher.find()) { 
						line = matcher.group();
						S_Title = line.substring(0, line.length()-13);
						S_Title = S_Title.substring(S_Title.lastIndexOf(">")+1, line.length()-13);
						System.out.println("Title:" + S_Title);
						//System.out.println("group:" + matcher.group());
						f1= true;
						}// inner if
					}// outer if
										
					if (!f2){
						matcher = SellerID.matcher(line);
						if (matcher.find()) { 
							line = matcher.group();
							S_SellerID = line.substring(17, line.length()-9);
							//S_SellerID = S_SellerID.substring(S_SellerID.lastIndexOf("/")+1, line.length()-9);
							System.out.println("SellerID: " + S_SellerID);
							//System.out.println("group:" + matcher.group());
							f2= true;
							}// inner if
						}// outer if
					
					if (!f3){
						matcher = Feedback.matcher(line);
						if (matcher.find()) { 
							line = matcher.group();
							S_Feedback = line.substring(20, line.length());
							S_Feedback = S_Feedback.substring(S_Feedback.lastIndexOf("/")+1, line.length());
							System.out.println("Feedback: " + S_Feedback);
							//System.out.println("group:" + matcher.group());
							f3= true;
							}// inner if
						}// outer if
					
					if (!f4){
						matcher = Condition.matcher(line);
						if (matcher.find()) { 
							line = matcher.group();
							S_Condition = line.substring(30, line.length()-34);
							//S_Condition = S_Condition.substring(S_Condition.lastIndexOf(">")+1, line.length()-35);
							System.out.println("Condition: " + S_Condition);
							//System.out.println("group:" + matcher.group());
							f4= true;
							}// inner if
						}// outer if
					
					if (!f5){
						matcher = TimeLeft.matcher(line);
						if (matcher.find()) { 
							line = matcher.group();
							S_TimeLeft = line.substring(36, line.length()-35);
							//S_TimeLeft = S_TimeLeft.substring(S_TimeLeft.lastIndexOf("/")+1, line.length()-9);
							System.out.println("Time Left: " + S_TimeLeft);
							//System.out.println("group:" + matcher.group());
							f5= true;
							}// inner if
						}// outer if
					
					if (!f6){
						matcher = CurrentBid.matcher(line);
						if (matcher.find()) { 
							line = matcher.group();
							S_CurrentBid = line.substring(152, line.length()-34);
							//S_CurrentBid = S_CurrentBid.substring(S_CurrentBid.lastIndexOf(">")+1, line.length()-35);
							System.out.println("Current Bid: " + S_CurrentBid);
							//System.out.println("group:" + matcher.group());
							f6= true;
							}// inner if
						}// outer if
					
					if (!f7){
						matcher = Shipping.matcher(line);
						if (matcher.find()) {
							line = matcher.group();
							S_Shipping = line.substring(15, line.length()-10);
							//S_Shipping = S_Shipping.substring(S_Shipping.lastIndexOf(">")+1, line.length()-35);
							System.out.println("Shipping: " + S_Shipping);
							//System.out.println("group:" + matcher.group());
							f7= true;
							}// inner if
						}// outer if
					
				}// end try 
								
				catch (Exception e) {
				}//end catch
			}// end while
			in.close();
		} // end try 
		catch (IOException ioe) {
		} // end catch

	} // end main
	

}// end class

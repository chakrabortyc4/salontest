package SpringMy.Maven.Services;

public class SetExpressCheckoutService {
	
	/*private static Logger log = Logger.getLogger(SetExpressCheckoutService.class);
	
	public void mainMethod(){
		
		SetExpressCheckoutService setExpressCheckoutService = new SetExpressCheckoutService();
		
		//the parameters for the service	
		Long userId = 5l;
		String amount = "25";
		String returnURL = "http://localhost:8080/integratingstuff-paypal/return_after_payment.xhtml";
		String cancelURL = "http://localhost:8080/integratingstuff-paypal/cancel_payment.xhtml";
		
		PaymentActionCodeType paymentAction = PaymentActionCodeType.SALE;
		CurrencyCodeType currencyCode = CurrencyCodeType.EUR;
		
		
		try {
			//calling the service, setting up the checkoutpage
			
			String token = setExpressCheckoutService.setExpressCheckout(userId, amount, currencyCode, returnURL,cancelURL,paymentAction);
			log.info("Url to redirect to: https://www.sandbox.paypal.com/webscr?cmd=_express-checkout&useraction=commit&token=" + token);
		} catch (PayPalException e) {
			log.error(e);
		}	
	}//end of mainMethod()
	
	
	public String setExpressCheckout(Long userId, String paymentAmount,
			CurrencyCodeType currencyCodeType, String returnURL, String cancelURL,
				PaymentActionCodeType paymentAction) throws PayPalException{
		
		CallerServices caller = new CallerServices();
		
		
		//construct and set the profile, these are the credentials we establish as "the shop" with Paypal
				APIProfile profile = ProfileFactory.createSignatureAPIProfile();
				profile.setAPIUsername("sdk-three_api1.sdk.com");
				profile.setAPIPassword("QFZCWN5HZM8VBG7Q");
				profile.setSignature("AVGidzoSQiGWu.lGj3z15HLczXaaAcK6imHawrjefqgclVwBe8imgCHZ");
				profile.setEnvironment("sandbox");
				caller.setAPIProfile(profile);

		
	}*/

}

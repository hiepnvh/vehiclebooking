package vn.gmobile.vehiclebooking.delegate;

import java.text.Normalizer;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import vn.gmobile.vehiclebooking.conf.SystemParamGroup;

import com.gtel.email.EmailClient;

public class Email {
	
	private static final Logger LOGGER = Logger.getLogger(Email.class.getName());
	
	/**
	 * Creating emailHelper to send email with param input from, subject, content, recipient
	 * @param execution
	 * @param recipient
	 * @return
	 */
	public static boolean sendEmail(DelegateExecution execution){
		try {
			// TODO Auto-generated method stub
//			if(ServerConfig.get_SEND_EMAIL())	{
				EmailClient email = new EmailClient();
				
				String from = execution.getVariable("from").toString();
				
				String _to = execution.getVariable("to").toString();
				String to_mail = _to;
				String to_sms = "";
				String subject = execution.getVariable("subject").toString();
				String content = execution.getVariable("content").toString();
				
				if(_to.endsWith("sms")){
					to_sms = _to.replace("@gmobile.vnsms", SystemParamGroup.SMS_GMOBILE_SUFFIX);
					to_mail = _to.replace("sms", "");
					String content_sms = content.replaceAll("<br/>|\\r\\n|\\r|\\n", " ");
					content_sms = stripAccents(content_sms);
					LOGGER.info("Send email to "+ to_sms + " content " + content_sms);
					email.sendEmail(from, content_sms, subject, to_sms);//send sms
					email.sendEmail(from, subject, content, to_mail);//send email
				}
				else{
					LOGGER.info("Send email to "+ _to + " content " + content);
					email.sendEmail(from, subject, content, to_mail);//send email
				}
				
				
//			}
			
//			LOGGER.info("Send email to "+ _to + " content " + content);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	private static String stripAccents(String s) {
		
		// strip except 2 special accents in vietnamese
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    
	    // strip 2 special accents in vietnamese
	    s = s.replace('\u0111', 'd');
        s = s.replace('\u0110', 'd');
        
        // return string
        return s;
	}
}

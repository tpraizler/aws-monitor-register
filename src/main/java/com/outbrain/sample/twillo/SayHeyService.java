package com.outbrain.sample.twillo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.outbrain.sample.model.UserInfo;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;

/**
 * @author tpraizler
 *         Date: 10/15/13
 *         Time: 1:34 PM
 */
@Component
public class SayHeyService {

  @Autowired
  private TwilioRestClient restClient;

  public void sayHey(final UserInfo info) throws TwilioRestException {

    // Build a filter for the SmsList
    Map<String, String> params = new HashMap<String, String>();
    params.put("Body", "Hey " + info.getName() + ", Welcome to monitor aws!");
    System.out.println("Sending to : " + info.getPhone());
    params.put("To", info.getPhone());
    params.put("From", "+14154831181");

    SmsFactory messageFactory = restClient.getAccount().getSmsFactory();
    Sms message = messageFactory.create(params);
    System.out.println(message.getSid());
  }
}

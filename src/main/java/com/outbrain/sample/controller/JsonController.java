package com.outbrain.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.outbrain.sample.model.UserInfo;
import com.outbrain.sample.service.PersistenceService;
import com.outbrain.sample.twillo.SayHeyService;
import com.twilio.sdk.TwilioRestException;

/**
 * This controller will answer to all glu.gson related requests.
 * 
 * @author tomer
 *
 */
@Controller
@RequestMapping("/register")
public class JsonController {

  @Autowired
  private PersistenceService service;
  @Autowired
  private SayHeyService sayHey;

  @RequestMapping(value = "info", method = RequestMethod.GET)
  public @ResponseBody
  ResponseEntity<String> register(@RequestParam(value = "name") final String name, @RequestParam(value = "phoneNumber") final String phoneNumber,
      @RequestParam(value = "accessKey") final String accessKey, @RequestParam(value = "secretAccessKey") final String secretAccessKey)
      throws TwilioRestException {

    UserInfo info = new UserInfo(name, phoneNumber, accessKey, secretAccessKey);

    service.persist(info);
    sayHey.sayHey(info);

    return generateResponse(HttpStatus.OK, "SUCCESS");
  }

  @RequestMapping(value = "/index.html", method = RequestMethod.GET)
  public ModelAndView getView() {

    final ModelAndView response = new ModelAndView("/WEB-INF/views/index.jsp");
    return response;
  }

  @ExceptionHandler(value = { Exception.class })
  public ResponseEntity<String> handleError(final Exception ex) {
    return generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "FAILURE");
  }

  private ResponseEntity<String> generateResponse(final HttpStatus httpStatus, final String responseData) {
    final HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setContentType(MediaType.APPLICATION_JSON);
    final ResponseEntity<String> response = new ResponseEntity<String>(responseData, responseHeaders, httpStatus);
    return response;
  }

}

package com.banred.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.tempuri.Echo;
import org.tempuri.EchoResponse;
import org.tempuri.EnrollExternalAccount;
import org.tempuri.EnrollExternalAccountResponse;
import org.tempuri.ExecuteTransaction;
import org.tempuri.ExecuteTransactionResponse;
import org.tempuri.GetConvertedAmount;
import org.tempuri.GetConvertedAmountResponse;
import org.tempuri.GetConvertedAmountResult;
import org.tempuri.GetCurrencyExchangeRate;
import org.tempuri.GetCurrencyExchangeRateResponse;
import org.tempuri.GetCurrencyExchangeRateResult;
import org.tempuri.GetTransactionStatus;
import org.tempuri.GetTransactionStatusResponse;
import org.tempuri.GetTransactionStatusResult;
import org.tempuri.ObjectFactory;
import org.tempuri.OperationTagData;
import org.tempuri.RelateExistingAccount;
import org.tempuri.RelateExistingAccountResponse;
import org.tempuri.RequestExternalAccount;
import org.tempuri.RequestExternalAccountResponse;
import org.tempuri.UpdateReferredLink;
import org.tempuri.UpdateReferredLinkResponse;
import org.tempuri.UpdateReferredLinkResult;
import org.tempuri.Verify;
import org.tempuri.VerifyResponse;
import org.tempuri.VerifyResult;
import org.tempuri.VoidResponse;
import org.tempuri.VoidResult;

import com.banred.model.OperationTagDataResult;
//import com.banred.model.OperationTagDataResult;
import com.banred.service.EchoResultService;
import com.banred.service.EnrollExternalAccountService;
import com.banred.service.ExecuteTransactionResultService;
import com.banred.service.OperationTagObjectService;
//import com.banred.service.OperationTagObjectService;
import com.banred.service.RelateExistingAccountService;
import com.banred.service.RequestExternalAccountResultService;
import com.banred.service.UpdateReferredLinkService;

/**
 * The Class CardmarteController.
 */
@RestController
@RequestMapping("/cardmarte")
public class CardmarteController {
	

	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CardmarteController.class);
	
	public static final String CARDMARTE_APPLICATION_XML_VALUE = "text/xml";
	
	/** The update referred link service. */
	@Autowired
	UpdateReferredLinkService updateReferredLinkService;

	/**
	 * Update referred link request.
	 *
	 * @param parametros the parametros
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@Autowired
	OperationTagObjectService bodyOperationData;
	//@Autowired
	//OperationTagDataResult operationTagDataResult;
	@PostMapping(value = "/UpdateReferredLinkRequest/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<UpdateReferredLinkResponse> UpdateReferredLinkRequest(@RequestBody UpdateReferredLink parametros) throws Exception {
		ObjectFactory obj = new ObjectFactory();
		UpdateReferredLinkResponse response = obj.createUpdateReferredLinkResponse();
		logger.info("getMethod: " + parametros.getPAddress() + "\n");
		try {
			response.setUpdateReferredLinkResult(updateReferredLinkService.createUpdateReferredLinkObject());
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
	
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	/**
	 * Void.
	 *
	 * @param parametros the parametros
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/Void/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)	
	public ResponseEntity<VoidResponse> Void(@RequestBody Void parametros) throws Exception{
		ObjectFactory obj = new ObjectFactory();
		VoidResponse response = obj.createVoidResponse();
		logger.info("TN" +parametros.toString()  + "\n");

		try {
			VoidResult headerResponse = new VoidResult();
			headerResponse.setAccountCurrencyCode("AAA");
			headerResponse.setBalance("AAAA");
			response.setVoidResult(headerResponse);

		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	/**
	 * Verify.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/Verify/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<VerifyResponse> Verify(@RequestBody Verify request) {
		ObjectFactory obj = new ObjectFactory();
		VerifyResponse response = obj.createVerifyResponse();
		logger.info("getPAmount: " + request.getPAmount() + "\n");
		try {
			VerifyResult headerResponse = new VerifyResult();
			headerResponse.setBalance("AAA111");
			;
			headerResponse.setCurrencyAccount("BBB11");
			response.setVerifyResult(headerResponse);
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	

	/**
	 * Gets the transaction status.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/GetTransactionStatus/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<GetTransactionStatusResponse> GetTransactionStatus(@RequestBody GetTransactionStatus request) {
		ObjectFactory obj = new ObjectFactory();
		GetTransactionStatusResponse response = obj.createGetTransactionStatusResponse();
		logger.info("getPAmount: " + request.getPAmount() + "\n");
		try {
			GetTransactionStatusResult headerResponse = new GetTransactionStatusResult();
			headerResponse.setBalance("AAA111");
			;
			headerResponse.setTransactionNumber("BBB11");
			response.setGetTransactionStatusResult(headerResponse);
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	

	/**
	 * Gets the converted amount.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/GetConvertedAmount/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<GetConvertedAmountResponse> GetConvertedAmount(@RequestPayload GetConvertedAmount request) {
		ObjectFactory obj = new ObjectFactory();
		GetConvertedAmountResponse response = obj.createGetConvertedAmountResponse();
		logger.info("getPAmount: " + request.getPAmount() + "\n");
		try {
			GetConvertedAmountResult headerResponse = new GetConvertedAmountResult();
			headerResponse.setAmount("AAA111");
			OperationTagData bodyOperationData = new OperationTagData();
			//bodyOperationData.setExternalUserCode("AAA");
			headerResponse.setOperationTag(bodyOperationData);
			response.setGetConvertedAmountResult(headerResponse);
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/** The operation tag data. */
	@Autowired
	OperationTagObjectService operationTagData;
	
	/**
	 * Gets the currency exchange rate.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/GetCurrencyExchangeRate/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<GetCurrencyExchangeRateResponse> GetCurrencyExchangeRate(@RequestPayload GetCurrencyExchangeRate request) {
		ObjectFactory obj = new ObjectFactory();
		GetCurrencyExchangeRateResponse response = obj.createGetCurrencyExchangeRateResponse();
		logger.info("getPAmount: " + request.getPOriginCurrencyCode() + "\n");
		try {
			GetCurrencyExchangeRateResult headerResponse = new GetCurrencyExchangeRateResult();
			headerResponse.setSale("AAA111");
			OperationTagData bodyOperationData = new OperationTagData();
			//bodyOperationData.setExternalUserCode("AAA");
			headerResponse.setOperationTag(operationTagData.createOperationTagObject());			
			response.setGetCurrencyExchangeRateResult(headerResponse);
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/** The relate existing account service. */
	@Autowired
	RelateExistingAccountService relateExistingAccountService;
	
	/**
	 * Relate existing account.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/RelateExistingAccount/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<RelateExistingAccountResponse> RelateExistingAccount(@RequestPayload RelateExistingAccount request) {
		ObjectFactory obj = new ObjectFactory();
		RelateExistingAccountResponse response = obj.createRelateExistingAccountResponse();
		logger.info("getMethod: " + request.getPExternalCardNumber() + "\n");
		try {
			response.setRelateExistingAccountResult(relateExistingAccountService.creteData());
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	/** The echo result service. */
	@Autowired
	EchoResultService echoResultService;
	
	/**
	 * Echo.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/Echo/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<EchoResponse> Echo(@RequestPayload Echo request) {
		ObjectFactory obj = new ObjectFactory();
		EchoResponse response = obj.createEchoResponse();
		logger.info("getMethod: " + request.getPRequestID() + "\n");
		try {
			response.setEchoResult(echoResultService.creteEchoResultObject());
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	/** The enroll external account service. */
	@Autowired
	EnrollExternalAccountService enrollExternalAccountService;
	
	/**
	 * Enroll external account.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/EnrollExternalAccount/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<EnrollExternalAccountResponse> EnrollExternalAccount(@RequestPayload EnrollExternalAccount request) {
		ObjectFactory obj = new ObjectFactory();
		EnrollExternalAccountResponse response = obj.createEnrollExternalAccountResponse();
		logger.info("getMethod: " + request.getPRequestID() + "\n");
		try {
			response.setEnrollExternalAccountResult(enrollExternalAccountService.createEnrollExternalAccountObject());
			
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
			return null;
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	/** The execute transaction result service. */
	@Autowired
	ExecuteTransactionResultService executeTransactionResultService;
	
	/**
	 * Execute transaction.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/ExecuteTransaction/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<ExecuteTransactionResponse> ExecuteTransaction(@RequestPayload ExecuteTransaction request) {
		ObjectFactory obj = new ObjectFactory();
		ExecuteTransactionResponse response = obj.createExecuteTransactionResponse();
		logger.info("getMethod : " + request.getPRequestID() + "\n");
		try {
			response.setExecuteTransactionResult(executeTransactionResultService.createExecuteTransactionObject());			
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
			return null;
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/** The request external account result service. */
	@Autowired
	RequestExternalAccountResultService requestExternalAccountResultService;
	
	/**
	 * Request external account.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping(value = "/RequestExternalAccount/", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<RequestExternalAccountResponse> RequestExternalAccount(@RequestPayload RequestExternalAccount request) {
		ObjectFactory obj = new ObjectFactory();
		RequestExternalAccountResponse response = obj.createRequestExternalAccountResponse();
		logger.info("getMethod : " + request.getPRequestID() + "\n");
		try {
			response.setRequestExternalAccountResult(requestExternalAccountResultService.createRequestExternalAccountResultObject());			
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
			return null;
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
		
	
}
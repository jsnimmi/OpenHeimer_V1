package com.api.testautomation.stepdefs;

import com.api.testautomation.utils.RestAssuredAPI;
import com.google.inject.Inject;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.deser.DataFormatReaders;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.reactivex.rxjava3.core.Scheduler;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.client.methods.HttpGet;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.*;
import com.api.testautomation.utils.TestContextSetup;
import org.apache.http.util.EntityUtils;
import com.api.testautomation.utils.BaseClass;


public class StepsApi {

   /* public APIStepDefinition(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        //url = testContextSetup.getURL();
        url = baseClass.getURL();
    }*/

    RestAssuredAPI restAssuredApi;
    public HttpGet request;
    public String url;

    @Inject
    public StepsApi(RestAssuredAPI restAssuredApi)
    {
        this.restAssuredApi = restAssuredApi;
    }

    @Given("with api base url as {string}")
    public void with_api_baseurl_as(String apiBaseUrl){
        restAssuredApi.reqSpec.baseUri(apiBaseUrl);
    }

    @Given("with request end point as {string}")
    public void with_request_endpoint(String endPoint){
        restAssuredApi.endPoint = endPoint;
        restAssuredApi.reqSpec.contentType("application/json");
    }

/*
    @Given("with request body json as")
    public void with_request_body_json(String docString){
        restAssuredApi.reqSpec.body(docString);
    }
*/

    @Given("with request body  as below")
    public void with_request_body_json(DataTable dataTable){
        List<Map<String,Object>> data = dataTable.asMaps(String.class,Object.class);

        JSONObject reqBodyData = new JSONObject();
        reqBodyData.put("natid","natid-"+ RandomUtils.nextInt(100,1000));
        if(((String)data.get(0).get("name")).contains("MaxLength")){
            if(((String)data.get(0).get("name")).equalsIgnoreCase("MaxLength"))
            reqBodyData.put("name", RandomStringUtils.random(100,TRUE,FALSE));
            else if(((String)data.get(0).get("name")).equalsIgnoreCase("MaxLength+1"))
                reqBodyData.put("name", RandomStringUtils.random(101,TRUE,FALSE));
        }
        else{
        reqBodyData.put("name",(String)data.get(0).get("name") );}
        reqBodyData.put("gender",data.get(0).get("gender"));
        LocalDate date = LocalDate.now();
        String birthDate = data.get(0).get("birthDate").toString().trim();
        if(birthDate.contains("+")){
            date = date.plusDays(Character.getNumericValue(birthDate.charAt(birthDate.length()-1)));
        }
        if(birthDate.contains("-")){
            date = date.minusDays(Character.getNumericValue(birthDate.charAt(birthDate.length()-1)));
        }

        reqBodyData.put("birthDate", date);
         date = LocalDate.now();

        String deathDate = data.get(0).get("deathDate").toString().trim();
if(deathDate != null) {
    if (deathDate.contains("+")) {
        date = date.plusDays(deathDate.charAt(deathDate.length() - 1));
        reqBodyData.put("deathDate", date);

    }
    if (deathDate.contains("-")) {
        date = date.minusDays(Character.getNumericValue(deathDate.charAt(deathDate.length() - 1)));
        reqBodyData.put("deathDate", date);

    }
}
else{
       reqBodyData.put("deathDate", JSONObject.NULL);}
        reqBodyData.put("browniePoints",data.get(0).get("browniePoints"));
        reqBodyData.put("salary",data.get(0).get("salary"));
        reqBodyData.put("taxPaid",data.get(0).get("taxpaid"));

        Map vouchersMap = new HashMap<>();
        vouchersMap.put("voucherName", data.get(0).get("voucherName"));
        vouchersMap.put("voucherType", data.get(0).get("voucherType"));
        JSONObject requestParams1 = new JSONObject();
        JSONArray arrData = new JSONArray();
        requestParams1.put("voucherName", data.get(0).get("voucherName"));
        requestParams1.put("voucherType", data.get(0).get("voucherType"));
        arrData.put(requestParams1);
        reqBodyData.put("vouchers",arrData);

        restAssuredApi.reqSpec.body(reqBodyData.toString());
    }


    @When("with method as {string}")
    public void with_method_as(String methodAs){
       restAssuredApi.response =  restAssuredApi.reqSpec.when().log().all().post(restAssuredApi.endPoint);
    }

    @Then("verify status is {int}")
    public void status_as(int Status){
        Assert.assertEquals(restAssuredApi.response.statusCode(),Status);
    }

    @Then("verify error message in response is {string}")
    public void verify_error_message_in_response(String errorMsg){
        if(errorMsg.equals("null")){
            restAssuredApi.response.then().log().all().assertThat().body("message", nullValue());

        }
        else {

            restAssuredApi.response.then().log().all().assertThat().body("errorMsg", containsString(errorMsg));
        }
    }

    @When("the method as {string}")
    public void the_method_as(String methodAs){
        restAssuredApi.response =  restAssuredApi.reqSpec.when().log().all().get(restAssuredApi.endPoint);
    }

    @Given("^I Set request HEADER$")
    public void i_set_request_header() throws Throwable {

    }

    @When("^Send a GET HTTP request$")
    public void send_a_get_http_request() throws Throwable {

        request = new HttpGet(url + "calculator/taxRelief");

    }

    @When("^the request is send to server with page number as \"([^\"]*)\"$")
    public void sendRequest(int pageNumber)
    {
        restAssuredApi.response = restAssuredApi.reqSpec.when().log().all().get(restAssuredApi.endPoint);
    }

    @Then("verify response body in response is {string}")
    public void verify_response_body_in_response(String errorMsg){
       /* if(errorMsg.equals("null")){
            restAssuredApi.response.then().log().all().assertThat().body("message", nullValue());

        }
        else {

            restAssuredApi.response.then().log().all().assertThat().body("errorMsg", containsString(errorMsg));
        }*/
        String voucherType = restAssuredApi.response.path("data[0].voucherType");
        Assert.assertEquals(voucherType,errorMsg);
    }


}
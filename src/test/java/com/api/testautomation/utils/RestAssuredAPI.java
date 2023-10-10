package com.api.testautomation.utils;

import io.cucumber.guice.ScenarioScoped;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

import static io.restassured.RestAssured.given;

@ScenarioScoped
public class RestAssuredAPI {


        public RequestSpecification reqSpec;
        public Response response;
        public String apiBaseUrl;
        public String httpMethod;
        public String endPoint;

        @Setter
        @Getter
        public Object reqBodyObj;
        @Setter @Getter public Object respBodyObj;

        public RestAssuredAPI(){
            reqSpec = given().log().all();
        }




    }



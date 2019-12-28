package com.zemoga.portfolio.service;

import com.zemoga.portfolio.model.Tweet;
import com.zemoga.portfolio.model.TwitterAuth;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwitterService {

    private final String basicToken = "Basic aGFVM3BJcGJxdEZVVm9WcFREZElrbDk1MTpZYWNrNGRuRng4aTQwMVh3N05qcENrNE1tTENRaDdCYXFxVWcxVXhTUFlHbDA0RXd3UQ==";
    private final String twitterAuthUrl = "https://api.twitter.com/oauth2/token";
    private final String twitterTimelineUrl = "https://api.twitter.com/1.1/statuses/user_timeline.json";
    private RestTemplate restTemplate;


    public TwitterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }

    private HttpHeaders setHeadersForAuth(){
        Map<String,String > headersList = new HashMap<>();
        headersList.put("Content-Type", "application/x-www-form-urlencoded");
        headersList.put("Content-Length","29");
        headersList.put("Authorization",basicToken);
        headersList.put("Accept-Encoding","gzip");
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(headersList);
        return headers;
    }

    private HttpHeaders getHeadersForTimeline(String bearerToken){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+ bearerToken);
        return headers;
    }

    private Try<ResponseEntity<TwitterAuth>> getBearerToken(){
        HttpHeaders headers = setHeadersForAuth();
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        return Try.of( () ->
                restTemplate.exchange(
                        twitterAuthUrl+"?grant_type=client_credentials",
                        HttpMethod.POST,
                        entity,
                        TwitterAuth.class
                        ));
    }

    private Option<List<Tweet>> getTwitterUserTimeline(String bearerToken, String twitterUserName){
        HttpHeaders headers = getHeadersForTimeline(bearerToken);
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        Try<ResponseEntity<List<Tweet>>> response = Try.of( () ->
            restTemplate.exchange(
                    twitterTimelineUrl + "?screen_name=" + twitterUserName + "&count=5",
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<Tweet>>() {
                    }
            ));
        return response.toOption().map(ResponseEntity::getBody);
    }

    public Option<List<Tweet>> getUserTweets(String twitterUserName){
        Option<String> optBearerToken = getBearerToken().map( responseEntity -> responseEntity.getBody().getAccess_token()).toOption();
        return optBearerToken
                .flatMap( token -> getTwitterUserTimeline(token,twitterUserName));
    }
}

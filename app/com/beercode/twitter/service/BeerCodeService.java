package com.beercode.twitter.service;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.beercode.twitter.factory.BeerCodeFactory;

/**
 * @author Goran Ojkic
 *
 */
public class BeerCodeService {
	
	/**
	 * @param tearm
	 * @return
	 * @throws TwitterException
	 */
	public static List<Tweet> findSearch(String tearm) throws TwitterException {
		 	Twitter twitter = BeerCodeFactory.get().getInstance();
		    Query query = new Query(tearm);
		    QueryResult result = twitter.search(query);
		    return result.getTweets();
	}
	
	/**
	 * @return
	 * @throws TwitterException
	 */
	public static Status getLastStatus() throws TwitterException {
	 	Twitter twitter = BeerCodeFactory.get().getInstance();
	 	ResponseList<Status> status = null;
	 	Status lastStatus = null;
	 		status = twitter.getUserTimeline();
	 		if(status.size()>0){
	 			lastStatus = status.get(0);
	 		}
	 	return lastStatus;
	}
	
	/**
	 * @param status
	 * @return
	 * @throws TwitterException
	 */
	public static Status postRTStatus(Status status) throws TwitterException {
		Twitter twitter = BeerCodeFactory.get().getInstance();
	    Status newStatus = twitter.updateStatus(status.getText());
	    return newStatus;
	}
}

package com.beercode.twitter.service;

import java.util.ArrayList;
import java.util.List;

import play.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.beercode.twitter.factory.TwitterFactoryManager;

/**
 * @author Goran Ojkic
 * 
 */
public class TwitterService {
	static Twitter twitter = TwitterFactoryManager.get().getInstance();

	/**
	 * @param tearm
	 * @return
	 * @throws TwitterException
	 */
	public static List<Tweet> search(String tearm) throws TwitterException {
		Logger.info("Search started with term" + tearm);
		Query query = new Query(tearm);
		QueryResult result = twitter.search(query);
		return result.getTweets();
	}

	/**
	 * @return
	 * @throws TwitterException
	 */
	public static Status getLastStatus() throws TwitterException {
		ResponseList<Status> status = null;
		Status lastStatus = null;
		status = twitter.getUserTimeline();
		if (status.size() > 0) {
			lastStatus = status.get(0);
		}
		
		return lastStatus;
	}

	public static List<Tweet> updateTimelineWithTerm(String term) throws TwitterException {
		List<Tweet> tweets = search(term);
		List<Tweet> publishedList = new ArrayList<Tweet>();
		Status lastPublishedStatus = getLastStatus();
		for (Tweet tweet : tweets) {
			if (lastPublishedStatus.getCreatedAt().compareTo(tweet.getCreatedAt()) <= 0) {
				twitter.retweetStatus(tweet.getId());
				publishedList.add(tweet);
			}
		}
		return publishedList;
	}
}

package com.beercode.twitter.factory;

import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Goran Ojkic
 * Singleton holder of twitter factory - gateway to twitter api
 * 
 */
public class TwitterFactoryManager {

	private static final String OAUTH_ACCESS_TOKEN_SECRET = "BeV5621q4MfKxlQ9pZjKbOftrcN19VYw288TMgCPcw0";
	private static final String OAUTH_ACCESS_TOKEN = "62830160-XzJvMcmb1zfTZ4ON7WP9imJ7pCQCpsGSQxgGAr8VB";
	private static final String OAUTH_CONSUMER_SECRET = "XcpDCoXuRyw2PK8KwYS2l1rKc5CF70RVs5WJEqCRUQ";
	private static final String OAUTH_CONSUMER_KEY = "fs7yS8wib3greOTE9tqWEQ";
	
	private static TwitterFactory twitterFactory;

	/**
	 * instance of twitterFactory
	 * @return
	 */
	public static TwitterFactory get() {
		if (twitterFactory == null) {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(OAUTH_CONSUMER_KEY)
					.setOAuthConsumerSecret(OAUTH_CONSUMER_SECRET)
					.setOAuthAccessToken(OAUTH_ACCESS_TOKEN)
					.setOAuthAccessTokenSecret(OAUTH_ACCESS_TOKEN_SECRET);
			twitterFactory = new TwitterFactory(cb.build());
		}
		return twitterFactory;
	}

}

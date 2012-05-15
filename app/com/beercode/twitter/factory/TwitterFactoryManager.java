package com.beercode.twitter.factory;

import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Goran Ojkic
 * Singleton holder of twitter factory - gateway to twitter api
 * 
 */
public class TwitterFactoryManager {

	private static final String OAUTH_ACCESS_TOKEN_SECRET = "y12l7Mh3ohyWjg6n88PyBsvqJ6UTBeYPL4BOd5kcoU";
	private static final String OAUTH_ACCESS_TOKEN = "565365348-zsROoWilxn5M3atBKn4NqziYOTj9B1pQpg2lsDZ4";
	private static final String OAUTH_CONSUMER_SECRET = "mGh8SBvx89X7AoaWQRUg9Q";
	private static final String OAUTH_CONSUMER_KEY = "KONfXMfJeSi9wqTXF5I9L4YT1j0qcQBrnsolhtG8iZ8";
	
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

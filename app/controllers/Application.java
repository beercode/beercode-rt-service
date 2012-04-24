package controllers;

import play.*;
import play.mvc.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.*;

import com.beercode.twitter.factory.BeerCodeFactory;
import com.beercode.twitter.service.BeerCodeService;

/**
 * @author Goran Ojkic
 *
 */
public class Application extends Controller {

	public static void index() {
		try {
			renderJSON(BeerCodeService.findSearch("#beercode"));
		} catch (TwitterException e) {
			e.printStackTrace();
		}

	}

}
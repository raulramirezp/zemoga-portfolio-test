package com.zemoga.portfolio;

import com.zemoga.portfolio.DAO.PortfolioDAO;
import com.zemoga.portfolio.model.Portfolio;
import com.zemoga.portfolio.model.Tweet;
import com.zemoga.portfolio.service.TwitterService;
import io.vavr.control.Option;
import org.springframework.web.client.RestTemplate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/user-profile")
public class ServletPortfolioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PortfolioDAO portfolioDAO;
	private TwitterService twitterService;
    public ServletPortfolioController() {
        super();
        this.portfolioDAO = new PortfolioDAO(
        		"jdbc:mysql://zemoga-test-db.crhpedy9xxto.us-east-1.rds.amazonaws.com",
				"zemoga_test_db",
				"Zem0ga.101");
        this.twitterService = new TwitterService(new RestTemplate());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filter = request.getParameter("twitterUserName");
		getUserProfile(request, response,filter);
	}

	private Option<ArrayList<Portfolio>> getAllPortfolio(){
		return portfolioDAO.getAllPortfolios();
	}

	private Option<List<Portfolio>> getPortfoliosFilteredList(String filter){
		return getAllPortfolio().map(list ->
				list.stream()
						.filter(portfolio1 -> portfolio1.getTwitterUserName().equals(filter))
						.collect(Collectors.toList()));
	}

	private Option<Portfolio> getOrElse(Option<List<Portfolio>> optPortfolios){
    	return optPortfolios.map( filteredList -> {
			if (filteredList.size() <= 0) {
				return new Portfolio(0, "User not found", "https://i.kym-cdn.com/profiles/icons/big/000/071/040/404%20is%20not%20found.jpg", "Not Found", "");
			}return filteredList.get(0);
		});
	}

	private Option<Portfolio> getUserProfile(HttpServletRequest request, HttpServletResponse response, String twitterUsername) throws ServletException, IOException {
		Option<Portfolio> portfolio = getOrElse(getPortfoliosFilteredList(twitterUsername));
		List<Tweet> userTimeline = getUserTimeline(twitterUsername);
		request.setAttribute("profile",portfolio.get());
		for(int i = 0; i < userTimeline.size(); i++){
			request.setAttribute("tweet"+(i+1), userTimeline.get(i).getText());
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
		return portfolio;
	}

	private List<Tweet> getDefaultTweetList(){
		List<Tweet> defaultList = new ArrayList<Tweet>();
		defaultList.add(new Tweet("No user, no tweets WuW"));
		return defaultList;
	}

	private List<Tweet> getUserTimeline(String twitterUsername){
		Option<List<Tweet>> twits = twitterService.getUserTweets(twitterUsername);
		return twits.getOrElse(getDefaultTweetList());
	}

}

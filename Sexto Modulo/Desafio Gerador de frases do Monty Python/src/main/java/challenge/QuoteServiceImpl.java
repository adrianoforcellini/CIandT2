package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> allQuotes = repository.findAll();
		return getRandomQuoteOfListOfQuotes(allQuotes);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> actorList = repository.findByActor(actor);
		return getRandomQuoteOfListOfQuotes(actorList);
	}

	private Quote getRandomQuoteOfListOfQuotes (List<Quote> list){
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
}
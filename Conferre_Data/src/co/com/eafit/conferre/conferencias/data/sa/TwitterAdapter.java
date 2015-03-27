package co.com.eafit.conferre.conferencias.data.sa;

import co.com.eafit.conferre.data.to.TweetTO;

public interface TwitterAdapter {
	public boolean tweet(TweetTO mensaje);
}

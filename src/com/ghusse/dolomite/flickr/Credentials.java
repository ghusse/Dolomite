package com.ghusse.dolomite.flickr;

import java.util.Map;

/**
 * Basic credential for accessing to the Flickr API.
 *
 * @author guillaumegautreau
 */
public class Credentials {
  /**
   * Flickr API key.
   */
  private final String apiKey;

  /**
   * Ctor.
   *
   * @param key  Flickr API key for your application
   */
  public Credentials(final String key) {
    this.apiKey = key;
  }

  /**
   * Gets the API key.
   *
   * @return    Your API key
   */
  public final String getKey() {
    return this.apiKey;
  }

  /**
   * Write parameters values for the request.
   *
   * @param args    Map of Parameter/Value to send to the API
   */
  public void putParams(final Map<String, String> args) {
    args.put("api_key", this.apiKey);
  }

  /**
   * Returns true if this instance of Credentials needs a signed request.
   * @return false
   */
  public boolean isSigned() {
    return false;
  }
}

/**
 * Copyright (c) Guillaume Gautreau 2011
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author guillaumegautreau
 */

package com.ghusse.dolomite.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Helper for url building.
 * 
 * @author guillaumegautreau
 */
public final class UrlBuilder {
  /**
   * Hidden Ctor.
   */
  protected UrlBuilder() {
  }

  /**
   * Sign a map of arguments, by adding a signature value in the map.
   * 
   * @param arguments
   *          Arguments to sign
   * @param signatureParam
   *          Signature param name
   * @param secret
   *          API secret
   */
  public static void sign(final Map<String, String> arguments,
      final String signatureParam, final String secret) {
    ArrayList<String> sorted = new ArrayList<String>();

    for (Map.Entry<String, String> entry : arguments.entrySet()) {
      sorted.add(entry.getKey());
    }

    Collections.sort(sorted);

    StringBuffer signed = new StringBuffer(secret);
    for (int i = 0; i < sorted.size(); i++) {
      signed.append(sorted.get(i));
      signed.append(arguments.get(sorted.get(i)));
    }

    arguments.put(signatureParam, Crypto.md5(signed.toString()));
  }

  /**
   * Constructs a full URI from a base URI and a map of param name/value.
   * @param baseUri     Base URI
   * @param arguments   Map of param/value
   * @return            Uri string
   */
  public static String getUri(final String baseUri,
      final Map<String, String> arguments) {
    StringBuffer uri = new StringBuffer(baseUri);

    boolean first = true;
    for (Map.Entry<String, String> entry : arguments.entrySet()) {
      uri.append(first ? "?" : "&");
      uri.append(entry.getKey());
      uri.append("=");
      uri.append(entry.getValue());
      first = false;
    }

    return uri.toString();
  }
}

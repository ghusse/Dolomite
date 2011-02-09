/* Copyright (c) Guillaume Gautreau 2011
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

import java.util.Iterator;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Iterator for a JS array.
 * @author guillaumegautreau
 *
 * @param <T>
 */
public class JsArrayIterator<T extends JavaScriptObject> implements Iterator<T> {
  
  /**
   * Iterated array.
   */
  private JsArray<T> iterated;
  
  /**
   * Iteration index.
   */
  private int index;
  
  /**
   * Ctor.
   * @param array   Iterated array.
   */
  public JsArrayIterator(final JsArray<T> array) {
    this.iterated = array;
    this.index = -1;
  }

  @Override
  public boolean hasNext() {
    return this.iterated != null && this.iterated.length() > this.index + 1;
  }

  @Override
  public T next() {
    this.index++;
    return this.index < this.iterated.length() ? this.iterated.get(this.index) : null;
  }

  @Override
  public void remove() {
    throw new RuntimeException("Not implemented");
  }

}

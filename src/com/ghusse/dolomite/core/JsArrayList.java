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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Wrapper around a JsArray.
 * @author guillaumegautreau
 *
 * @param <T>
 */
public class JsArrayList<T extends JavaScriptObject> implements List<T>{

  /**
   * Wrapped array.
   */
  private JsArray<T> array;
  
  /**
   * Ctor.
   * @param wrapped   Wrapped array
   */
  public JsArrayList(final JsArray<T> wrapped) {
    this.array = wrapped;
  }
  
  @Override
  public boolean add(final T arg0) {
    this.array.push(arg0);
    return true;
  }

  @Override
  public void add(final int arg0, final T arg1) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean addAll(final Collection<? extends T> arg0) {
    for (Iterator<? extends T> it = arg0.iterator(); it.hasNext();) {
      this.array.push(it.next());
    }
    
    return true;
  }

  @Override
  public boolean addAll(final int arg0, final Collection<? extends T> arg1) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void clear() {
    while (this.array.length() > 0) {
      this.array.shift();
    }
  }

  @Override
  public boolean contains(final Object arg0) {
    return this.indexOf(arg0) != -1;
  }

  @Override
  public boolean containsAll(final Collection<?> arg0) {
    if (arg0 == null) {
      return true;
    }
    
    for (Iterator<?> it = arg0.iterator(); it.hasNext();) {
      Object o = it.next();
      if (!this.contains(o)) {
        return false;
      }
    }
    
    return true;
  }

  @Override
  public T get(final int arg0) {
    return this.array.get(arg0);
  }

  @Override
  public int indexOf(final Object arg0) {
    for (int i = 0; i < this.array.length(); i++) {
      if (arg0 == this.array.get(i)) {
        return i;
      }
    }
    
    return -1;
  }

  @Override
  public boolean isEmpty() {
    return this.array.length() == 0;
  }

  @Override
  public Iterator<T> iterator() {
    return this.array == null ? new EmptyIterator<T>() : new JsArrayIterator<T>(this.array);
  }

  @Override
  public int lastIndexOf(final Object arg0) {
    for (int i = this.array.length() - 1; i >= 0; i--) {
      if (this.array.get(i) == arg0) {
        return i;
      }
    }
    
    return -1;
  }

  @Override
  public ListIterator<T> listIterator() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public ListIterator<T> listIterator(final int arg0) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean remove(final Object arg0) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public T remove(final int arg0) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean removeAll(final Collection<?> arg0) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean retainAll(final Collection<?> arg0) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public T set(final int arg0, final T arg1) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public int size() {
    return this.array.length();
  }

  @Override
  public List<T> subList(final int arg0, final int arg1) {
    ArrayList<T> result = new ArrayList<T>();
    
    for (int i = arg0; i < arg1 && i < this.array.length(); i++) {
      result.add(this.array.get(i));
    }
    
    return result;
  }

  @Override
  public Object[] toArray() {
    return this.subList(0, this.array.length()).toArray();
  }

  @Override
  public <T> T[] toArray(final T[] arg0) {
    throw new RuntimeException("Not implemented");
  }

}

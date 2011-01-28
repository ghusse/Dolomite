/** Copyright (c) Guillaume Gautreau 2011
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

package com.ghusse.dolomite.flickr.photos;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import com.ghusse.dolomite.flickr.Credentials;
import com.ghusse.dolomite.flickr.PhotoListSearch;
import com.ghusse.dolomite.flickr.PhotosResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Call to the search method.
 * @author guillaumegautreau
 */
public class Search extends PhotoListSearch {

  /**
   * Name of the method.
   */
  public static final String METHOD = "flickr.photos.search";
  
  /**
   * Searched tags.
   */
  private HashSet<String> tags = new HashSet<String>();
  
  /**
   * Requested machine tags.
   */
  private HashSet<String> machineTags = new HashSet<String>();
  
  /**
   * Ctor.
   * @param connexionCredentials        Connexion credentials
   */
  public Search(final Credentials connexionCredentials) {
    super(METHOD, connexionCredentials);
  }
  
  /**
   * Add a tag to the searched tags.
   * @param tag     Added tag.
   */
  public void addTag(final String tag) {
    this.tags.add(tag);
  }
  
  /**
   * Add a collection of searched tags into the request.
   * @param tagList    A collection of tags
   */
  public void addTags(final Collection<String> tagList) {
    for (Iterator<String> tagIterator = tagList.iterator(); tagIterator.hasNext();) {
      this.addTag(tagIterator.next());
    }
  }
  
  /**
   * Sets the desired tag mode.
   * @param mode    tag mode
   */
  public void setTagMode(final TagMode mode) {
    this.setArgument("tag_mode", mode.toString());
  }
  
  /**
   * Sets the free text search.
   * @param text    Searched text
   */
  public void setText(final String text) {
    this.setArgument("text", text);
  }
  
  /**
   * Sets the order in which to sort returned photos.
   * @param order   Desired order
   */
  public void setSortOrder(final SortOrder order) {
    this.setArgument("sort", order.toString());
  }
  
  /**
   * Sets the 4 values defining the Bounding Box of the area that will be searched.
   * @param minLong     Minimum longitude (between -180 and 180)
   * @param minLat      Minimum latitude (between -90 and 90)
   * @param maxLong     Maximum longitude (between -180 and 180)
   * @param maxLat      Maximum latitude (between -90 and 90)
   */
  public void setBBox(final double minLong, final double minLat, final double maxLong, final double maxLat) {
    
    StringBuilder result = new StringBuilder();
    result.append(minLong);
    result.append(",");
    result.append(minLat);
    result.append(",");
    result.append(maxLong);
    result.append(",");
    result.append(maxLat);
    
    this.setArgument("bbox", result.toString());
  }
  
  /**
   * Recorded accuracy level of the location information.
   * @param accuracy    Accuracy level of location info.
   */
  public void setAccuracy(final Accuracy accuracy) {
    this.setArgument("accuracy", accuracy.toString());
  }
  
  /**
   * Sets a requested machine tag, with special syntax.
   * See http://www.flickr.com/services/api/flickr.photos.search.html
   * 
   * @param machineTag Machine tags with special syntax
   */
  public void setMachineTag(final String machineTag) {
    this.machineTags.add(machineTag);
  }
  
  /**
   * Sets the search mode for machine tags search request.
   * @param mode    Tag mode
   */
  public void setMachineMode(final TagMode mode) {
    this.setArgument("machine_tag_mode", mode.toString());
  }
  
  /**
   * Sets the id of a group who's pool to search.
   * @param group   Pool's id
   */
  public void setGroupId(final String group) {
    this.setArgument("group_id", group);
  }
  
  /**
   * Experimental Flickr feature.
   * Search your contacts.
   * 
   * @param contacts        Contact search value.
   */
  public void setContacts(final Contacts contacts) {
    this.setArgument("contacts", contacts.toString());
  }
  
  /**
   * Sets a 32-bit identifier that uniquely represents spatial entities. (not used if bbox argument is present). 
   * @param id      Spatial entity id.
   */
  public void setWOEId(final String id) {
    this.setArgument("woe_id", id);
  }
  
  /**
   * A flickr place id (not used if bbox is present).
   * @param id  Place id.
   */
  public void setPlaceId(final String id) {
    this.setArgument("place_id", id);
  }
  
  /**
   * Filter results by media type.
   * @param media   Requested media.
   */
  public void setMedia(final Media media) {
    this.setArgument("media", media.toString());
  }
  
  /**
   * Any photo that has been geotagged, or any photo that has not been geotagged. 
   * @param hasGeo  if true: any photos that has been geotagged
   */
  public void setHasGeo(final boolean hasGeo) {
    this.setArgument("has_geo", hasGeo ? "1" : "0");
  }
  
  /**
   * Sets a value representing the photo's geotagginess beyond latitude and longitude.
   * @param context Geo context
   */
  public void setGeoContext(final GeoContext context) {
    this.setArgument("geo_context", context.toString());
  }
  
  /**
   * Sets a valid latitude, in decimal format, for doing radial geo queries. 
   * @param latitude    Latitude value
   */
  public void setLatitude(final float latitude) {
    this.setArgument("lat", String.valueOf(latitude));
  }
  
  /**
   * Sets a valid longitude, in decimal format, for doing radial geo queries. 
   * @param longitude   Longitude value
   */
  public void setLongitude(final float longitude) {
    this.setArgument("long", String.valueOf(longitude));
  }
  
  /**
   * A valid radius used for geo queries, greater than zero and less than 20 miles (or 32 kilometers), for use with point-based geo queries.
   * @param radius  Radius for geo queries.
   */
  public void setRadius(final float radius) {
    this.setArgument("radius", String.valueOf(radius));
  }
  
  /**
   * Sets the radius unit.
   * @param unit    Unit.
   */
  public void setRadiusUnit(final RadiusUnit unit) {
    this.setArgument("radius_unit", unit.toString());
  }
  
  /**
   * Limits the scope of the search to only photos that are part of the Flickr Commons project.
   * @param commons True to limit the scope.
   */
  public void setIsCommons(final boolean commons) {
    this.setArgument("is_commons", commons ? "true" : "false");
  }
  
  /**
   * Limits the scope of the search to only photos that are in a gallery.
   * @param gallery True to limit the scope.
   */
  public void setInGallery(final boolean gallery) {
    this.setArgument("in_gallery", gallery ? "true" : "false");
  }
  
  /**
   * Limits the scope of the search to only photos that are for sale on Getty. 
   * @param getty   True to limit the scope.
   */
  public void setIsGetty(final boolean getty) {
    this.setArgument("is_getty", getty ? "true" : "false");
  }
  
  /**
   * Sends the request.
   * @param callback    Async callback
   * @param args        Additional arguments
   */
  protected void send(final AsyncCallback<PhotosResponse> callback,
      final Map<String, String> args) {
    this.commaList(this.tags, "tags");
    this.commaList(this.machineTags, "machine_tags");
    
    super.send(callback, args);
  }
  
  /**
   * Creates a list of comma separated values from a String collection.
   * Then adds it to the argument list.
   * 
   * @param values      Collection of values.
   * @param argument    Name of the argument.
   */
  protected void commaList(final Collection<String> values, final String argument) {
    if (values.size() > 0) {
      StringBuilder stringValue = new StringBuilder();
      boolean first = true;
      
      for (Iterator<String> tag = values.iterator(); tag.hasNext();) {
        if (!first) {
          stringValue.append(",");
        }
        
        stringValue.append(tag.next());
        first = false;
       }
      
      this.setArgument(argument, stringValue.toString());
    }
  }

}

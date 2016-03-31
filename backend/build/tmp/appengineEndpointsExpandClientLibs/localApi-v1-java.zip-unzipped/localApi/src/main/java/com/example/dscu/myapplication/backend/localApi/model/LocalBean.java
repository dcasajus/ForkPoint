/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-03-25 20:06:55 UTC)
 * on 2016-03-31 at 10:55:44 UTC 
 * Modify at your own risk.
 */

package com.example.dscu.myapplication.backend.localApi.model;

/**
 * Model definition for LocalBean.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the localApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class LocalBean extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String carrer;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String data;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String descripcio;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String horari;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer icons;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer isFavorite;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double lat;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String local;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double lon;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String preu;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCarrer() {
    return carrer;
  }

  /**
   * @param carrer carrer or {@code null} for none
   */
  public LocalBean setCarrer(java.lang.String carrer) {
    this.carrer = carrer;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getData() {
    return data;
  }

  /**
   * @param data data or {@code null} for none
   */
  public LocalBean setData(java.lang.String data) {
    this.data = data;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDescripcio() {
    return descripcio;
  }

  /**
   * @param descripcio descripcio or {@code null} for none
   */
  public LocalBean setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getHorari() {
    return horari;
  }

  /**
   * @param horari horari or {@code null} for none
   */
  public LocalBean setHorari(java.lang.String horari) {
    this.horari = horari;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getIcons() {
    return icons;
  }

  /**
   * @param icons icons or {@code null} for none
   */
  public LocalBean setIcons(java.lang.Integer icons) {
    this.icons = icons;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public LocalBean setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getIsFavorite() {
    return isFavorite;
  }

  /**
   * @param isFavorite isFavorite or {@code null} for none
   */
  public LocalBean setIsFavorite(java.lang.Integer isFavorite) {
    this.isFavorite = isFavorite;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLat() {
    return lat;
  }

  /**
   * @param lat lat or {@code null} for none
   */
  public LocalBean setLat(java.lang.Double lat) {
    this.lat = lat;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getLocal() {
    return local;
  }

  /**
   * @param local local or {@code null} for none
   */
  public LocalBean setLocal(java.lang.String local) {
    this.local = local;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLon() {
    return lon;
  }

  /**
   * @param lon lon or {@code null} for none
   */
  public LocalBean setLon(java.lang.Double lon) {
    this.lon = lon;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPreu() {
    return preu;
  }

  /**
   * @param preu preu or {@code null} for none
   */
  public LocalBean setPreu(java.lang.String preu) {
    this.preu = preu;
    return this;
  }

  @Override
  public LocalBean set(String fieldName, Object value) {
    return (LocalBean) super.set(fieldName, value);
  }

  @Override
  public LocalBean clone() {
    return (LocalBean) super.clone();
  }

}
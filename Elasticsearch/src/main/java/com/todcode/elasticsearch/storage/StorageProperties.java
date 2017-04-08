package com.todcode.elasticsearch.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration class - this properties could be stored in application.properties file
 * 
 * @author steva
 *
 */
@ConfigurationProperties("storage")
public class StorageProperties {

  /**
   * Folder location for storing files
   */
  private String location = "upload-dir";

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

}

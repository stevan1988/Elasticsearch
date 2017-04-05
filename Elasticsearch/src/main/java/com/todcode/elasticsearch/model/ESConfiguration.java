package com.todcode.elasticsearch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "ES_CONFIGURATION")
public class ESConfiguration {

  @GeneratedValue
  @Id
  @Column(name = "id", nullable = false)
  private int id;

  @Column(name = "indexName")
  private String indexName;

  @Column(name = "isCluster")
  private String isCluster;

  @Column(name = "hostname")
  private String hostname;

  @Column(name = "port")
  private int port;

  @Column(name = "clusterName")
  private String clusterName;

  @Column(name = "reindexDate")
  private Date reindexDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIndex() {
    return indexName;
  }

  public void setIndex(String indexName) {
    this.indexName = indexName;
  }

  public String getIsCluster() {
    return isCluster;
  }

  public void setIsCluster(String isCluster) {
    this.isCluster = isCluster;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getClusterName() {
    return clusterName;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  public Date getReindexDate() {
    return reindexDate;
  }

  public void setReindexDate(Date reindexDate) {
    this.reindexDate = reindexDate;
  }

}

package com.todcode.elasticsearch.client;

import java.net.InetSocketAddress;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.todcode.elasticsearch.dao.IESConfigurationDAO;
import com.todcode.elasticsearch.model.ESConfiguration;

public class ESClient {

  private static final Logger logger = LoggerFactory.getLogger(ESClient.class);

  @Autowired
  IESConfigurationDAO configurationDAO;

  // make only one instance of client
  private static TransportClient client;

  public Client getClient() {
    if (client == null) {
      ESConfiguration configuration = configurationDAO.findESConfigurationById(1);
      String clusterName = configuration.getClusterName();
      if (clusterName != null && clusterName != "") {
        Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName).build();
        client = TransportClient.builder().settings(settings).build().addTransportAddress(
            new InetSocketTransportAddress(new InetSocketAddress(configuration.getHostname(), configuration.getPort())));
      } else {
        client = TransportClient.builder().build().addTransportAddress(
            new InetSocketTransportAddress(new InetSocketAddress(configuration.getHostname(), configuration.getPort())));
      }
    }
    return client;
  }
  
  public void closeESClient(){
    client = null;
  }

  public void a() {
    String indexName = "test_index";
    Client client = NodeBuilder.nodeBuilder().client(true).node().client();

    boolean indexExists = client.admin().indices().prepareExists(indexName).execute().actionGet().isExists();
    if (indexExists) {
      client.admin().indices().prepareDelete(indexName).execute().actionGet();
    }
    client.admin().indices().prepareCreate(indexName).execute().actionGet();

    SearchResponse allHits;
  }

}

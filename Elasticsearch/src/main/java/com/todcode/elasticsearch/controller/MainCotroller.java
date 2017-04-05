package com.todcode.elasticsearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.todcode.elasticsearch.dao.IESConfigurationDAO;
import com.todcode.elasticsearch.model.ESConfiguration;

@Controller
public class MainCotroller {

  @Autowired
  IESConfigurationDAO configurationDAO;

  private static final Logger logger = LoggerFactory.getLogger(MainCotroller.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getSearchPage() {
    return "search_page";
  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public String getSearchResultPage(@RequestParam("q") String q) {
    logger.info("getSearchResults: q=" + q);
    return "search_page";
  }

  @RequestMapping(value = "/configuration", method = RequestMethod.GET)
  public String getConfigurationPage(Model model) {
    logger.info("Oppening configuraion page");

    ESConfiguration configuration = configurationDAO.findESConfigurationById(1);
    if (configuration == null) {
      configuration = new ESConfiguration();
      configuration.setId(1);
      configuration.setHostname("localhost");
      configuration.setPort(9300);
      configuration.setClusterName("none");
      configuration.setIsCluster("false");
      configuration.setIndex("index");//;kj
      configurationDAO.save(configuration);
    }
//    model.addAttribute("port", configuration.getPort());
//    model.addAttribute("hostname", configuration.getHostname());
//    model.addAttribute("clusterName", configuration.getClusterName());
//    model.addAttribute("isCluster", configuration.getIsCluster());
//    model.addAttribute("index", configuration.getIndex());
    model.addAttribute("configuration", configuration);
    logger.info("model " + model.toString());
    return "configuration";
  }

  @RequestMapping(value = "/saveConfiguration", method = RequestMethod.POST)
  public String saveConfiguration(Model model, @RequestParam("hostname") String hostname, @RequestParam("port") String port,
      @RequestParam("indexName") String indexName,
      @RequestParam("clusterName") String clusterName) {
    logger.info("Save configuraion page");
    logger.info(
        "hostname=" + hostname + " port=" + port + " indexName=" + indexName +  " clusterName=" + clusterName);
    ESConfiguration configuration = configurationDAO.findESConfigurationById(1);
    configuration.setHostname(hostname);
    configuration.setPort(Integer.parseInt(port));
    configuration.setClusterName(clusterName);
    configuration.setIndex(indexName);
    configurationDAO.save(configuration);
    
    model.addAttribute("configuration", configuration);
    return "configuration";
  }



}

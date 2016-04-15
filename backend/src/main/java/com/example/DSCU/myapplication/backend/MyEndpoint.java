/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.DSCU.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;

import java.util.ArrayList;
import java.util.List;

/** An endpoint class we are exposing */
@Api(
  name = "localApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.DSCU.example.com",
    ownerName = "backend.myapplication.DSCU.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "storeLocal")
    public void storeLocal(LocalBean localBean) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            Key localBeanParentKey = KeyFactory.createKey("localBeanParent", "localf");
            Entity localEntity = new Entity("LocalBean", localBean.getId(),localBeanParentKey);
            localEntity.setProperty("local", localBean.getLocal());
            localEntity.setProperty("descripcio", localBean.getDescripcio());
            localEntity.setProperty("carrer", localBean.getCarrer());
            localEntity.setProperty("horari", localBean.getHorari());
            localEntity.setProperty("preu", localBean.getPreu());
            localEntity.setProperty("comentaris", localBean.getComentaris());
            //localEntity.setProperty("lat", localBean.getLat());
            //localEntity.setProperty("lon", localBean.getLon());

            datastoreService.put(localEntity);
            txn.commit();
        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }

    @ApiMethod(name = "updateLocal2")
    public void updateLocal(LocalBean localBean) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Key localBeanParentKey = KeyFactory.createKey("localBeanParent", "localf");
        Query query = new Query(localBeanParentKey);
        List<Entity> results = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
        Entity localEntity = new Entity("LocalBean", localBean.getId(),localBeanParentKey);
        localEntity.setProperty("local", localBean.getLocal());
        localEntity.setProperty("descripcio", localBean.getDescripcio());
        localEntity.setProperty("carrer", localBean.getCarrer());
        localEntity.setProperty("horari", localBean.getHorari());
        localEntity.setProperty("preu", localBean.getPreu());
        localEntity.setProperty("comentaris", localBean.getComentaris());
        datastoreService.put(localEntity);
    }

    @ApiMethod(name = "getLocal")
    public List<LocalBean> getLocal() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Key localBeanParentKey = KeyFactory.createKey("localBeanParent", "localf");
        Query query = new Query(localBeanParentKey);
        List<Entity> results = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
        ArrayList<LocalBean> localBeans = new ArrayList<LocalBean>();
        for (Entity result : results) {
            LocalBean localBean = new LocalBean();
            localBean.setId(result.getKey().getId());
            localBean.setLocal((String) result.getProperty("local"));
            localBean.setDescripcio((String) result.getProperty("descripcio"));
            localBean.setCarrer((String) result.getProperty("carrer"));
            localBean.setHorari((String) result.getProperty("horari"));
            localBean.setPreu((String) result.getProperty("preu"));
            localBean.setComentaris((List<String>) result.getProperty("comentaris"));
            //localBean.setLat((String) result.getProperty("lat"));
            //localBean.setLon(result.getProperty("lon"));

            localBeans.add(localBean);
        }

        return localBeans;
    }

    @ApiMethod(name = "clearLocal")
    public void clearTasks() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            Key localBeanParentKey = KeyFactory.createKey("localBeanParent", "localf");
            Query query = new Query(localBeanParentKey);
            List<Entity> results = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
            for (Entity result : results) {
                datastoreService.delete(result.getKey());
            }
            txn.commit();
        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }


}

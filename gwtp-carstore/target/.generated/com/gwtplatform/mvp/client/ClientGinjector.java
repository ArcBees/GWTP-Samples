package com.gwtplatform.mvp.client;

import com.google.gwt.inject.client.Ginjector;
import com.gwtplatform.carstore.client.gin.MyGinjector;
import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.DefaultBootstrapper;
import javax.inject.Provider;
import com.google.gwt.inject.client.AsyncProvider;

public interface ClientGinjector extends Ginjector, MyGinjector {
  static ClientGinjector SINGLETON = ((GinjectorProvider) GWT.create(GinjectorProvider.class)).get();
  
  EventBus getEventBus();
  
  PlaceManager getPlaceManager();
  
  DefaultBootstrapper getDefaultBootstrapper();
  
  @com.gwtplatform.mvp.client.annotations.DefaultGatekeeper
  com.gwtplatform.carstore.client.security.LoggedInGatekeeper getcomgwtplatformcarstoreclientsecurityLoggedInGatekeeper();
  
  Provider<com.gwtplatform.carstore.client.application.ApplicationPresenter> getcomgwtplatformcarstoreclientapplicationApplicationPresenter();
  
  Provider<com.gwtplatform.carstore.client.application.UnauthorizedPresenter> getcomgwtplatformcarstoreclientapplicationUnauthorizedPresenter();
  
  Provider<com.gwtplatform.carstore.client.application.cars.car.RootCarPresenter> getcomgwtplatformcarstoreclientapplicationcarscarRootCarPresenter();
  
  Provider<com.gwtplatform.carstore.client.application.login.LoginPresenter> getcomgwtplatformcarstoreclientapplicationloginLoginPresenter();
  
  Provider<com.gwtplatform.carstore.client.application.stats.StatisticsPresenter> getcomgwtplatformcarstoreclientapplicationstatsStatisticsPresenter();
  
  AsyncProvider<com.gwtplatform.carstore.client.application.cars.CarsPresenter> getcomgwtplatformcarstoreclientapplicationcarsCarsPresenter();
  
  AsyncProvider<com.gwtplatform.carstore.client.application.manufacturer.ManufacturerDetailPresenter> getcomgwtplatformcarstoreclientapplicationmanufacturerManufacturerDetailPresenter();
  
  AsyncProvider<com.gwtplatform.carstore.client.application.manufacturer.ManufacturerPresenter> getcomgwtplatformcarstoreclientapplicationmanufacturerManufacturerPresenter();
  
  AsyncProvider<com.gwtplatform.carstore.client.application.rating.RatingDetailPresenter> getcomgwtplatformcarstoreclientapplicationratingRatingDetailPresenter();
  
  AsyncProvider<com.gwtplatform.carstore.client.application.rating.RatingPresenter> getcomgwtplatformcarstoreclientapplicationratingRatingPresenter();
  
  AsyncProvider<com.gwtplatform.carstore.client.application.report.ReportPresenter> getcomgwtplatformcarstoreclientapplicationreportReportPresenter();
}

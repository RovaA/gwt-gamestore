package mg.rova.gamestore.client;

import mg.rova.gamestore.client.dagger.AppInjector;
import mg.rova.gamestore.client.dagger.DaggerAppInjector;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.mvp.AppPlaceHistoryMapper;
import mg.rova.gamestore.client.mvp.ContentActivityMapper;
import mg.rova.gamestore.client.mvp.MenuActivityMapper;
import mg.rova.gamestore.client.place.HomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class Gamestore implements EntryPoint {

	public void onModuleLoad() {

		final AppInjector injector = DaggerAppInjector.create();

		EventBus eventBus = injector.getEventBus();
		MainUi mainUi = injector.getMainUi();

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper menuActivityMapper = new MenuActivityMapper(injector);
		ActivityManager menuActivityManager = new ActivityManager(menuActivityMapper, eventBus);
		menuActivityManager.setDisplay(mainUi.getWestLayoutPanel());

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper contentActivityMapper = new ContentActivityMapper(injector);
		ActivityManager ContentActivityManager = new ActivityManager(contentActivityMapper, eventBus);
		ContentActivityManager.setDisplay(mainUi.getCenterLayoutPanel());

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(injector.getPlaceController(), eventBus, new HomePlace(""));

		RootLayoutPanel.get().add(mainUi);
		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();
	}
}

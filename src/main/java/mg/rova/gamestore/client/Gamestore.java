package mg.rova.gamestore.client;

import mg.rova.gamestore.client.gin.ClientGinjector;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.mvp.AppPlaceHistoryMapper;
import mg.rova.gamestore.client.mvp.ContentActivityMapper;
import mg.rova.gamestore.client.mvp.MenuActivityMapper;
import mg.rova.gamestore.client.mvp.NavigationActivityMapper;
import mg.rova.gamestore.client.place.HomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class Gamestore implements EntryPoint {

	private ClientGinjector injector = GWT.create(ClientGinjector.class);

	public void onModuleLoad() {

		EventBus eventBus = injector.getEventBus();
		PlaceController placeController = injector.getPlaceController();
		MainUi mainUi = injector.getMainUi();

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper navigationActivityMapper = new NavigationActivityMapper(injector);
		ActivityManager navigationActivityManager = new ActivityManager(navigationActivityMapper, eventBus);
		navigationActivityManager.setDisplay(mainUi.getNorthLayoutPanel());

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
		historyHandler.register(placeController, eventBus, new HomePlace(""));

		RootLayoutPanel.get().add(mainUi);
		// Goes to the place represented on URL else default place
		historyHandler.handleCurrentHistory();
	}
}

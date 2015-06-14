package mg.rova.gamestore.client.gin;

import mg.rova.gamestore.client.bundle.Messages;
import mg.rova.gamestore.client.main.MainUi;
import mg.rova.gamestore.client.ui.HomeView;
import mg.rova.gamestore.client.ui.HomeViewImpl;
import mg.rova.gamestore.client.ui.MenuView;
import mg.rova.gamestore.client.ui.MenuViewImpl;
import mg.rova.gamestore.client.ui.NavigationView;
import mg.rova.gamestore.client.ui.NavigationViewImpl;

import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.api.messaging.MessageBus;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(NavigationView.class).to(NavigationViewImpl.class).in(Singleton.class);
		bind(MenuView.class).to(MenuViewImpl.class).in(Singleton.class);
		bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
	}

	@Provides
	@Singleton
	public EventBus getEventBus() {
		return new SimpleEventBus();
	}

	@Provides
	@Singleton
	@Inject
	public PlaceController getPlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}

	@Provides
	@Singleton
	public MainUi getMainUi() {
		return new MainUi();
	}

	@Provides
	@Singleton
	public Messages getMessages() {
		return GWT.create(Messages.class);
	}
	
	@Provides
	@Singleton
	public MessageBus getMessageBus() {
		return ErraiBus.get();
	}
}

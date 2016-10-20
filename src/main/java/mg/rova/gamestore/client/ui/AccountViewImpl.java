package mg.rova.gamestore.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;

public class AccountViewImpl extends Composite implements AccountView {

	private static AccountViewImplUiBinder uiBinder = GWT.create(AccountViewImplUiBinder.class);

	interface AccountViewImplUiBinder extends UiBinder<Widget, AccountViewImpl> {
	}

	@UiField
	MaterialButton editButton;
	
	protected Presenter presenter;

	public AccountViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("editButton")
	void onClick(ClickEvent e) {
		presenter.onEdit();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}

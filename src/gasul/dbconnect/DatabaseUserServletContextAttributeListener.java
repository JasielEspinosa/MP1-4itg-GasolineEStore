package gasul.dbconnect;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

import gasul.model.*;

public class DatabaseUserServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {

		if (scae.getName().equals("gasul") && scae.getName().equals("cardmo")) {
			System.out.println("ALERT. A new attribute has been added. Key: " + scae.getName() + " Value: "
					+ ((UserBean) scae.getValue()).getFirstName());
		} else {
			System.out.println("ALERT. A new attribute has been added. Key: " + scae.getName() + " Value: " + scae.getValue());
		}
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		if (scae.getName().equals("gasul") && scae.getName().equals("cardmo")) {
			System.out.println("ALERT. A new attribute has been removed. Key: " + scae.getName() + " Value: "
					+ ((UserBean) scae.getValue()).getFirstName());
		} else {
			System.out.println("ALERT. A new attribute has been removed. Key: " + scae.getName() + " Value: " + scae.getValue());
		}
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		if (scae.getName().equals("gasul") && scae.getName().equals("cardmo")) {
			System.out.println("ALERT. A new attribute has been replaced. Key: " + scae.getName() + " Value: "
					+ ((UserBean) scae.getValue()).getFirstName());
		} else {
			System.out.println("ALERT. A new attribute has been replaced. Key: " + scae.getName() + " Value: " + scae.getValue());
		}
	}

}

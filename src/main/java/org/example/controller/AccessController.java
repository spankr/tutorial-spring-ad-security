/**
 * 
 */
package org.example.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller is the place for handling various access type events.
 * @author Lee_Vettleson
 * @see http://www.mkyong.com/spring-security/customize-http-403-access-denied-page-in-spring-security/
 *
 */
@Controller
public class AccessController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 403 - Access Denied
	 * @param user User attempting the access
	 * @param m Model for the view
	 * @return name of the view
	 */
	@RequestMapping(value = "access-denied", method=RequestMethod.GET)
	public String accessDenied403(Principal user, Model m) {

		String name = "Someone";
		if (user != null) {
			name = user.getName();
		}
		log.warn(
				"Uh oh, {} just tried to access something they shouldn't have!",
				name);

		return "access-denied";
	}

}

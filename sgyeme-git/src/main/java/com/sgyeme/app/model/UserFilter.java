package com.sgyeme.app.model;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiPredicate;



public class UserFilter implements BiPredicate<User, String> {

	@Override
	public boolean test(User e, String s) {
		if (e == null) {
			return false;
		}
		if (s == null || s.isEmpty()) {
			return true;
		}
		var text = s.toLowerCase();

		return Optional
				.ofNullable(
						e)
				.filter(t ->Objects.toString(e.getUsername(), "").toLowerCase().contains(text)
						|| Objects.toString(e.getFirstName(), "").toLowerCase().contains(text)
						|| Objects.toString(e.getLastName(), "").toLowerCase().contains(text)
						|| Objects.toString(e.getPhone(), "").toLowerCase().contains(text)
						|| Optional.ofNullable(e.isActive()).map(Objects::toString).map(String::toLowerCase)
								.filter(o -> o.contains(text)).isPresent())
				.isPresent();

	}
}

package com.softserve.edu.ita.data;

public class UrlRepository {
	public static enum Urls {
		YANDEX_URL("http://www.yandex.ru/");
		private String field;

		private Urls(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
}
package lps.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.lang.reflect.Field;

public class JsonHelper {
	public static String StringToJson(String key, String str) {
		return "\"" + key + "\":\"" + str + "\"";
	}

	@SuppressWarnings("unchecked")
	public static String ClassToJson(boolean isList, String key, Object model)
			throws NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		String json = isList ? "" : "\"" + key + "\":";
		Field[] field = model.getClass().getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			String item = "";
			String name = field[i].getName();
			String type = field[i].getType().toString();
			if (type.contains("String")) {
				field[i].setAccessible(true);
				item = StringToJson(name, (String) field[i].get(model));
			} else if (type.contains("List")) {
				item = ListToJson(name, (List<Object>) field[i].get(model));
			} else {
				item = ClassToJson(false, name, field[i].get(model));
			}
			json += (i == 0 ? "{" : ",") + item;
		}
		return json + "}";
	}

	public static <T> String ListToJson(String key, List<T> list)
			throws NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		String json = "\"" + key + "\":";
		if (list.size() == 0)
			return json + "\"\"";
		for (int i = 0; i < list.size(); i++) {
			json += (i == 0 ? "[" : ",") + ClassToJson(true, "", list.get(i));
		}
		return json + "]";
	}
}

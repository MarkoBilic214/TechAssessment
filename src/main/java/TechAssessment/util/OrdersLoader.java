package TechAssessment.util;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import TechAssessment.model.OrderList;

import TechAssessment.util.GsonSerializers.OrdersSerializer;

public class OrdersLoader {
	OrderList orders;
	
	public void loadOrders() {
		try {
			URL url = Resources.getResource("coding-assigment-orders.json");
			String text = Resources.toString(url, StandardCharsets.UTF_8);
			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(OrderList.class, new OrdersSerializer());
			Gson gson = builder.create();
			orders = gson.fromJson(text, OrderList.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("encountered problem reading file: "+ e);
		}
	}
	
	public OrderList getOrders() {
		return orders;
	}
}

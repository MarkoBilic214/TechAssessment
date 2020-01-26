package TechAssessment.util.GsonSerializers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import TechAssessment.model.Order;
import TechAssessment.model.OrderList;

public class OrdersSerializer implements JsonDeserializer<OrderList> {

    @Override
    public OrderList deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = element.getAsJsonObject();
        ArrayList<Order> orders = new ArrayList<Order>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            // For individual City objects, we can use default deserialisation:
            Order order = context.deserialize(entry.getValue(), Order.class); 
            order.setOrderName(entry.getKey());
            orders.add(order);
        }
        return new OrderList(orders);
    }

}

package by.netcracker.artemyev.web.order;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.ServerResponse;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class describes controller for work with entity Order
 * @autor Artemyev Artoym
 */
@Controller
public class OrderController {
    private static String className = OrderController.class.getName();
    private static Logger logger = LogManager.getLogger(className);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "airline/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateFlight( @RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_EDIT_FLIGHT);
        String returnText = ServerResponse.EDIT_FLIGHT;
        JSONObject jsonObject = new JSONObject(json);
        logger.info(jsonObject.toString());
        try {
            orderService.createOrder(Long.valueOf(jsonObject.getString("idFlight")), Long.valueOf(jsonObject.getString("idUser")), jsonObject.getString("name"), jsonObject.getString("surname"), jsonObject.getString("phone"), jsonObject.getString("mail"));
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }
}

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
    private static final String FIELD_ID_FLIGHT = "idFlight";
    private static final String FIELD_ID_USER = "idUser";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_SURNAME = "surname";
    private static final String FIELD_PHONE = "phone";
    private static final String FIELD_MAIL = "mail";

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "airline/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateFlight(@RequestBody String json) {
        logger.debug(LoggingName.FUNCTION_EDIT_FLIGHT);
        String returnText = ServerResponse.EDIT_FLIGHT;
        JSONObject jsonObject = new JSONObject(json);
        logger.info(jsonObject.toString());
        try {
            orderService.createOrder(
                    Long.valueOf(jsonObject.getString(FIELD_ID_FLIGHT)),
                    Long.valueOf(jsonObject.getString(FIELD_ID_USER)),
                    jsonObject.getString(FIELD_NAME),
                    jsonObject.getString(FIELD_SURNAME),
                    jsonObject.getString(FIELD_PHONE),
                    jsonObject.getString(FIELD_MAIL));
        } catch (ServiceException e) {
            logger.debug(e);
        }
        return returnText;
    }

}

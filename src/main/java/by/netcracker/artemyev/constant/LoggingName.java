package by.netcracker.artemyev.constant;

/**
 * Class contains all function names
 * @autor Artemyev Artoym
 */
public final class LoggingName {
    public static final String FUNCTION_GET_INDEX_PAGE = "MainController: getIndex";
    public static final String FUNCTION_GET_REGISTRATION_PAGE = "MainController: getRegistration";
    public static final String FUNCTION_GET_AUTHORIZATION_PAGE = "MainController: getAuthorization";
    public static final String FUNCTION_GET_CHART_PAGE = "MainController: getChart";
    public static final String FUNCTION_GET_FLIGHTS = "FlightController: getFlights";
    public static final String FUNCTION_GET_FLIGHT = "FlightController: getFlight";
    public static final String FUNCTION_ADD_FLIGHT = "FlightController: addFlight";
    public static final String FUNCTION_DELETE_FLIGHT = "FlightController: deleteFlight";
    public static final String FUNCTION_EDIT_FLIGHT = "FlightController: editFlight";
    public static final String FUNCTION_GET_FLIGHT_MANAGEMENT_PAGE = "FlightController: manageFlight";
    public static final String FUNCTION_GET_CREATE_TEAM_PAGE = "TeamController: getCreateTeamPage";
    public static final String FUNCTION_GET_DELETE_TEAM_PAGE  = "TeamController: getDeleteTeamPage";
    public static final String FUNCTION_DELETE_TEAM = "TeamController: deleteTeam";
    public static final String FUNCTION_ADD_TEAM = "TeamController: addTeam";
    public static final String FUNCTION_APPOINT_TEAM = "TeamController: appointTeam";
    public static final String FUNCTION_GET_TEAMS_AND_FLIGHTS_PAGE = "TeamController: getTeamsAndFlights";
    public static final String FUNCTION_GET_USER_PAGE = "UserController: getUserPage";
    public static final String FUNCTION_REGISTRATION_USER = "UserController: registrationUser";
    public static final String FUNCTION_CONVERSION_TO_LIST = "Converter: convertToList";
    public static final String FUNCTION_CONVERSION_TO_LINE = "Converter: convertToLine";
    public static final String FUNCTION_VALIDATE_USER_DATA = "DataChecker: validateUserData";
    public static final String FUNCTION_DEFINE_USER_PAGE = "Definer: defineUserPage";
    public static final String SERVICE_FUNCTION_ADD_ENTITY = "GenericService: add";
    public static final String SERVICE_FUNCTION_UPDATE_ENTITY = "GenericService: update";
    public static final String SERVICE_FUNCTION_REMOVE_ENTITY = "GenericService: remove";
    public static final String SERVICE_FUNCTION_GET_ENTITY_BY_ID = "GenericService: getById";
    public static final String SERVICE_FUNCTION_GET_ALL_ENTITY = "GenericService: getAll";
    public static final String SERVICE_FUNCTION_CHECK_USER = "UserServiceImpl: checkUser";
    public static final String SERVICE_FUNCTION_ADD_USER = "UserServiceImpl: addUser";
    public static final String SERVICE_FUNCTION_GET_USER_ROLE = "UserServiceImpl: getUserRole";
    public static final String SERVICE_FUNCTION_GET_USER_ROLE_ID = "UserServiceImpl: getRoleUserId";
    public static final String SERVICE_FUNCTION_CREATE_TEAM = "TeamServiceImpl: createTeam";
    public static final String SERVICE_FUNCTION_SEND_MAIL = "MailServiceImpl: sendMail";
    public static final String SERVICE_FUNCTION_CREATE_FLIGHT = "FlightServiceImpl: createFlight";
    public static final String SERVICE_FUNCTION_REMOVE_FLIGHT = "FlightServiceImpl: deleteFlight";
    public static final String SERVICE_FUNCTION_CHANGE_FLIGHT_NAVIGATION = "FlightServiceImpl: changeFlightNavigation";
    public static final String SERVICE_FUNCTION_APPOINT_TEAM_TO_FLIGHT = "FlightServiceImpl: appointTeam";
    public static final String DAO_FUNCTION_ADD_ENTITY = "GenericDao: add";
    public static final String DAO_FUNCTION_UPDATE_ENTITY = "GenericDao: update";
    public static final String DAO_FUNCTION_REMOVE_ENTITY = "GenericDao: remove";
    public static final String DAO_FUNCTION_GET_ENTITY_BY_ID = "GenericDao: getById";
    public static final String DAO_FUNCTION_GET_ALL_USERS =  "UserDaoImpl: getAll";
    public static final String DAO_FUNCTION_GET_USER_BY_LOGIN_AND_PASSWORD =  "UserDaoImpl: getByLoginAndPassword";
    public static final String DAO_FUNCTION_GET_ALL_TEAMS =  "TeamDaoImpl: getAll";
    public static final String DAO_FUNCTION_GET_ALL_ROLES = "RoleDaoImpl: getAll";
    public static final String DAO_FUNCTION_GET_ALL_GENDERS = "GenderDaoImpl: getAll";
    public static final String DAO_FUNCTION_GET_ALL_FLIGHTS = "FlightDaoImpl: getAll";
    public static final String DAO_FUNCTION_GET_ALL_EMPLOYEES = "EmployeeDaoImpl: getAll";
    public static final String DAO_FUNCTION_GET_ALL_APPOINTMENTS = "AppointmentDaoImpl: getAll";
}

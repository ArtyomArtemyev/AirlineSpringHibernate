package by.netcracker.artemyev.exception;

/**
 * Class describes service exception
 *
 * @autor Artemyev Artoym
 */
public class ServiceException extends Exception {

    /**
     * Constructs a ServiceException with the given detail message.
     *
     * @param message The detail message of the ServiceException.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Constructs a ServiceException with the given root cause.
     *
     * @param cause The root cause of the ServiceException.
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a ServiceException with the given detail message and root cause.
     *
     * @param message The detail message of the ServiceException.
     * @param cause   The root cause of the ServiceException.
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}

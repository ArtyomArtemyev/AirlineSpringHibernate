package by.netcracker.artemyev.exception;

import org.hibernate.HibernateException;

/**
 * Class describes common dao exception
 * @autor Artemyev Artoym
 */
public class DaoException extends HibernateException {

    /**
     * Constructs a DaoException with the given detail message.
     *
     * @param message The detail message of the DaoException.
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Constructs a DaoException with the given root cause.
     *
     * @param cause The root cause of the DaoException.
     */
    public DaoException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a DaoException with the given detail message and root cause.
     *
     * @param message The detail message of the DaoException.
     * @param cause   The root cause of the DaoException.
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

}

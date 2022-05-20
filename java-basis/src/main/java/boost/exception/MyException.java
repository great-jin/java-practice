package boost.exception;

/**
 * 自定义异常类
 */
public class MyException extends RuntimeException {

    public MyException() {
        super();
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}

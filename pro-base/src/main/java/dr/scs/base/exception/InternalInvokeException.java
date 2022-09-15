package dr.scs.base.exception;

// 内部调用异常
public class InternalInvokeException extends RuntimeException {

  public InternalInvokeException(String message) {
    super(message);
  }

  public InternalInvokeException(String message, Throwable cause) {
    super(message, cause);
  }

  public InternalInvokeException(Throwable cause) {
    super(cause);
  }
}

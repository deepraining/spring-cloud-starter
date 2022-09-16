package dr.scs.base.exception;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import dr.scs.base.CommonResult;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

// 全局异常处理
// 注：把这个文件复制到每项目的主包名下，才能生效
// 或者启动时设置 `@SpringBootApplication(scanBasePackages = {"dr.scs"})`
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
  @ResponseBody
  @ExceptionHandler(value = ApiException.class)
  public CommonResult<Object> handle(ApiException e) {
    if (e.getErrorCode() != null) {
      return CommonResult.failed(e.getErrorCode());
    }
    return CommonResult.failed(e.getMessage());
  }

  @ExceptionHandler(value = MissingServletRequestParameterException.class)
  @ResponseBody
  public CommonResult<Object> errorHandler(
      MissingServletRequestParameterException ex, ServletWebRequest request) {
    log.error("请求缺失参数, url:{}", request.getRequest().getRequestURI());
    log.error("请求Method:{}", request.getRequest().getMethod());
    log.error(ExceptionUtils.getStackTrace(ex));
    return CommonResult.validateFailed(ExceptionUtils.getRootCauseMessage(ex));
  }

  @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
  @ResponseBody
  public CommonResult<Object> errorHandler(
      HttpRequestMethodNotSupportedException ex, ServletWebRequest request) {
    log.error("请求Method不支持, url:{}", request.getRequest().getRequestURI());
    log.error("需要:{}, 实际是:{}", ex.getSupportedMethods()[0], request.getRequest().getMethod());
    log.error(ExceptionUtils.getStackTrace(ex));
    return CommonResult.validateFailed(ExceptionUtils.getRootCauseMessage(ex));
  }

  @ExceptionHandler(value = HystrixRuntimeException.class)
  @ResponseBody
  public CommonResult<Object> errorHandler(HystrixRuntimeException ex) {
    log.error(ExceptionUtils.getStackTrace(ex));
    if (ex.getFallbackException() != null) {
      return CommonResult.failed(ex.getFallbackException().getCause().getCause().getMessage());
    }
    return CommonResult.failed(ExceptionUtils.getRootCauseMessage(ex));
  }

  @ExceptionHandler(value = InternalInvokeException.class)
  @ResponseBody
  public CommonResult<Object> errorHandler(InternalInvokeException ex) {
    log.error(ExceptionUtils.getStackTrace(ex));
    return CommonResult.failed(ex.getMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseBody
  public CommonResult<Object> handleConstraintViolationException(ConstraintViolationException cve) {
    cve.printStackTrace();
    log.error(ExceptionUtils.getStackTrace(cve));
    Set<ConstraintViolation<?>> consSet = cve.getConstraintViolations();
    if (!CollectionUtils.isEmpty(consSet)) {
      return CommonResult.validateFailed(consSet.iterator().next().getMessage());
    }
    return CommonResult.validateFailed();
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public CommonResult<Object> handleException(Exception ex) {
    log.error(ExceptionUtils.getStackTrace(ex));
    return CommonResult.failed(ExceptionUtils.getRootCauseMessage(ex));
  }

  @ExceptionHandler(Throwable.class)
  @ResponseBody
  public CommonResult<Object> handleThrowableException(Throwable ex) {
    log.error(ExceptionUtils.getStackTrace(ex));
    return CommonResult.failed(ExceptionUtils.getRootCauseMessage(ex));
  }
}

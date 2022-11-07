package com.sonhaenono.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.sonhaenono.exception.ApiException;
import com.sonhaenono.exception.ApiExceptionEntity;
import com.sonhaenono.exception.ExceptionEnum;

@RestControllerAdvice
public class ApiExceptionAdvice {
	
	/**
	 * API 에러 핸들링입니다.
	 * 아래의 경우로 에러를 발생하면 해당 예외처리기에서 클라이언트로 응답합니다.
	 * 
	 * ex)
	 * throw new ApiException(ExceptionEnum.RUNTIME_EXCEPTION);
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ApiException.class})
	public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final ApiException e) {
		return new ResponseEntity<ApiExceptionEntity>(
					new ApiExceptionEntity(
							e.getError().getStatus(),
							e.getError().getCode(),
							e.getError().getMessage()
						),
					e.getError().getStatus()
				);
		
	}
	
	/**
	 * 존재하지 않는 API에 대한 기본 메세지 처리입니다. 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({NoHandlerFoundException.class})
	public ResponseEntity<ApiExceptionEntity> notFoundExceptionHandler(final NoHandlerFoundException exception) {
		exception.printStackTrace();
		
		ApiException e = new ApiException(ExceptionEnum.API_NOT_EXIST_EXCEPTION);
		return new ResponseEntity<ApiExceptionEntity>(
				new ApiExceptionEntity(
						e.getError().getStatus(),
						e.getError().getCode(),
						e.getError().getMessage()
					),
				e.getError().getStatus()
			);
	}
	
	/**
	 * 런타임 예외에 대한 처리입니다.
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<ApiExceptionEntity> runTimeExceptionHanlder(HttpServletRequest request, final RuntimeException exception) {
		exception.printStackTrace();
		
		ApiException e = new ApiException(ExceptionEnum.RUNTIME_EXCEPTION);
		return new ResponseEntity<ApiExceptionEntity>(
				new ApiExceptionEntity(
						e.getError().getStatus(),
						e.getError().getCode(),
						e.getError().getMessage()
					),
				e.getError().getStatus()
			);
	}
	/**
	 * 경로는 있으나 메서드가 다를 경우 405 예외를 리턴합니다.
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
	public ResponseEntity<ApiExceptionEntity> runTimeExceptionHanlder(HttpServletRequest request, final HttpRequestMethodNotSupportedException exception) {
		exception.printStackTrace();
		
		ApiException e = new ApiException(ExceptionEnum.API_METHOD_NOT_ALLOWED_EXCEPTION);
		return new ResponseEntity<ApiExceptionEntity>(
				new ApiExceptionEntity(
						e.getError().getStatus(),
						e.getError().getCode(),
						e.getError().getMessage()
					),
				e.getError().getStatus()
			);
	}
	/**
	 * 전체 예외에 대한 기본 처리입니다.
	 * @param request
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({Exception.class})
	public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest request, final Exception exception) {
		exception.printStackTrace();
		
		ApiException e = new ApiException(ExceptionEnum.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ApiExceptionEntity>(
				new ApiExceptionEntity(
						e.getError().getStatus(),
						e.getError().getCode(),
						e.getError().getMessage()
					),
				e.getError().getStatus()
			);
	}
}

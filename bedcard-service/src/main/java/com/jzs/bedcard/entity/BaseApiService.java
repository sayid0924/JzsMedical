package com.jzs.bedcard.entity;


import com.jzs.bedcard.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseApiService {

	@Autowired
	protected BaseRedisService baseRedisService;

	// 返回错误，可以传msg
	public ResponseBase setResultError(String msg) {
		return setResult(Constants.HTTP_RES_CODE_500, msg, null);
	}

	// 返回成功，可以传data值
	public ResponseBase setResultSuccess(Object data) {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, data);
	}

	// 返回成功，沒有data值
	public ResponseBase setResultSuccess() {
		return setResult(Constants.HTTP_RES_CODE_200, Constants.HTTP_RES_CODE_200_VALUE, null);
	}

	// 返回成功，沒有data值
	public ResponseBase setResultSuccess(String msg) {
		return setResult(Constants.HTTP_RES_CODE_200, msg, null);
	}

	// 通用封装
	public ResponseBase setResult(Integer code, String msg, Object data) {
		return new ResponseBase(code, msg, data);
	}

}
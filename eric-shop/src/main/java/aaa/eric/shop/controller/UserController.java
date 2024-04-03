/*
 * Copyright (c) 2018-2999 广州市蓝海创新科技有限公司 All rights reserved.
 *
 * https://www.mall4j.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package aaa.eric.shop.controller;

import aaa.eric.shop.ServerResponseEntity;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author lanhai
 */
@RestController
@RequestMapping("/p/user")
//@Tag(name = "用户接口")
//@AllArgsConstructor
public class UserController {

//	private final UserService userService;

	@Resource(name = "jsonRedisTemplate")
	private RedisTemplate<String, String> redisTemplate;
	private static RedisTemplate<String, String> staticRedisTemplate;

	@PostConstruct
	public void init() {
		staticRedisTemplate = redisTemplate;
	}

	/**
	 * 查看用户接口
	 */
	@GetMapping("/userInfo")
	public ServerResponseEntity<String> userInfo(int userId) {
		String src = String.valueOf(userId) + System.currentTimeMillis();
//		String token = DigestUtil.md5(src);
//		logger.info("生成token，userId:{}，token:{}", userId, token);
		redisTemplate.opsForValue().set("123", "token");
		return ServerResponseEntity.success("userDto");
	}
	
//	/**
//	 * 查看用户接口
//	 */
//	@GetMapping("/userInfo")
//	@Operation(summary = "查看用户信息" , description = "根据用户ID（userId）获取用户信息")
//	public ServerResponseEntity<UserDto> userInfo() {
//		String userId = SecurityUtils.getUser().getUserId();
//		User user = userService.getById(userId);
//		UserDto userDto = BeanUtil.copyProperties(user, UserDto.class);
//		return ServerResponseEntity.success(userDto);
//	}
//
//	@PutMapping("/setUserInfo")
//	@Operation(summary = "设置用户信息" , description = "设置用户信息")
//	public ServerResponseEntity<Void> setUserInfo(@RequestBody UserInfoParam userInfoParam) {
//		String userId = SecurityUtils.getUser().getUserId();
//		User user = new User();
//		user.setUserId(userId);
//		user.setPic(userInfoParam.getAvatarUrl());
//		user.setNickName(userInfoParam.getNickName());
//		userService.updateById(user);
//		return ServerResponseEntity.success();
//	}
}

package com.melodyrent.websocket;
import org.springframework.messaging.handler.annotation.MessageMapping; import org.springframework.messaging.handler.annotation.SendTo; import org.springframework.stereotype.Controller; import java.util.Map;
@Controller
public class NotificationSocketController { @MessageMapping("/availability/ping") @SendTo("/topic/availability") public Map<String,String> ping(Map<String,String> message){ return Map.of("type","PONG","message", message.getOrDefault("message","live")); } }

package com.samplejava.springboot.controller;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.Map;
import org.springframework.ai.openai.OpenAiChatClient;

@RestController
@RequestMapping("/text")
public class TextAiController {

	private final OpenAiChatClient chatClient;

	@Autowired
	public TextAiController(OpenAiChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@Operation(summary = "Generate text using OpenAI ChatClient")
	@GetMapping("/generate")
	public ResponseEntity<Map<String, String>> generate(@Parameter(description = "Message for chat generation") @RequestParam(value = "message", defaultValue = "List ten biggest countries in the world") String message) {
		String generation = chatClient.call(message);
		return ResponseEntity.ok().body(Map.of("generation", generation));
	}

	@Operation(summary = "Chat with OpenAI ChatClient")
	@GetMapping("/generate/{question}")
	public ResponseEntity<Map<String, String>> chat(@Parameter(description = "Question for chat") @PathVariable String question) {
		String answer = chatClient.call(question);
		return ResponseEntity.ok().body(Map.of("question", question, "answer", answer));
	}

	@Operation(summary = "Chat with prompt using OpenAI ChatClient")
	@GetMapping("/chat-with-prompt")
	public ResponseEntity<Map<String, String>> chatWithPrompt(@Parameter(description = "Message for chat prompt") @RequestParam String message) {
		PromptTemplate promptTemplate = new PromptTemplate("Explain about the {message}");
		Prompt prompt = promptTemplate.create(Map.of("subject", message));
		ChatResponse response = chatClient.call(prompt);
		return ResponseEntity.ok().body(Map.of("answer", response.getResult().getOutput().getContent()));
	}
}
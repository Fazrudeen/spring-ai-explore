# spring-ai-explore
#### Text AI Controller

This controller provides endpoints for generating text and chatting using the OpenAI ChatClient.

</B>Endpoints Generate Text</B>
#### URL: 
/text/generate
#### Method: GET
#### Description: Generates text using the OpenAI ChatClient based on the provided message.
#### Parameters:
#### message (optional): Message for chat generation (default: "List ten biggest countries in the world")
#### Response:
generation: Generated text


<B>Chat</B>
#### URL: /text/generate/{question}
#### Method: GET
#### Description: I
nitiates a chat session with the OpenAI ChatClient based on the provided question.
#### Path Variables:
#### question: 
Question for chat
#### Response:
question: Provided question
answer: Response from the chat client


<B>Chat with Prompt</B>
#### URL: /text/chat-with-prompt
#### Method: GET
#### Description: 
Initiates a chat session with a prompt using the OpenAI ChatClient.
#### Parameters:
message: Message for chat prompt
#### Response:
answer: Response from the chat client based on the provided prompt message
Dependencies
#### OpenAiChatClient: 
Used for interacting with the OpenAI ChatClient.
Usage
Send requests to the specified endpoints to generate text or chat with the OpenAI ChatClient.

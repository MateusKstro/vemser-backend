package chatkafka.enums;

public enum Chats {


    CHAT_GERAL("chat-geral"),
    CHAT_MAICON("chat-maicon"),
    CHAT_LAZZARI("chat-lazzari"),
    CHAT_BRUNO("chat-bruno"),
    CHAT_CLEBER("chat-cleber"),
    CHAT_GABRIEL("chat-gabriel"),
    CHAT_JEAN("chat-jean"),
    CHAT_MACHADO("chat-machado"),
    CHAT_PAULO("chat-paulo"),
    CHAT_WILLIAN("chat-willian"),
    CHAT_RODRIGO("chat-rodrigo"),
    CHAT_CASTRO("chat-castro"),
    CHAT_CESAR("chat-cesar"),
    CHAT_DAYVIDSON("chat-dayvidson"),
    CHAT_RAFAEL("chat-rafael");

    private final String chatName;

    Chats(String chatName){
        this.chatName = chatName;
    }

    public String getChat(){
        return chatName;
    }
}


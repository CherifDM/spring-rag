package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.service.AssistantAiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantRessource {
    private final AssistantAiService assistantAiService;

    public AssistantRessource(AssistantAiService assistantAiService) {
        this.assistantAiService = assistantAiService;
    }

    @PostMapping("/assistants/chat")
    public String chat(@RequestBody String query) {
        return assistantAiService.chat(query);
    }
}

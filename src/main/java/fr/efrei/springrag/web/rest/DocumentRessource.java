package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.service.DocumentService;
import fr.efrei.springrag.domain.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class DocumentRessource {

    private final DocumentService documentService;

    public DocumentRessource(DocumentService documentService) {
        this.documentService = documentService;
    }


    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) throws URISyntaxException {
        Document result = documentService.buildAndSaveDocument(document);
        return ResponseEntity
                .created(new URI("/documents/" + result.getId()))
                .body(result);
    }

    @GetMapping("/documents")
    public ResponseEntity<List<Document>> findAllDocuments() throws URISyntaxException {
        List<Document> result = documentService.findAllDocuments();
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> findDocumentById(Long id) throws URISyntaxException {
        Optional<Document> result = documentService.findDocumentById(id);
        return ResponseEntity.of(result);
    }

    @DeleteMapping("/documents/delete/{id}")
    public void deleteDocument(Long id) throws URISyntaxException {
        documentService.deleteDocument(id);
    }

    @PostMapping("/documents/chat2/{user}")
    public String chat2(@RequestBody String query) throws InterruptedException {
        String result = documentService.chat(query);

        return result;
    }

}

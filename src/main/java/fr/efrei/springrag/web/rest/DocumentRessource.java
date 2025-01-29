package fr.efrei.springrag.web.rest;

import fr.efrei.springrag.DocumentService;
import fr.efrei.springrag.domain.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

//    @GetMapping("/documents")
//    public ResponseEntity<Document> findDocumentById(Long id) throws URISyntaxException {
//        Document result = documentService.findDocumentById(id);
//        return ResponseEntity
//                .ok()
//                .body(result);
//    }

//    @GetMapping("/documents")
//    public ResponseEntity<> deleteDocument(Long id) throws URISyntaxException {
//        documentService.deleteDocument(id);
//        return ResponseEntity.ok();
//    }

//    @PostMapping("/documents")
//    public ResponseEntity<Document> addDocument(RequestBody Document){
//        return "Hello";
//    }
//
//    @PostMapping
//    public ResponseEntity<Document> getDocument(@PathVariable(value = "value", response = false)) final String{
//        return "Hello";
//    }
}

package com.allen.photoAlbum.Service;

import com.allen.photoAlbum.Client.PhotoAlbumClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoAlbumService {

    @Autowired
    PhotoAlbumClient albumRetriever;

    @CrossOrigin
    @GetMapping("/getAlbumsMaster")
    public ResponseEntity getAlbums(){

        String string = "3";
        ResponseEntity response = albumRetriever.getPhotosMaster(string);
        return response;
    }
}

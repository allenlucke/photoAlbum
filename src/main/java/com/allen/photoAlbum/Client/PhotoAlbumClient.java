package com.allen.photoAlbum.Client;

import com.allen.photoAlbum.Model.Photo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotoAlbumClient {

    public ResponseEntity getPhotosMaster() throws JsonProcessingException {
        List photoList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String photosUrl
                = "https://jsonplaceholder.typicode.com/photos?albumId=3";

        ResponseEntity<Photo[]> responseEntity =
                restTemplate.getForEntity(photosUrl, Photo[].class);

        Photo[] photos = responseEntity.getBody();

        photoList = Arrays.stream(photos)
                .collect(Collectors.toList());

        Arrays.stream(photos).forEach(photo -> System.out.println("[" + photo.getId() + "] " + photo.getTitle()));

        return new ResponseEntity(photoList, HttpStatus.OK);
    }
}

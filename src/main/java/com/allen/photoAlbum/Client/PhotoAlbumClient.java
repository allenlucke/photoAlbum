package com.allen.photoAlbum.Client;

import com.allen.photoAlbum.Model.Photo;
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

    public ResponseEntity getPhotosMaster(final String albumId ) {
        String param = checkForAlbumId(albumId);
        List photoList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String photosUrl = "https://jsonplaceholder.typicode.com/photos" + param;

        ResponseEntity<Photo[]> responseEntity =
                restTemplate.getForEntity(photosUrl, Photo[].class);

        Photo[] photos = responseEntity.getBody();

        photoList = Arrays.stream(photos)
                .collect(Collectors.toList());

        Arrays.stream(photos).forEach(photo -> System.out.println("[" + photo.getId() + "] " + photo.getTitle()));

        return new ResponseEntity(photoList, HttpStatus.OK);
    }

    private String checkForAlbumId(final String albumId) {
        if(albumId == null || albumId.isBlank()) {
            return "";
        }
        else{
            return "?albumId=" + albumId.trim();
        }
    }
}

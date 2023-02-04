package com.allen.photoAlbum.Client;

import com.allen.photoAlbum.Model.Photo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotoAlbumClientImpl implements PhotoAlbumClient{

    public List<Photo> getPhotos(final String param) {
        List photoList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String photosUrl = "https://jsonplaceholder.typicode.com/photos" + param;

        ResponseEntity<Photo[]> responseEntity =
                restTemplate.getForEntity(photosUrl, Photo[].class);

        Photo[] photos = responseEntity.getBody();

        photoList = Arrays.stream(photos)
                .collect(Collectors.toList());

        return photoList;
    }
}

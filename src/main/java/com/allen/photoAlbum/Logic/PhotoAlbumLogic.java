package com.allen.photoAlbum.Logic;

import com.allen.photoAlbum.Client.PhotoAlbumClient;
import com.allen.photoAlbum.Model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoAlbumLogic {

    @Autowired
    private PhotoAlbumClient photoAlbumClient;

    public void printPhotos(final String albumId) {
        String param = checkForAlbumId(albumId);
        List <Photo> photoAlbumList = photoAlbumClient.getPhotos(param);

        for (Photo photo: photoAlbumList) {
            System.out.println("[" + photo.getId() + "] " + photo.getTitle());
        }
    }

    public String checkForAlbumId(final String albumId) {
        if(albumId == null || albumId.isBlank()) {
            return "";
        }
        else{
            return "?albumId=" + albumId.trim();
        }
    }
}

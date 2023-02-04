package com.allen.photoAlbum.Client;

import com.allen.photoAlbum.Model.Photo;

import java.util.List;

//@Service
public interface PhotoAlbumClient {
    List<Photo> getPhotos(final String param);
}

package com.allen.photoAlbum.Client;

import static org.assertj.core.api.Assertions.*;
import com.allen.photoAlbum.Model.Photo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class PhotoAlbumClientTest {

    @InjectMocks
    private PhotoAlbumClientImpl photoAlbumClient;

    private Photo photo;

    @Test
    public void testAlbumId3PassedAsParamsShouldHaveSizeOf50() {
        String params = "?albumId=3";
        List<Photo> photoList = photoAlbumClient.getPhotos(params);

        assertThat(photoList).isNotNull();
        assertThat(photoList.size()).isEqualTo(50);
    }

    @Test
    public void testNoAlbumIdPassedAsParamsShouldHaveSizeOf5000() {
        String params = "";
        List<Photo> photoList = photoAlbumClient.getPhotos(params);

        assertThat(photoList).isNotNull();
        assertThat(photoList.size()).isEqualTo(5000);
    }

    @Test
    public void testRandomCharsPassedAsParamShouldReturnAnEmptyList() {
        String params = "?albumId=afg";
        List<Photo> photoList = photoAlbumClient.getPhotos(params);

        assertThat(photoList).isEmpty();
        assertThat(photoList.size()).isEqualTo(0);
    }
}

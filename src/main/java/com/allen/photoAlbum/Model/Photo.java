package com.allen.photoAlbum.Model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Photo implements Serializable {
    private @Getter @Setter Integer albumId;
    private @Getter @Setter Integer id;
    private @Getter @Setter String title;
    private @Getter @Setter String url;
    private @Getter @Setter String thumbnailUrl;

}
